package com.example.kuly2.admin.service;

import com.example.kuly2.admin.Dto.ProductDto;
import com.example.kuly2.admin.entity.ProductEntity;
import com.example.kuly2.admin.repository.ProductRepository;
import com.example.kuly2.category.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 작성자 : 정지수
 * 내용  :  관리자 - 서비스
 */

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    ModelMapper modelMapper;

    //    @Override
    public List<ProductDto> memberList() {
        // repository에서 entity 값 가져옴 (productEntity)
        List<ProductEntity> productList = productRepository.findAll();
        // ProductDto로 값을 담기 위해 new ArrayList<>() 선언
        List<ProductDto> productDtos = new ArrayList<>();
        //반복문으로 productDtos에 모델매퍼로 엔티티에서 가져온 값을 바꿔준다.
        for (int i = 0; i < productList.size(); i++)
            productDtos.add(modelMapper.map(productList.get(i), ProductDto.class));
//
        return productDtos;
    }

    public ProductDto memberListView() {
        ProductEntity productEntity = productRepository.findById(0).orElse(null);
        ProductDto productDto = modelMapper.map(productEntity, ProductDto.class);
        return productDto;

    }

    public List<ProductDto> getItemList(String categoryId) {
        if (categoryId == null) {
            return memberList();
        } else {
            return toDto(productRepository.findByCategoryId(categoryId));
        }
    }


    public List<ProductDto> searchItem(String search) {
        if (search != null) {
            return toDto(productRepository.findByProductNameContaining(search));
        }
        return memberList();
    }

    private List<ProductDto> toDto(List<ProductEntity> list) {
        return list.stream().map(i -> modelMapper.map(i, ProductDto.class)).collect(Collectors.toList());
    }

    public List<ProductDto> getItemFilterList(String filter) {
        return toDto(productRepository.findBySecondaryCategory(filter));
    }
}
