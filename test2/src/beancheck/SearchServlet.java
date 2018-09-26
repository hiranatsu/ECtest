package beancheck;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBConnector.DBConnector;

import Beans.BaseBean;

public class SearchServlet extends HttpServlet {
    protected void doPost( HttpServletRequest req, HttpServletResponse res )
                             throws ServletException, IOException{
    	
    	DBConnector db = new DBConnector();
    	Connection con = db.getConnection();
    	BaseBean  bbean = new BaseBean();
    	
    	public BaseBean getBasebeaninfo(){
        	String sql="SELECT * FROM identity_infomation";
        	
        	try{
        		PreparedStatement ps = con.prepareStatement(sql);
        		ResultSet rs = ps.executeQuery();
        		
        		if(rs.next()){
        			bbean.setUserName(rs.getString("user_name"));
        		}
        	}
    	}




    	
    	
        String Address = req.getParameter("Address");

        HashMap<String, String> Base = new HashMap<String,String>();

        Base.put("TaroSato", Address);
        Base.put("HanakoYamada", Address);
        Base.put("IchiroSuzuki", Address);

        List<BaseBean> listBase = new ArrayList<BaseBean>();

        for (String key : Base.keySet()) {
            BaseBean bean = new BaseBean();

            bean.setUserName(key);
            bean.setAddress(Base.get(key));

            listBase.add(bean);

        }

        req.setAttribute("listBase", listBase);

        RequestDispatcher dispatch = req.getRequestDispatcher("./BeanCheck.jsp");

        dispatch.forward(req, res);
    }
}