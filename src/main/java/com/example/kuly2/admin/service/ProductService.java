package com.example.kuly2.admin.service;

import com.example.kuly2.admin.Dto.ProductDto;
import com.example.kuly2.admin.entity.ProductEntity;
import com.example.kuly2.admin.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 작성자 : 정지수
 * 내용  :  관리자 - 서비스
 */

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

//    @Autowired
//    private ProductEntity productEntity;

    @Autowired
    ModelMapper modelMapper;

    /** 상품목록 정보를 DB에서 값을 가져와서 리스트로 바꿔서 컨트롤러로 주는 로직 */
    public List<ProductDto> memberList() {
        // repository에서 entity 값 가져옴 (productEntity)
        List<ProductEntity> productList = productRepository.findAll();
        // ProductDto로 값을 담기 위해 new ArrayList<>() 선언
        List<ProductDto> productDtos = new ArrayList<>();
        //반복문으로 productDtos에 모델매퍼로 엔티티에서 가져온 값을 리스트로 바꿔준다.
        for (int i = 0; i < productList.size(); i++)
            productDtos.add(modelMapper.map(productList.get(i), ProductDto.class));
            return productDtos;
        }
    /** 상품목록 리스트에서 상품번호로 따와서 거기에 대항하는 DB내용 컨트롤러로 보내줌 */
    public ProductDto memberListView(int product_no){
        ProductEntity productEntity = productRepository.findById(product_no).orElse(null);
        ProductDto productDto = modelMapper.map(productEntity, ProductDto.class);

        return productDto;

        }
        
//    /** 상품 목록 리스트에서 상품 수정으로 넘어가기 */
//    public ProductEntity productListViewUpdate(ProductDto productDto){
//        ProductEntity productEntity = null;
//
//        productEntity = productRepository.findById(productDto.getProduct_no()).get();
//        productEntity.update(productDto.getProduct_no());
//
//        System.out.println("ProductService - productDto = " + productDto);
//
////        return productDto;
//        return productEntity;
//    }
    /** 상품 목록 리스트에서 상품 수정으로 넘어가기 */
    public String productListViewUpdate(Integer product_no){
//        ProductEntity productEntity = productRepository.save(product_no , ProductEntity.builder(product_no)).orElse(null);
//        ProductDto productDto = modelMapper.map(productEntity, ProductDto.class);
//        System.out.println("Service - productListViewUpdate 여기오냐");
//        System.out.println("Service - productListViewUpdate " + product_no);
//        System.out.println("ProductService - productDto = " + productDto);
//        productRepository.save(product_no);
        return null;
    }

    /** 내용 : 관리자 - 상품 목록 리스트 - 상품목록 -> 상품 삭제하기 */
    public void productDelete(Integer product_no){
        productRepository.deleteById(product_no);
    }

    /** */
//    public int saveGet(ProductDto productDto){
//        System.out.println("Service saveGet Repo.save = " + ProductRepository.save(productDto.toEntity()).getProduct_no());
//
//        return ProductRepository.save(productDto.toEntity()).getProduct_no();
//
//    }

//    @Transactional
//    public int save(ProductDto productDto){
//        return productRepository.save(productDto.toEntity()).getProduct_no();
//    }

}
