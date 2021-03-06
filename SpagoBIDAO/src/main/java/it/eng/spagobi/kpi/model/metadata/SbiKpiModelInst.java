/* SpagoBI, the Open Source Business Intelligence suite

 * Copyright (C) 2012 Engineering Ingegneria Informatica S.p.A. - SpagoBI Competency Center
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0, without the "Incompatible With Secondary Licenses" notice. 
 * If a copy of the MPL was not distributed with this file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package it.eng.spagobi.kpi.model.metadata;
// Generated 5-nov-2008 17.17.20 by Hibernate Tools 3.1.0 beta3

import it.eng.spagobi.commons.metadata.SbiHibernateModel;
import it.eng.spagobi.kpi.config.metadata.SbiKpiInstance;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * SbiKpiModelInst generated by hbm2java
 */

public class SbiKpiModelInst  extends SbiHibernateModel {


    // Fields    
	
     private Integer kpiModelInst;
     private SbiKpiInstance sbiKpiInstance; //KPI
     private SbiKpiModel sbiKpiModel;
     private SbiKpiModelInst sbiKpiModelInst; // MODEL_INST
     private String name;
     private String description;
 	 private Date startDate;
 	 private Date endDate;
     private Set sbiKpiModelInsts = new HashSet(0);
     private Set sbiKpiModelResourceses = new HashSet(0);
     private String label;
     private String modelUUID; // Label of model instance to reference
     private Set sbiKpiError = new HashSet(0);

    // Constructors

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	/** default constructor */
    public SbiKpiModelInst() {
    this.kpiModelInst = -1;
    }

	/** minimal constructor */
    public SbiKpiModelInst(Integer kpiModelInst) {
        this.kpiModelInst = kpiModelInst;
    }
    
    /** full constructor */
    public SbiKpiModelInst(Integer kpiModelInst, SbiKpiInstance sbiKpiInstance, SbiKpiModel sbiKpiModel, SbiKpiModelInst sbiKpiModelInst, String name, String description, Set sbiKpiModelInsts, Set sbiKpiModelResourceses) {
        this.kpiModelInst = kpiModelInst;
        this.sbiKpiInstance = sbiKpiInstance;
        this.sbiKpiModel = sbiKpiModel;
        this.sbiKpiModelInst = sbiKpiModelInst;
        this.name = name;
        this.description = description;
        this.sbiKpiModelInsts = sbiKpiModelInsts;
        this.sbiKpiModelResourceses = sbiKpiModelResourceses;
    }
    

   
    // Property accessors

    public Integer getKpiModelInst() {
        return this.kpiModelInst;
    }
    
    public void setKpiModelInst(Integer kpiModelInst) {
        this.kpiModelInst = kpiModelInst;
    }

    public SbiKpiInstance getSbiKpiInstance() {
        return this.sbiKpiInstance;
    }
    
    public void setSbiKpiInstance(SbiKpiInstance sbiKpiInstance) {
        this.sbiKpiInstance = sbiKpiInstance;
    }
    
    public SbiKpiModel getSbiKpiModel() {
		return sbiKpiModel;
	}

	public void setSbiKpiModel(SbiKpiModel sbiKpiModel) {
		this.sbiKpiModel = sbiKpiModel;
	}

    public SbiKpiModelInst getSbiKpiModelInst() {
        return this.sbiKpiModelInst;
    }
    
    public void setSbiKpiModelInst(SbiKpiModelInst sbiKpiModelInst) {
        this.sbiKpiModelInst = sbiKpiModelInst;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public Set getSbiKpiModelInsts() {
        return this.sbiKpiModelInsts;
    }
    
    public void setSbiKpiModelInsts(Set sbiKpiModelInsts) {
        this.sbiKpiModelInsts = sbiKpiModelInsts;
    }

    public Set getSbiKpiModelResourceses() {
        return this.sbiKpiModelResourceses;
    }
    
    public void setSbiKpiModelResourceses(Set sbiKpiModelResourceses) {
        this.sbiKpiModelResourceses = sbiKpiModelResourceses;
    }

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setModelUUID(String modelUUID) {
		this.modelUUID = modelUUID;
	}

	public String getModelUUID() {
		return modelUUID;
	}

	public Set getSbiKpiError() {
		return sbiKpiError;
	}

	public void setSbiKpiError(Set sbiKpiError) {
		this.sbiKpiError = sbiKpiError;
	}

	
	
}
