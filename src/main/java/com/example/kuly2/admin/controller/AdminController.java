package com.example.kuly2.admin.controller;

import com.example.kuly2.admin.Dto.ProductDto;
import com.example.kuly2.admin.service.ProductService;
import com.example.kuly2.member.MemberService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


/**
 * 작성자 : 정지수
 * 내용  :  관리자 컨트롤러
 */
@Controller
public class AdminController {

    private final ProductService productService;
    private final MemberService memberService;

    public AdminController(ProductService productService, MemberService memberService) {
        this.productService = productService;
        this.memberService = memberService;
    }

    /** 내용 : 관리자 - 메인 페이지  */
    @RequestMapping("/admin")
    public String adminIndex(){
        return "admin/index";
    }

    /** 내용 : 관리자 - 회원리스트 조회 뷰  */
    // TODO 함수이름 재설정 필요 (이름이 겹칩니다.)
    @RequestMapping("/admin/memberList")
    public String memberListView2(Model model){
        // model에 모든 멤버 정보 추가
        model.addAttribute("memberList", memberService.getAllMembers());
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

    /** 내용 : 관리자 - 상품 목록 리스트 에서 상세목록 조회 페이지 (미완성) */
    @GetMapping("/admin/productList/productListView")
    public String memberListView(Model model){
        ProductDto productListViewDto = productService.memberListView();
        model.addAttribute("productListView", productListViewDto);
        return "admin/product/productListView";
    }
}
