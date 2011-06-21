/**
 * SpagoBI - The Business Intelligence Free Platform
 *
 * Copyright (C) 2004 - 2008 Engineering Ingegneria Informatica S.p.A.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.

 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 * 
 **/
package it.eng.qbe.statement.jpa;


import it.eng.qbe.statement.hibernate.HQL2SQLStatementRewriter;

import java.util.StringTokenizer;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.eclipse.persistence.internal.jpa.EJBQueryImpl;
import org.eclipse.persistence.jpa.JpaEntityManager;
import org.eclipse.persistence.queries.DatabaseQuery;
import org.eclipse.persistence.sessions.DatabaseRecord;
import org.eclipse.persistence.sessions.Session;


/**
 * The Class HqlToSqlQueryRewriter.
 * 
 * @author Giachino, Alberto Ghedin (alberto.ghedin@eng.it)
 */
public class JPQL2SQLStatementRewriter {
	
	/** The entity manager. */
	private EntityManager entityManager;
	
	/** Logger component. */
    public static transient Logger logger = Logger.getLogger(JPQL2SQLStatementRewriter.class);
	
	
	/**
	 * Instantiates a new hql to sql query rewriter.
	 * 
	 * @param session the session
	 */
	public JPQL2SQLStatementRewriter(EntityManager em) {
		this.entityManager = em;
	}
	
	/* (non-Javadoc)
	 * @see it.eng.qbe.export.IQueryRewriter#rewrite(java.lang.String)
	 */
	public String rewrite(String query) {
		if(this.entityManager instanceof org.eclipse.persistence.jpa.JpaEntityManager){
			return rewriteEclipseLink(query);
		} else{ 
			return rewriteHibernate(query);
		} 
	}
	
	public String rewrite(Query query) {
		if(this.entityManager instanceof org.eclipse.persistence.jpa.JpaEntityManager){
			return rewriteEclipseLink(query);
		} else{ 
			return rewriteHibernate(query);
		} 
	}
	
	
	/**
	 * Rewrite the JPQL query string in a SQL String (The persistence provider implementation in use is EclipseLink) 
	 * @param query The String of the JPQL query
	 * @return the string of the JPQL query translated in SQL
	 */
	private String rewriteEclipseLink(String query) {
		EJBQueryImpl qi = (EJBQueryImpl) this.entityManager.createQuery(query);
		return rewriteEclipseLink(qi);
	}
	
	/**
	 * Rewrite the JPQL query in a SQL String (The persistence provider implementation in use is EclipseLink) 
	 * @param query The JPQL query
	 * @return the string of the JPQL query translated in SQL
	 */
	private String rewriteEclipseLink(Query query) {
		EJBQueryImpl qi = (EJBQueryImpl) query;
		Session session = this.entityManager.unwrap(JpaEntityManager.class).getActiveSession();
		DatabaseQuery databaseQuery = (qi).getDatabaseQuery();
		databaseQuery.prepareCall(session, new DatabaseRecord());
		String sqlString = databaseQuery.getTranslatedSQLString(session,  new DatabaseRecord());
		
		//ADD THE ALIAS in the select statement (necessary for the temporary table construction.. ex for the worksheet)
		int fromPosition = sqlString.indexOf("FROM");
		StringBuffer sqlQuery2 = new StringBuffer();
		String SelectStatement = sqlString.substring(0,fromPosition-1);
		StringTokenizer SelectStatementStk = new StringTokenizer(SelectStatement,",");
		int i=0;
		while(SelectStatementStk.hasMoreTokens()){
			sqlQuery2.append(SelectStatementStk.nextToken());
			sqlQuery2.append(" as alias");
			sqlQuery2.append(i);
			sqlQuery2.append(",");
			i++;
		}
		sqlQuery2.delete(sqlQuery2.length()-1,sqlQuery2.length());
		sqlQuery2.append(sqlString.substring(fromPosition-1));
		
		logger.debug("JPQL QUERY: "+sqlQuery2);
		
		return sqlQuery2.toString();	
	}

 
	/**
	 * Rewrite the JPQL query string in a SQL String (The persistence provider implementation in use is Hibernate) 
	 * @param query The String of the JPQL query
	 * @return the string of the JPQL query translated in SQL
	 */
	private String rewriteHibernate(String query) {
		org.hibernate.ejb.HibernateQuery qi = (org.hibernate.ejb.HibernateQuery)this.entityManager.createQuery(query);
		return rewriteHibernate(qi);
	}
	
	/**
	 * Rewrite the JPQL query in a SQL String (The persistence provider implementation in use is Hibernate) 
	 * @param query The JPQL query
	 * @return the string of the JPQL query translated in SQL
	 */
	private String rewriteHibernate(Query query) {
		org.hibernate.ejb.HibernateEntityManager em = (org.hibernate.ejb.HibernateEntityManager)this.entityManager;
		org.hibernate.ejb.HibernateQuery qi = (org.hibernate.ejb.HibernateQuery)(query);
		em.getSession();
		HQL2SQLStatementRewriter queryRewriter = new HQL2SQLStatementRewriter(em.getSession());
		String sqlQueryString = queryRewriter.rewrite( qi.getHibernateQuery().getQueryString());
		return sqlQueryString;
	}
	

}
