package com.aidaL.bean;
// default package

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;


/**
 * BrandAD entity. @author MyEclipse Persistence Tools
 */

public class BrandAD  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 4378256884689904513L;
	private Integer brId;
     private String brName;
     private Integer brState;
     private String brEngName;
     private String brDiscription;
     private Timestamp brApplyTime;
     private Timestamp brEnterTime;
     private Integer brLevelGrand;
     private Integer stId;
     private Set<?> adProductInfos = new HashSet<Object>(0);


    // Constructors

    /** default constructor */
    public BrandAD() {
    }

	/** minimal constructor */
    public BrandAD(Integer brId, String brName) {
        this.brId = brId;
        this.brName = brName;
    }
    
    /** full constructor */
    public BrandAD(Integer brId, String brName, Integer brState, String brEngName, String brDiscription, Timestamp brApplyTime, Timestamp brEnterTime, Integer brLevelGrand, Integer stId, Set<?> adProductInfos) {
        this.brId = brId;
        this.brName = brName;
        this.brState = brState;
        this.brEngName = brEngName;
        this.brDiscription = brDiscription;
        this.brApplyTime = brApplyTime;
        this.brEnterTime = brEnterTime;
        this.brLevelGrand = brLevelGrand;
        this.stId = stId;
        this.adProductInfos = adProductInfos;
    }

   
    // Property accessors

    public Integer getBrId() {
        return this.brId;
    }
    
    public void setBrId(Integer brId) {
        this.brId = brId;
    }

    public String getBrName() {
        return this.brName;
    }
    
    public void setBrName(String brName) {
        this.brName = brName;
    }

    public Integer getBrState() {
        return this.brState;
    }
    
    public void setBrState(Integer brState) {
        this.brState = brState;
    }

    public String getBrEngName() {
        return this.brEngName;
    }
    
    public void setBrEngName(String brEngName) {
        this.brEngName = brEngName;
    }

    public String getBrDiscription() {
        return this.brDiscription;
    }
    
    public void setBrDiscription(String brDiscription) {
        this.brDiscription = brDiscription;
    }

    public Timestamp getBrApplyTime() {
        return this.brApplyTime;
    }
    
    public void setBrApplyTime(Timestamp brApplyTime) {
        this.brApplyTime = brApplyTime;
    }

    public Timestamp getBrEnterTime() {
        return this.brEnterTime;
    }
    
    public void setBrEnterTime(Timestamp brEnterTime) {
        this.brEnterTime = brEnterTime;
    }

    public Integer getBrLevelGrand() {
        return this.brLevelGrand;
    }
    
    public void setBrLevelGrand(Integer brLevelGrand) {
        this.brLevelGrand = brLevelGrand;
    }

    public Integer getStId() {
        return this.stId;
    }
    
    public void setStId(Integer stId) {
        this.stId = stId;
    }

    public Set<?> getAdProductInfos() {
        return this.adProductInfos;
    }
    
    public void setAdProductInfos(Set<?> adProductInfos) {
        this.adProductInfos = adProductInfos;
    }
   








}