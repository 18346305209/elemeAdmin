package com.company.view.impl;

import com.company.dao.BusinessDao;
import com.company.dao.impl.BusinessDaoImpl;
import com.company.view.BusinessView;

import com.company.domain.Business;
import com.company.view.BusinessView;

import java.util.List;
import java.util.Scanner;

public class BusinessViewImpl implements BusinessView {
    Scanner input= new Scanner(System.in);

    @Override
    //全部商家
    public void listBusinessAll() {
        BusinessDaoImpl dao = new BusinessDaoImpl();
        List<Business> list = dao.listBusiness(null, null);
        System.out.println("商家编号\t商家名称\t商家地址\t商家介绍\t起送费\t配送费");
        for (Business b :list){
            System.out.println(b.getBusinessId()+"\t"+b.getBusinessName()+"\t"+b.getBusinessAddress()+"\t"+b.getBusinessExplain()+"\t"+b.getStartPrice()+"\t"+b.getDeliveryPrice());
        }
    }
    //搜索商家

    public void listBusinessBySearch(){

        String businessAddress = "";
        String businessName = "";
        String scanner = "";
        System.out.println("是否需要输入商家名称关键字(y/n):");
        scanner = input.next();
        if(scanner.equals("y")) {
            System.out.println("请输入商家名称关键字：");
            businessName = input.next();
        }
        System.out.println("是否需要输入商家地址关键字(y/n):");
        scanner = input.next();
        if(scanner.equals("y")) {
            System.out.println("请输入商家名称关键字：");
            businessAddress = input.next();
        }
        BusinessDaoImpl dao = new BusinessDaoImpl();
        List<Business> businesses = dao.listBusiness(businessName, businessAddress);
        System.out.println("商家编号\t商家名称\t商家地址\t商家介绍\t起送费\t配送费");
        for (Business b :businesses){
            System.out.println(b.getBusinessId()+"\t"+b.getBusinessName()+"\t"+b.getBusinessAddress()+"\t"+b.getBusinessExplain()+"\t"+b.getStartPrice()+"\t"+b.getDeliveryPrice());
        }

    }

    @Override
    public void saveBusiness() {
        BusinessDao dao = new BusinessDaoImpl();

        System.out.println("请输入商家的名称");
        String businessname =input.next();
        int businessId = dao.saveBusiness(businessname);
        if(businessId>0)
        {
            System.out.println("新建成功您的商家id为"+businessId);
        }else
        {
            System.out.println("新建失败");
        }
    }

    @Override
    public void deleteBusiness() {

        System.out.println("请输入要删除的商家ID");
        int id = input.nextInt();
        BusinessDao dao = new BusinessDaoImpl();
        System.out.println("确认删除吗(y/n)");
        String y = input.next();
        if (y.equals("y")) {
            dao.deleteBussiness(id);
            System.out.println("删除完毕");
        }else
        {
            System.out.println("取消成功");
        }

    }


}
