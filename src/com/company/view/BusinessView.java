package com.company.view;

import com.company.domain.Business;

public interface BusinessView {
    public void listBusinessAll();
    public void listBusinessBySearch();
    public void saveBusiness();
    public void deleteBusiness();



    public Business login();
    // 显示商家信息
    public void showBusinessInfo(Integer businessId);

    // 修改商家信息
    public void updateBusinessInfo(Integer businessId);
    //修改密码
    public void updateBusinessPassword(Integer businessId);

}
