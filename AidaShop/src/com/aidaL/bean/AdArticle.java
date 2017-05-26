package com.aidaL.bean;

import java.util.ArrayList;
import java.util.List;



/**
 * AdArticle entity. @author MyEclipse Persistence Tools
 */

public class AdArticle  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 8944663828457062966L;
	private Integer arId;
     private Integer UId;
     private String arTitle;
     private String arMain;
     private Integer arReadCount;
     private Integer arLikeCount;
     private Integer arHateCount;
     
     //add by myself
     private List<AdProductInfo> good = new ArrayList<AdProductInfo>();
     private List<String> path = new ArrayList<String>();
     private String digest;


    // Constructors

    /** default constructor */
    public AdArticle() {
    }

	/** minimal constructor */
    public AdArticle(Integer UId, String arTitle, String arMain) {
        this.UId = UId;
        this.arTitle = arTitle;
        this.arMain = arMain;
    }
    
    /** full constructor */
    public AdArticle(Integer UId, String arTitle, String arMain, Integer arReadCount, Integer arLikeCount, Integer arHateCount) {
        this.UId = UId;
        this.arTitle = arTitle;
        this.arMain = arMain;
        this.arReadCount = arReadCount;
        this.arLikeCount = arLikeCount;
        this.arHateCount = arHateCount;
    }

   
    // Property accessors

    public Integer getArId() {
        return this.arId;
    }
    
    public void setArId(Integer arId) {
        this.arId = arId;
    }

    public Integer getUId() {
        return this.UId;
    }
    
    public void setUId(Integer UId) {
        this.UId = UId;
    }

    public String getArTitle() {
        return this.arTitle;
    }
    
    public void setArTitle(String arTitle) {
        this.arTitle = arTitle;
    }

    public String getArMain() {
        return this.arMain;
    }
    
    public void setArMain(String arMain) {
        this.arMain = arMain;
    }

    public Integer getArReadCount() {
        return this.arReadCount;
    }
    
    public void setArReadCount(Integer arReadCount) {
        this.arReadCount = arReadCount;
    }

    public Integer getArLikeCount() {
        return this.arLikeCount;
    }
    
    public void setArLikeCount(Integer arLikeCount) {
        this.arLikeCount = arLikeCount;
    }

    public Integer getArHateCount() {
        return this.arHateCount;
    }
    
    public void setArHateCount(Integer arHateCount) {
        this.arHateCount = arHateCount;
    }

	public List<AdProductInfo> getGood() {
		return good;
	}

	public void setGood(List<AdProductInfo> good) {
		this.good = good;
	}

	public List<String> getPath() {
		return path;
	}

	public void setPath(List<String> path) {
		this.path = path;
	}

	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}
   








}