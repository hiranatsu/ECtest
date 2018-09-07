package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.util.DBConnector;

public class BuyItemDAO {

	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	private BuyItemDTO BIDTO = new BuyItemDTO();

	public BuyItemDTO getBuyItemInfo(){
		String sql = "SELECT id, item_name, item_price FROM item_info_transaction";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				BIDTO.setId(rs.getInt("id"));
				BIDTO.setItemName(rs.getString("item_name"));
				BIDTO.setItemPrice(rs.getString("item_price"));
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		return BIDTO;
	}
	public BuyItemDTO getBIDTO(){
		return BIDTO;
	}

}
