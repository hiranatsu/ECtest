package com.internousdev.ecsite2.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.MyPageDAO;
import com.internousdev.ecsite2.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware{
	public Map<String, Object> session;
	private MyPageDAO mpDAO = new MyPageDAO();
	private ArrayList<MyPageDTO> mpList = new ArrayList<MyPageDTO>();
	private String deleteFlg;
	private String message;

	public String execute() throws SQLException{
		if(!session.containsKey("id")){
			return ERROR;
		}

		//履歴の削除がされているか否か、チェックをする。
		if(deleteFlg == null){
			//DBから取得した履歴情報をmpListに格納。
			String item_transaction_id = session.get("id").toString();
			String user_master_id = session.get("login_user_id").toString();
			mpList = mpDAO.getMyPageUserInfo(item_transaction_id, user_master_id);

		}else if(deleteFlg.equals("1")){
			//deleteメソッドを呼び出して、履歴の削除処理を行う。
			delete();
		}

		String result = SUCCESS;
		return result;
	}

	//履歴の削除を行うためのメソッド。
	public void delete() throws SQLException{
		String item_transaction_id = session.get("id").toString();
		String user_master_id = session.get("login_user_id").toString();

		//DBから削除した履歴情報の件数を、resに格納している。
		int res = mpDAO.buyItemHistoryDelete(item_transaction_id, user_master_id);

		//1件以上削除されたか否かで正常に削除処理がされたかを判別している。
		if(res > 0){
			mpList = null;
			setMessage("商品を正しく削除しました。");
		}else if(res == 0){
			setMessage("商品の削除にしっぱいしました。");
		}
	}

	public void setDeleteFlg(String deleteFlg){
		this.deleteFlg =deleteFlg;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

	public ArrayList<MyPageDTO> getMyPageList(){
		return this.mpList;
	}

	public String getMessage(){
		return this.message;
	}

	public void setMessage(String message){
		this.message = message;
	}


}
