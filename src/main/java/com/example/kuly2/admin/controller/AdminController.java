package com.example.kuly2.admin.controller;

import com.example.kuly2.admin.Dto.ProductDto;
import com.example.kuly2.admin.entity.ProductEntity;
import com.example.kuly2.admin.service.ProductService;
import com.example.kuly2.member.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 작성자 : 정지수
 * 내용  :  관리자 컨트롤러
 */
@AllArgsConstructor
@Controller
public class AdminController {

    private final ProductService productService;
    private final MemberService memberService;


    /** 내용 : 관리자 - 메인 페이지  */
    @RequestMapping("/admin")
    public String adminIndex(){
        return "admin/index";
    }

    /** 내용 : 관리자 - 회원리스트 조회 뷰  */
    @RequestMapping("/admin/memberList")
    public String memberListView(Model model){
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
        List<ProductDto> productDtos = productService.productList();
        model.addAttribute("productList", productDtos);

        return "admin/product/productList";
    }


    /** 내용 : 관리자 - 상품 목록 리스트 에서 상세목록 조회 페이지 */
    @GetMapping("/admin/productList/productListView/{product_no}")
    public String productListView(@PathVariable Long product_no, Model model){
        ProductEntity productListViewDto = productService.productListView(product_no);
        model.addAttribute("productListView", productListViewDto);

        return "admin/product/productListView";
    }


    /** 내용 : 관리자 - 상품 상세보기에서 상품 수정 페이지로 이동 */
    @GetMapping("/admin/productList/productListToUpdate/{product_no}")
    public String productListToUpdate(@PathVariable Long product_no, Model model){
        ProductEntity productListToUpdate = productService.productListViewToUpdate(product_no);
        model.addAttribute("productListToUpdate", productListToUpdate);

        return "admin/product/productListViewUpdate";

    }

    /** 내용 : 관리자 - 상품 상세보기 - 상품 수정 페이지 - 상품 수정하기 */
    @PostMapping("admin/productList/productListViewUpdate/{product_no}")
    public String productListViewUpdate(@PathVariable Long product_no, ProductDto productDto, Model model){
        productService.productListUpdate(product_no , productDto);

        ProductEntity productViewUpdate = productService.productListView(product_no);
        model.addAttribute("productViewUpdate", productViewUpdate);

        return "admin/product/productList";

    }


    /** 내용 : 관리자 - 상품 목록 추가 페이지 이동 */
    @RequestMapping("/admin/productList/productListInsertView")
    public String productListInsertView(){
        return "admin/product/productListInsertView";
    }


    /** 내용 : 상품 추가 */
    @PostMapping("/admin/productList/productListInsert")
    public String productListInsert(ProductDto productDto) {
        productService.productListInsert(productDto);

        return "redirect:/admin/productList";
    }


    /** 내용 : 관리자 - 상품 목록 리스트 - 상품 목록 -> 상품 삭제하기 */
    @DeleteMapping("/admin/productList/productDelete/{product_no}")
    public String productListDelete(@PathVariable Long product_no){
        productService.productDelete(product_no);

        return "redirect:/admin/product/productList";
    }


}
