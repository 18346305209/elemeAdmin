package com.company.text;

import com.company.dao.AdminDao;
import com.company.dao.impl.AdminDaoImpl;
import com.company.domain.Admin;
import com.company.domain.Business;

public class TextAdmin {
    public static void main(String[] args) {
        AdminDao adminDao = new AdminDaoImpl();
        Admin admin = adminDao.getAdminByNameByPass("sunhao", "123");
        System.out.println(admin);
        Business business = new Business();
        business.getBusinessId();
    }
}
