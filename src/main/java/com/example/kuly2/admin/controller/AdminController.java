package com.example.kuly2.admin.controller;

import com.example.kuly2.admin.Dto.ProductDto;
import com.example.kuly2.admin.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * 작성자 : 정지수
 * 내용  :  관리자 컨트롤러
 */
@Controller
public class AdminController {

    Logger logger = LoggerFactory.getLogger(getClass());

    private final ProductService productService;

    public AdminController(ProductService productService) {
        this.productService = productService;
    }

    /** 내용 : 관리자 - 메인 페이지  */
    @RequestMapping("/admin")
    public String adminIndex(){
        return "admin/index";
    }

    /** 내용 : 관리자 - 회원리스트 조회 뷰  */
    @RequestMapping("/admin/memberList")
    public String memberListView(){
        return "admin/member/memberList";
    }

    /** 내용 : 관리자 - 로그인 페이지  */
    @RequestMapping("/admin/adminLogin")
    public String adminMemberLoginView(){
        return "admin/member/adminLogin";
    }

    /** 내용 : 관리자 - 상품 목록 리스트 조회페이지 */
    @GetMapping("/admin/productList")
    public String memberList(Model model) {
        List<ProductDto> productDtos = productService.memberList();
        model.addAttribute("productList", productDtos);
        return "admin/product/productList";
    }

    /** 내용 : 관리자 - 상품 목록 리스트 에서 상세목록 조회 페이지 */
    @GetMapping("/admin/productList/productListView")
    public String memberListView(@RequestParam("no") int product_no, Model model){
        ProductDto productListViewDto = productService.memberListView(product_no);
        model.addAttribute("productListView", productListViewDto);

//        System.out.println("Controller product_no =" + product_no);
//        System.out.println("Controller productListViewDto = " + productListViewDto);

        return "admin/product/productListView";
    }


}
