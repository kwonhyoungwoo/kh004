package com.example.kuly2.admin.controller;

import com.example.kuly2.admin.Dto.ProductDto;
import com.example.kuly2.admin.service.ProductService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AdminApiController {

    private ProductService productService;

    AdminApiController(ProductService productService) {
        this.productService = productService;
    }

    //상품 리스트 페이징
    @GetMapping("/product")
    public List<ProductDto> findAll(@PageableDefault(sort = "id", direction = Sort.Direction.DESC, size = 20) Pageable pageable) {
        return productService.findAll(pageable).getContent();
    }
    
    //상품 등록
    @PostMapping("/product")
    public Long save(@RequestPart("productDto") ProductDto productDto,
                     @RequestPart("file") MultipartFile file,
                     HttpServletRequest req) throws IOException {
        String PATH = req.getSession().getServletContext().getRealPath("/");

        if(!file.getOriginalFilename().isEmpty())
          //  file.transferTo(new File("C:\\FinalProject\\src\\main\\resources\\static\\image\\upload\\" + file.getOriginalFilename()));
        file.transferTo(new File("C:\\Users\\cruel\\OneDrive\\바탕 화면\\kh004\\src\\main\\resources\\static\\image" + file.getOriginalFilename()));

        return productService.saveWithImage(productDto, file);
    }
    
    //상품 삭제
    @DeleteMapping("/product/{id}")
    public Long delete(@PathVariable final Long id) {
        return productService.delete(id);
    }

    //상품 수정
    @PatchMapping("/product/{id}")
    public Long update(@PathVariable final Long id ,
                       @RequestPart("productDto") ProductDto productDto,
                       @RequestPart("file") MultipartFile file,
                       HttpServletRequest req) throws IOException {
        String PATH = req.getSession().getServletContext().getRealPath("/");

        if(!file.getOriginalFilename().isEmpty())
            file.transferTo(new File("C:\\FinalProject\\src\\main\\resources\\static\\image\\upload\\" + file.getOriginalFilename()));

        return productService.updateWithImage(id, productDto, file);
    }
}