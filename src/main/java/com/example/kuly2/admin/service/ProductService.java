package com.example.kuly2.admin.service;

import com.example.kuly2.admin.Dto.ProductDto;
import com.example.kuly2.admin.entity.ProductEntity;
import com.example.kuly2.admin.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * 작성자 : 정지수
 * 내용  :  관리자 - 서비스
 */
@AllArgsConstructor
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    ModelMapper modelMapper;


    /** 상품목록 리스트에서 상품번호로 따와서 거기에 대항하는 DB내용 컨트롤러로 보내줌 */
    public ProductEntity productListView(Long product_no){
        ProductEntity productEntity = productRepository.findById(product_no).orElse(null);

        return productEntity;

        }


    /** 상품목록 정보를 DB에서 값을 가져와서 리스트로 바꿔서 컨트롤러로 주는 로직 */
    public List<ProductDto> productList() {
        // repository에서 entity 값 가져옴 (productEntity)
        List<ProductEntity> productList = productRepository.findAll();
        // ProductDto로 값을 담기 위해 new ArrayList<>() 선언
        List<ProductDto> productDtos = new ArrayList<>();
        //반복문으로 productDtos에 모델매퍼로 엔티티에서 가져온 값을 리스트로 바꿔준다.
        for (int i = 0; i < productList.size(); i++)
            productDtos.add(modelMapper.map(productList.get(i), ProductDto.class));
        return productDtos;
    }


    /** 내용 : 상품 등록 */
    public Long productListInsert(ProductDto productDto) {
        return productRepository.save(productDto.toEntity()).getProduct_no();
    }


    /** 내용 : 관리자 - 상품 상세보기에서 상품 수정 페이지로 이동 */
    public ProductEntity productListViewToUpdate(Long product_no){
        ProductEntity productEntity = productRepository.findById(product_no).orElse(null);
        return productEntity;
    }


    /** 내용 : 상품 수정 */
    @Transactional
    public Long productListUpdate(Long product_no, ProductDto productDto){
        ProductEntity productEntity = productRepository.findById(product_no).orElseThrow(() ->
                new IllegalArgumentException("해당 상품이 존재하지 않습니다." + product_no));
        productEntity.update(productDto);

        return product_no;
    }


    /** 내용 : 관리자 - 상품 목록 리스트 - 상품목록 -> 상품 삭제하기 */
    @Transactional
    public void productDelete(Long product_no){
        productRepository.deleteById(product_no);
    }



}
