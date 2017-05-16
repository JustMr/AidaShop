package com.aidaL.action;

import java.util.ArrayList;
import java.util.List;

import com.aidaL.bean.AdProductcategory;
import com.aidaL.service.ActionManager;
import com.aidaL.util.Json;

public class PCategoryAction extends BaseAction {

	private static final long serialVersionUID = -1748184759103231583L;
	
	private ActionManager pcatemgr;
	private AdProductcategory pcate;
	private List<AdProductcategory> pcates = new ArrayList<AdProductcategory>();
	private Integer cgId;
	private Integer cgPid;
	private String cgName;
	private Integer count;
	private Integer cgPosition;
	private Integer cgState;
	private Integer only;

	
	/**
	 * 标签位置下移
	 */
	public void downward() {
		Json json = new Json();
		pcate = this.pcatemgr.findPCategoryById(cgId);
		if (count==1) {
			boolean bottom = this.pcatemgr.judgeFirstLast(pcate.getCgPosition(), pcate.getCgState());
			System.out.println("bottom:"+bottom);
			if (bottom==true) {
				if (pcate.getCgState()==1) {
					//到达最低端
					json.setMsg("bottom");
					json.setSuccess(false);
				}else {
					Integer position = pcate.getCgPosition()+1;
					pcate.setCgPosition(position);
					pcate.setCgState(1);
					this.pcatemgr.saveOrUpdatePCategory(pcate);
				}
			}else {
				//获取下一个分类
				AdProductcategory last = this.pcatemgr.judgeFirstLastState(pcate.getCgPosition(), pcate.getCgState());
				System.out.println("last,pcate:"+last.getCgPosition()+","+pcate.getCgPosition()+","+last.getCgState());
				Integer prePosi = pcate.getCgPosition();
				Integer nextPosi = last.getCgPosition();
				//调换当前分类和下一个分类位置
				if(prePosi.equals(nextPosi)) {
					//相邻的两个为同一行
					System.out.println("下移1");
					Integer state = pcate.getCgState();
					pcate.setCgState(last.getCgState());
					last.setCgState(state);
					this.pcatemgr.saveOrUpdatePCategory(last);
					this.pcatemgr.saveOrUpdatePCategory(pcate);
					json.setMsg("ok");
					json.setSuccess(true);
				}else {
					//相邻的两个为不同行
					if (pcate.getCgState()==1) {
						System.out.println("下移2");
						//需要移动的该行只有一个元素
						this.pcatemgr.UpdateState(last.getCgPosition(), 1);
						this.pcatemgr.BackwardPosition(pcate.getCgPosition());
					}else{
						System.out.println("下移3");
						//需要移动的该行的元素超过一个
						pcate.setCgPosition(last.getCgPosition());
						pcate.setCgState(1);
						this.pcatemgr.UpdateState(last.getCgPosition(), 1);
						this.pcatemgr.saveOrUpdatePCategory(pcate);
					}
					json.setMsg("ok");
					json.setSuccess(true);
				}
			}
		}else {
			AdProductcategory last = this.pcatemgr.judgeLast(pcate.getCgPid(),pcate.getCgPosition());
			if (last==null) {
				//到达最低端
				json.setMsg("bottom");
				json.setSuccess(false);
			}else {
				//调换当前分类和下一个分类位置
				Integer position = pcate.getCgPosition();
				pcate.setCgPosition(last.getCgPosition());
				last.setCgPosition(position);
				this.pcatemgr.saveOrUpdatePCategory(last);
				this.pcatemgr.saveOrUpdatePCategory(pcate);
				json.setMsg("ok");
				json.setSuccess(true);
			}
		}
		writeJson(json);
	}
	
	/**
	 * 标签位置上移
	 */
	public void upward() {
		Json json = new Json();
		pcate = this.pcatemgr.findPCategoryById(cgId);
		if (count==1) {
			if (pcate.getCgPosition()==1 && pcate.getCgState() ==1) {
				//已经到达最顶端
				json.setMsg("top");
				json.setSuccess(false);
			}else {
				AdProductcategory pre = this.pcatemgr.judgeFirstPre(pcate.getCgPosition(), pcate.getCgState());
				Integer prePosi = pre.getCgPosition();
				Integer nextPosi = pcate.getCgPosition();
				if (prePosi.equals(nextPosi)) {
					//两个为同行
					Integer state = pcate.getCgState();
					pcate.setCgState(pre.getCgState());
					pre.setCgState(state);
					this.pcatemgr.saveOrUpdatePCategory(pre);
					this.pcatemgr.saveOrUpdatePCategory(pcate);
				}else {
					//相邻的两个为不同行
					if (only==1) {
						//需要移动的该行只有一个元素
						this.pcatemgr.BackwardPosition(pcate.getCgPosition());
					}else {
						//需要移动的该行的元素超过一个
						this.pcatemgr.deleteFirstMove(pcate.getCgPosition(), 1);
					}
					pcate.setCgPosition(pre.getCgPosition());
					pcate.setCgState(pre.getCgState()+1);
					this.pcatemgr.saveOrUpdatePCategory(pcate);
				}
				json.setMsg("ok");
				json.setSuccess(true);
			}
		}else {
			if (pcate.getCgPosition()==1) {
				//已经到达最顶端
				json.setMsg("top");
				json.setSuccess(false);
			}else {
				AdProductcategory pre = this.pcatemgr.judgePre(pcate.getCgPid(),pcate.getCgPosition());
				//调换当前分类和上一个分类位置
				Integer position = pcate.getCgPosition();
				pcate.setCgPosition(pre.getCgPosition());
				pre.setCgPosition(position);
				this.pcatemgr.saveOrUpdatePCategory(pre);
				this.pcatemgr.saveOrUpdatePCategory(pcate);
				json.setMsg("ok");
				json.setSuccess(true);
			}
		}
		writeJson(json);
	}
	
