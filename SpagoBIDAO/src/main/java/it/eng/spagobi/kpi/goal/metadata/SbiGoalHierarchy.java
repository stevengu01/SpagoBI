/* SpagoBI, the Open Source Business Intelligence suite

 * Copyright (C) 2012 Engineering Ingegneria Informatica S.p.A. - SpagoBI Competency Center
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0, without the "Incompatible With Secondary Licenses" notice. 
 * If a copy of the MPL was not distributed with this file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package it.eng.spagobi.kpi.goal.metadata;

// Generated 6-dic-2010 11.29.21 by Hibernate Tools 3.2.4.GA

import it.eng.spagobi.commons.metadata.SbiHibernateModel;

import java.util.HashSet;
import java.util.Set;

/**
 * SbiGoalHierarchy generated by hbm2java
 */
public class SbiGoalHierarchy extends SbiHibernateModel {

	private int goalHierarchyId;
	private SbiGoalHierarchy sbiGoalHierarchy;
	private int orgUnitId;
	private int goalId;
	private String name;
	private String label;
	private String goal;
	private Set sbiGoalKpis = new HashSet(0);
	private Set sbiGoalHierarchies = new HashSet(0);

	public SbiGoalHierarchy() {
	}

	public SbiGoalHierarchy(SbiGoalHierarchy sbiGoalHierarchy,
			int orgUnitId, int goalId, String name, String label, String goal) {
		this.sbiGoalHierarchy = sbiGoalHierarchy;
		this.orgUnitId = orgUnitId;
		this.goalId = goalId;
		this.name = name;
		this.label = label;
		this.goal = goal;
	}

	public SbiGoalHierarchy(SbiGoalHierarchy sbiGoalHierarchy,
			int orgUnitId, int goalId, String name, String label, String goal,
			Set sbiGoalKpis, Set sbiGoalHierarchies) {
		this.sbiGoalHierarchy = sbiGoalHierarchy;
		this.orgUnitId = orgUnitId;
		this.goalId = goalId;
		this.name = name;
		this.label = label;
		this.goal = goal;
		this.sbiGoalKpis = sbiGoalKpis;
		this.sbiGoalHierarchies = sbiGoalHierarchies;
	}

	public int getGoalHierarchyId() {
		return this.goalHierarchyId;
	}

	public void setGoalHierarchyId(int goalHierarchyId) {
		this.goalHierarchyId = goalHierarchyId;
	}

	public SbiGoalHierarchy getSbiGoalHierarchy() {
		return this.sbiGoalHierarchy;
	}

	public void setSbiGoalHierarchy(SbiGoalHierarchy sbiGoalHierarchy) {
		this.sbiGoalHierarchy = sbiGoalHierarchy;
	}

	public int getOrgUnitId() {
		return this.orgUnitId;
	}

	public void setOrgUnitId(int orgUnitId) {
		this.orgUnitId = orgUnitId;
	}

	public int getGoalId() {
		return this.goalId;
	}

	public void setGoalId(int goalId) {
		this.goalId = goalId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getGoal() {
		return this.goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public Set getSbiGoalKpis() {
		return this.sbiGoalKpis;
	}

	public void setSbiGoalKpis(Set sbiGoalKpis) {
		this.sbiGoalKpis = sbiGoalKpis;
	}

	public Set getSbiGoalHierarchies() {
		return this.sbiGoalHierarchies;
	}

	public void setSbiGoalHierarchies(Set sbiGoalHierarchies) {
		this.sbiGoalHierarchies = sbiGoalHierarchies;
	}

}