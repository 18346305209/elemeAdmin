package com.company.text;

import com.company.dao.AdminDao;
import com.company.dao.impl.AdminDaoImpl;
import com.company.domain.Admin;

public class TextAdmin {
    public static void main(String[] args) {
        AdminDao adminDao = new AdminDaoImpl();
        Admin admin = adminDao.getAdminByNameByPass("扬州宁", "250");
        System.out.println(admin);
    }
}
