package com.company.dao.impl;

import com.company.dao.BusinessDao;
import com.company.dao.BusinessDao;
import com.company.domain.Business;
import com.company.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BusinessDaoImpl implements BusinessDao {
    private Connection conn =null;
    private PreparedStatement pstmt =null;
    private ResultSet rs =null;
    int id = 0 ;

    @Override
    public List<Business> listBusiness(String businessName, String businessAddress) {
        List<Business> list = new ArrayList<>();
        StringBuffer sql = new StringBuffer("select * from business where 1=1");
        if (businessName != null && !businessName.equals("")){
            // 传入了商家名
            sql.append(" and businessName like '%").append(businessName).append("%' ");

        }
        if (businessAddress != null && !businessAddress.equals("")){
            // 传入了商家名
            sql.append(" and businessAddress like '%").append(businessAddress).append("%' ");

        }
        try{
            conn = JDBCUtils.getConnection();
            pstmt = conn.prepareStatement(sql.toString());
            rs = pstmt.executeQuery();
            while (rs.next()){
                Business business = new Business();
                business.setBusinessId(rs.getInt(1));
                business.setPassword(rs.getString(2));
                business.setBusinessName(rs.getString(3));
                business.setBusinessAddress(rs.getString(4));
                business.setBusinessExplain(rs.getString(5));
                business.setStartPrice(rs.getDouble(6));
                business.setDeliveryPrice(rs.getDouble(7));
                list.add(business);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,pstmt,conn);
        }
        return list;
    }

    @Override
    public int saveBusiness(String businessName) {
        try {
            conn = JDBCUtils.getConnection();
            String spl="insert into business(businessName, password)values(?, '123456')";
             pstmt = conn.prepareStatement(spl,PreparedStatement.RETURN_GENERATED_KEYS);
             pstmt.setString(1,businessName);
             pstmt.executeUpdate();
             rs = pstmt.getGeneratedKeys();
             if(rs.next())
             { id = rs.getInt(1);
             }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,pstmt,conn);
        }

        return id;
    }

    @Override
    public void deleteBussiness(Integer businessId) {
        try {
            conn = JDBCUtils.getConnection();
   String sql ="delete from  business where businessId = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,businessId);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt,conn);
        }
    }


}
