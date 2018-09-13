package com.internousdev.ecsite2.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite2.dao.BuyItemDAO;
import com.internousdev.ecsite2.dao.LoginDAO;
import com.internousdev.ecsite2.dto.BuyItemDTO;
import com.internousdev.ecsite2.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{

	private String loginUserId;
	private String loginPassword;
	public Map<String, Object> session;
	private LoginDAO lDAO = new LoginDAO();
	private LoginDTO lDTO = new LoginDTO();
	private BuyItemDAO biDAO = new BuyItemDAO();

	public String execute(){
		String result = ERROR;
		lDTO = lDAO.getLoginUserInfo(loginUserId, loginPassword);
		session.put("loginUser", lDTO);

		/*入力値からユーザ情報の検索を行う。
		 * ログイン認証が成功した場合、次の画面で「商品情報」が必要なため
		 * 商品情報を取得する。*/
		if(((LoginDTO) session.get("loginUser")).getLoginFlg()){
			result = SUCCESS;
			BuyItemDTO biDTO = biDAO.getBuyItemInfo();

			session.put("login_user_id",lDTO.getLoginId());
			session.put("id", biDTO.getId());
			session.put("buyItem_name", biDTO.getItemName());
			session.put("buyItem_price", biDTO.getItemPrice());

			return result;
		}
		return result;
	}

	public String getLoginUserId(){
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId){
		this.loginUserId = loginUserId;
	}

	public String getLoginPassword(){
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword){
		this.loginPassword = loginPassword;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}
