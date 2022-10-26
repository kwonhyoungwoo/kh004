package com.example.kuly2.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

    @RequestMapping("/admin")
    public String adminIndex(){
        return "views/admin/index";
    }

    @RequestMapping("/admin/memberList")
    public String memberListView(){
        return "views/admin/member/memberList";
    }

    @RequestMapping("/admin/productList")
    public String productListView(){
        return "views/admin/product/productList";
    }


    @RequestMapping("/admin/adminLogin")
    public String adminMemberLoginView(){
        return "views/admin/member/adminLogin";
    }

}
