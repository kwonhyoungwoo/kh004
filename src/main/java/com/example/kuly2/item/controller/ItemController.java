package com.example.kuly2.item.controller;

import com.example.kuly2.admin.service.ProductService;
import com.example.kuly2.category.entity.Category;
import com.example.kuly2.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequiredArgsConstructor
@RequestMapping("/item")
public class ItemController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @GetMapping("/{category}")
    public String itemList(@PathVariable String category, Model model, String filter) {
        if (category != null) {
            model.addAttribute("secondList", categoryService.getSecondaryCategoryList(category));
            model.addAttribute("category",category);
        }
        if (filter != null) {
            model.addAttribute("itemList", productService.getItemFilterList(filter));
        } else {
            model.addAttribute("itemList", productService.getItemList(category));
        }
        return "main/list";
    }
    @GetMapping("/search")
    public String itemList( String search,Model model) {

        model.addAttribute("itemList", productService.searchItem(search));
        if (search != null) {
            model.addAttribute("search",search);
        }

        return "main/list";
    }
}
