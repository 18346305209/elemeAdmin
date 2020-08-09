package com.company.dao;

import com.company.domain.Business;

import java.util.List;

public interface BusinessDao {
//显示所有商家的列表
public List<Business> listBusiness(String businessName,String businessAddress);
    public int saveBusiness(String businessName);
    public void deleteBussiness(Integer businessId);

}