	/**
	 * 重命名
	 */
	public void rename() {
		Json json = new Json();
		pcate = this.pcatemgr.findPCategoryById(cgId);
		pcate.setCgName(cgName);
		this.pcatemgr.saveOrUpdatePCategory(pcate);
		json.setSuccess(true);
		writeJson(json);
	}
	
	/**
	 * 删除标签
	 */
	public void delete() {
		Json json = new Json();
		pcate = this.pcatemgr.findPCategoryById(cgId);
		if (count==1) {
			this.pcatemgr.deleteFirstMove(pcate.getCgPosition(), pcate.getCgState());
			pcates = this.pcatemgr.findLvOneOrThree(cgId);
			Integer cgPidDel;
			for (int i = 0; i < pcates.size(); i++) {
				cgPidDel = pcates.get(i).getCgId();
				this.pcatemgr.deletePCategoryByPID(cgPidDel);
			}
			this.pcatemgr.deletePCategoryByPID(cgId);
			this.pcatemgr.deletePCategory(pcate);
			json.setSuccess(true);
		}else if (count==2) {
			this.pcatemgr.deleteMove(pcate.getCgPid(), pcate.getCgPosition());
			this.pcatemgr.deletePCategoryByPID(cgId);
			this.pcatemgr.deletePCategory(pcate);
			json.setSuccess(true);
		}else if (count==3) {
			this.pcatemgr.deleteMove(pcate.getCgPid(), pcate.getCgPosition());
			this.pcatemgr.deletePCategory(pcate);
			json.setSuccess(true);
		}
		System.out.println(json.isSuccess());
		writeJson(json);
	}

	/**
	 * 添加标签
	 */
	public void add() {
		System.out.println("add:"+cgName+","+count);
		Json json = new Json();
		json.setSuccess(true);
		AdProductcategory cate = new AdProductcategory();
		cate.setCgName(cgName);
		if (count==1) {
			cate.setCgLevel(0);
			cate.setCgPosition(cgPosition);
			cate.setCgState(cgState);
			this.pcatemgr.UpdateState(cgPosition,cgState);
		}else if (count==2) {
			cate.setCgLevel(1);
			cate.setCgPid(cgPid);
			cate.setCgPosition(cgPosition);
			cate.setCgState(1);
			this.pcatemgr.UpdatePosition(cgPid,cgPosition);
		}else if (count==3) {
			cate.setCgLevel(2);
			cate.setCgPid(cgPid);
			cate.setCgPosition(cgPosition);
			cate.setCgState(1);
			this.pcatemgr.UpdatePosition(cgPid,cgPosition);
		}
		this.pcatemgr.addPCategory(cate);
		
		writeJson(json);
	}
	
	/**
	 * 显示第二或第三级菜单通过父标签名称
	 */
	public void listLvTowOrThree() {
		Json json = new Json();
		pcate = this.pcatemgr.findPCategoryByName(cgName);
//		System.out.println("getCgPid:"+pcate.getCgId());
		pcates = this.pcatemgr.findLvOneOrThree(pcate.getCgId());
//		System.out.println("pcates:"+pcates);
		if (pcates != null) {
			json.setMsg("查询成功");
			json.setObj(pcates);
			json.setSuccess(true);
		}else {
			json.setMsg("查询失败");
			json.setSuccess(false);
		}
		
		writeJson(json);
	}
	
	public void listLvTowOrThreeByPID() {
		Json json = new Json();
		pcates = this.pcatemgr.findLvOneOrThree(cgPid);
//		System.out.println("pcates:"+pcates);
		if (pcates != null) {
			json.setMsg("查询成功");
			json.setObj(pcates);
			json.setSuccess(true);
		}else {
			json.setMsg("查询失败");
			json.setSuccess(false);
		}
		
		writeJson(json);
	}
	
	/**
	 * 显示所有的第一级商品分类
	 */
	public void listLvOne() {
		Json json = new Json();
		pcates = this.pcatemgr.findLvOne();
		json.setMsg("查询成功");
		json.setObj(pcates);
		json.setSuccess(true);
		
		writeJson(json);
	}
	
	public ActionManager getPcatemgr() {
		return pcatemgr;
	}

	public void setPcatemgr(ActionManager pcatemgr) {
		this.pcatemgr = pcatemgr;
	}

	public AdProductcategory getPcate() {
		return pcate;
	}

	public void setPcate(AdProductcategory pcate) {
		this.pcate = pcate;
	}

	public List<AdProductcategory> getPcates() {
		return pcates;
	}

	public void setPcates(List<AdProductcategory> pcates) {
		this.pcates = pcates;
	}

	public Integer getCgId() {
		return cgId;
	}

	public void setCgId(Integer cgId) {
		this.cgId = cgId;
	}

	public Integer getCgPid() {
		return cgPid;
	}

	public void setCgPid(Integer cgPid) {
		this.cgPid = cgPid;
	}

	public String getCgName() {
		return cgName;
	}

	public void setCgName(String cgName) {
		this.cgName = cgName;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getCgPosition() {
		return cgPosition;
	}

	public void setCgPosition(Integer cgPosition) {
		this.cgPosition = cgPosition;
	}

	public Integer getCgState() {
		return cgState;
	}

	public void setCgState(Integer cgState) {
		this.cgState = cgState;
	}

	public Integer getOnly() {
		return only;
	}

	public void setOnly(Integer only) {
		this.only = only;
	}

	
}
