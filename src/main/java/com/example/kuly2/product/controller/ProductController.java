package com.example.kuly2.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.kuly2.product.domain.ProductDTO;
import com.example.kuly2.product.service.ProductService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
//@Log4j
@RequestMapping("/product/*")
public class ProductController {
	
	@Setter(onMethod_ = @Autowired)
	ProductService productService;
	
	@GetMapping("/cateList")
	public void cateList(ProductDTO product, Model model) {
		//log.info("category list..........."+product);
		model.addAttribute("cateList", productService.getListWhithCate(product));
	}
}
