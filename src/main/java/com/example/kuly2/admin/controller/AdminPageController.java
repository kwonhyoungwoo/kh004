package com.example.kuly2.admin.controller;

import com.example.kuly2.admin.Dto.ProductDto;
import com.example.kuly2.admin.entity.ProductEntity;
import com.example.kuly2.admin.service.ProductService;
import com.example.kuly2.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminPageController {

    @Autowired
    ProductService productService;
    @Autowired
    MemberService memberService;


    /** 내용 : 관리자 - 메인 페이지  */
    @RequestMapping("/main")
    public String adminIndex(){
        return "admin/index";
    }

    // 상품 목록 + 페이징
    @GetMapping("/product/list")
    public String list(Model model, @PageableDefault(direction = Sort.Direction.DESC, size = 20) Pageable pageable) {
        Page<ProductDto> productDtos = productService.findAll(pageable);

        // 현재 페이지
        int pageNumber = productDtos.getPageable().getPageNumber();
        // 총 페이지
        int totalPages = productDtos.getTotalPages();
        int pageBlock = 5;
        int startBlockPage  = ((pageNumber)/pageBlock)*pageBlock + 1;
        int endBlockPage = startBlockPage+pageBlock - 1;
        endBlockPage = totalPages < endBlockPage ? totalPages : endBlockPage;

        model.addAttribute("productList", productDtos.getContent());
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("totalPages",totalPages);
        model.addAttribute("startBlockPage",startBlockPage);
        model.addAttribute("endBlockPage", endBlockPage);

        return "admin/product/productList";
    }

    // 상품 추가 페이지 이동
    @GetMapping("/product/insert")
    public String productInsertPage(){
        return "admin/product/productInsert";
    }

    // 상품 상세 페이지 이동
    @GetMapping("/product/detail/{id}")
    public String detail(@PathVariable Long id, Model model) {
        ProductDto productDto = productService.findById(id);

        model.addAttribute("product", productDto);
        return "admin/product/productDetail";
    }

    /** 내용 : 관리자 - 상품 상세보기에서 상품 수정 페이지로 이동 */
    @GetMapping("/product/toUpdate/{product_no}")
        public String productListToUpdate(@PathVariable Long product_no, Model model){
        ProductEntity toUpdate = productService.toUpdate(product_no);
        model.addAttribute("toUpdate", toUpdate);

        return "admin/product/productUpdate";

    }

}