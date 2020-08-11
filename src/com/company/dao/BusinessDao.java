package com.company.dao;

import com.company.domain.Business;

import java.util.List;

public interface BusinessDao {
//显示所有商家的列表
public List<Business> listBusiness(String businessName,String businessAddress);
    public int saveBusiness(String businessName);
    public int deleteBussiness(Integer businessId);

    public Business getBusinessByNameByPass(Integer businessId, String password);

    public Business getBusinessByBusinessId(Integer businessId);

    public int updateBusiness( Business business);
    public int updateBusinessPassword(Integer businessId,String password);

}
