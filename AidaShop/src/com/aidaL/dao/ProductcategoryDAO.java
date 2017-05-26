package com.aidaL.dao;

import java.util.List;

import com.aidaL.bean.AdProductcategory;

public interface ProductcategoryDAO {
	/**
	 *根据id查找商品分类
	 *@param id 需要查找的商品分类id
	 */
	AdProductcategory get(Integer id);
	
	/**
	 * 增加商品分类
	 * @param cate 需要增加的商品分类
	 */
	void save(AdProductcategory cate);
	
	/**
	 * 修改商品分类
	 * @param cate 需要修改的商品分类
	 */
	void update(AdProductcategory cate);
	
	 /**

     * 删除商品分类

     * @param id 需要删除的商品分类id

     */ 
    void delete(Integer id);

    /**

     * 删除商品分类

     * @param user 需要删除的商品分类

     */ 
    void delete(AdProductcategory cate);

    /**

     * 查询全部商品分类

     * @return 获得全部商品分类

     */
    List<AdProductcategory> findAll();

    /**

     * 通过Id查询商品分类

     * @return 获得商品分类

     */
    AdProductcategory findcateById(Integer id);
    
    /**

     * 通过cgName查询商品分类

     * @return 获得商品分类

     */
    AdProductcategory findcateByName(String cgName);
    
    /**
     * 查找所有的一级菜单分类
     * @return 获得一级菜单分类
     */
    List<AdProductcategory> findLvOne();
    
    /**
     * 查找所有对应上一级的二级或三级菜单分类
     * @return 获取对应上一级的二级或三级菜单分类
     */
    List<AdProductcategory> findLvTwoOrThree(Integer cgPid);

    /**
     * 添加标签，新添加的标签需要将当前state值与之后的值都加一
     * @param cgPosition 新标签所在行
     * @param cgState 新标签所在列
     */
	void UpdateState(Integer cgPosition, Integer cgState);

	/**
	 * 添加标签，修改新标签当前位置及以后标签的位置加一
	 * @param cgPid 新标签的父标签
	 * @param cgPosition 新标签位置
	 */
	void UpdatePosition(Integer cgPid, Integer cgPosition);
	
	/**
	 * 二三级删除删除标签时候的位置改变位置
	 * @param cgPosition 大于等于该位置需要减一
	 */
	void deleteMove(Integer cgPid, Integer cgPosition);
	
	/**
	 * 一级删除删除标签时候的位置改变位置
	 * @param cgPosition 该标签所在行
	 * @param cgState 大于等于该位置需要减一
	 */
	void deleteFirstMove(Integer cgPosition, Integer cgState);

	/**
	 * 通过父ID来删除该标签
	 * @param cgPid 父ID
	 */
	void deletePCategoryByPID(Integer cgPid);

	/**
	 * 判断第一级分类是否已经是最后一个位置的标签
	 * @param cgPosition 标签所在行
	 * @param cgState 标签所在列
	 * @return 是最后一个位置的标签返回true，否返回false
	 */
	boolean judgeFirstLast(Integer cgPosition, Integer cgState);

	/**
	 * 判断第一级分类是否在该行的最后一个位置
	 * @param cgPosition 标签所在行
	 * @param cgState 标签所在列
	 * @return 返回下一个标签
	 */
	AdProductcategory judgeFirstLastState(Integer cgPosition, Integer cgState);

	/**
	 * 获得二三级分类是否在该行的最后一个位置
	 * @param cgPid 父标签ID
	 * @param cgPosition 标签所在行
	 * @return 返回下一个标签
	 */
	AdProductcategory judgeLast(Integer cgPid, Integer cgPosition);

	/**
	 * 获得第一级分类在该行的前一个位置
	 * @param cgPosition 标签所在行
	 * @param cgState 标签所在列
	 * @return 返回上一个标签
	 */
	AdProductcategory judgeFirstPre(Integer cgPosition, Integer cgState);

	/**
	 * 获得二三级分类在该行的前一个位置
	 * @param cgPid 父标签ID
	 * @param cgPosition 标签所在行
	 * @return 返回上一个标签
	 */
	AdProductcategory judgePre(Integer cgPid, Integer cgPosition);

	/**
	 * 一级分类当该行仅为一个元素时
	 * @param cgPosition 前一个分类的位置
	 */
	void BackwardPosition(Integer cgPosition);

	/**
	 * 模糊查询
	 * @param pName
	 * @return
	 */
	List<AdProductcategory> findPcategoryByUnSureName(String pName);
}
