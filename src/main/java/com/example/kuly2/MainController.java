package com.example.kuly2;

import com.example.kuly2.admin.Dto.ProductDto;
import com.example.kuly2.admin.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
	
	private final ProductService productService;
	
	@GetMapping("/")
	public String main(HttpSession session, Model model) {
		// 로그인이 되어있는지?
		if (session.getAttribute("name") != null) {
			// 모델에 이름 정보를 담아준다.
			model.addAttribute("name", session.getAttribute("name"));
		}
		List<ProductDto> productDto = productService.productList();
        model.addAttribute("productList", productDto); //전체 상품
        
        List<ProductDto> productDto2 = productService.productList();
        List<ProductDto> productRecommend =  new ArrayList<ProductDto>();
        
        Collections.shuffle(productDto2); 
        
        for (int i = 0; i < productDto2.size(); i ++) {
//        	System.out.println(productDto2.get(i));
        	productRecommend.add(productDto2.get(i));
        }
        model.addAttribute("productRecommend", productRecommend); //랜덤(추천) 상품

		return "/main/index";
	}
	
	@GetMapping("/siteInfo")
	public String info() {
		return "/main/siteInfo";
		
	}
}
