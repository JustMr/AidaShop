package com.aidaL.dao;

import java.util.List;

import com.aidaL.bean.BrandAD;

public interface AdBrandDAO {
	/**
	 *根据id查找品牌
	 *@param id 需要查找的品牌id
	 */
	BrandAD get(Integer id);
	
	/**
	 * 增加品牌
	 * @param brand 需要增加的品牌
	 */
	void save(BrandAD brand);
	
	/**
	 * 修改品牌
	 * @param brand 需要修改的品牌
	 */
	void update(BrandAD brand);
	
	 /**

     * 删除品牌

     * @param id 需要删除的品牌id

     */ 
    void delete(Integer id);

    /**

     * 删除品牌

     * @param user 需要删除的品牌

     */ 
    void delete(BrandAD brand);

    /**

     * 查询全部品牌

     * @return 获得全部品牌

     */
    List<BrandAD> findAll();

    /**

     * 通过Id查询品牌

     * @return 获得品牌

     */
    BrandAD findBrandById(Integer id);
    
    /**

     * 通过brName查询品牌

     * @return 获得品牌

     */
    BrandAD findBrandByName(String brName);

    /**
     * 通过店铺ID查询申请的品牌列表
     * @param stId 店铺ID
     * @return 该店铺请的品牌列表
     */
	List<BrandAD> findBrandByStId(Integer stId);

	/**
	 * 获得申请中的品牌列表
	 * @return 申请中的品牌列表
	 */
	List<BrandAD> findBrandAuth();

	/**
	 * 显示中文名称和英文名称已通过审核的相同的品牌
	 * @param brName 中文名称
	 * @param brEngName 英文名称
	 * @return 已通过审核的相同的品牌
	 */
	List<BrandAD> findBrandAuthByName(String brName, String brEngName);
}
