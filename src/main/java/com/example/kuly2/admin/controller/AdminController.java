package com.example.kuly2.admin.controller;

import com.example.kuly2.admin.Dto.AdminDto;
import com.example.kuly2.admin.Dto.ProductDto;
import com.example.kuly2.admin.service.ProductService;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
@Controller
public class AdminController {

    private final ProductService productService;
//    private final ProductDto productDto;

//    public AdminController(ProductService productService) {
//        this.productService = productService;
//    }

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

        return "admin/product/productListView";
    }

//    /** 내용 : 관리자 - 상품 목록 리스트 -상세목록 조회 - 상품 수정하기 */
//    @GetMapping("admin/productList/productListViewUpdate")
//    public String memberListViewUpdate(@RequestParam("no") int product_no, Model model){
//        ProductDto productViewUpdate = productService.productListViewUpdate(product_no);
//        model.addAttribute("productViewUpdate", productViewUpdate);
//
//           System.out.println("Controller product_no =" + product_no);
//           System.out.println("Controller productViewUpdate = " + productViewUpdate);
//
//        return "admin/product/productListViewUpdate";
//
//    }
    /** 내용 : 관리자 - 상품 목록 리스트 -상세목록 조회 - 상품 수정하기 */
    @GetMapping("admin/productList/productListViewUpdate")
    public String memberListViewUpdate(@RequestParam("no") int product_no, Model model){
        productService.productListViewUpdate(product_no);
        ProductDto productViewUpdate = productService.memberListView(product_no);
        model.addAttribute("productViewUpdate", productViewUpdate);

        return "admin/product/productListViewUpdate";

    }

    /** */
//    @GetMapping("admin/productList/productListViewUpdateEnd")
//    public String memberListViewUpdateEnd(@RequestParam("no") int product_no, ProductDto productDto, Model model){
//        int productListView = productService.saveGet(productDto);
//        productService.saveGet(productDto);
//        model.addAttribute("productViewUpdate", productListView);
//
//        System.out.println("Controller productService.saveGet(productDto) = " + productService.saveGet(productDto));
//        System.out.println("Controller productListView = " + productListView);
////        System.out.println("Controller productViewUpdate = " + ProductDto.class);
//        ProductRepository.save(ProductEntity.builder().product_no(product_no).build());
//
//        return "redirect:/admin/product/productListView";
//        }

//        @GetMapping("admin/productList/productListViewUpdateEnd")
//        public int save(@RequestBody ProductDto productDto){
//            return productService.save(productDto);
//        }
//    @GetMapping("admin/productList/productListViewUpdateEnd")
//    public String productListViewUpdate(@RequestParam("no") int product_no, ProductDto productDto, Model model){
//
//        return ProductRepository.save(ProductEntity.builder().product_no(product_no).build());;
//
//    }

    @GetMapping("/")                 /* default page = 0, size = 10  */
    public String index(Model model, @PageableDefault(sort = "id", direction = Sort.Direction.DESC)
            Pageable pageable, @LoginUser UserDto.Response user) {
        Page<Posts> list = postsService.pageList(pageable);

        if (user != null) {
            model.addAttribute("user", user);
        }

        model.addAttribute("posts", list);
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next", pageable.next().getPageNumber());
        model.addAttribute("hasNext", list.hasNext());
        model.addAttribute("hasPrev", list.hasPrevious());

        return "admin/productList";
    }


    /* 글 작성 */
    @GetMapping("/posts/write")
    public String write(@LoginUser UserDto.Response user, Model model) {
        if (user != null) {
            model.addAttribute("user", user);
        }
        return "posts/posts-write";
    }



    /** 내용 : 관리자 - 상품 목록 리스트 - 상품목록 -> 상품 삭제하기 */
    @GetMapping("admin/productList/productDelete")
    public String productListDelete(@RequestParam("no") int product_no){
        productService.productDelete(product_no);

        return "redirect:/admin/productList";
    }



}
