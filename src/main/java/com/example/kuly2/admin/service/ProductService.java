package com.example.kuly2.admin.service;

import com.example.kuly2.admin.Dto.ProductDto;
import com.example.kuly2.admin.entity.ProductEntity;
import com.example.kuly2.admin.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    ModelMapper modelMapper;

    // 상품 저장
    @Transactional
    public Long saveWithImage(ProductDto productDto, MultipartFile file) {
        productDto.setProduct_photo(file.getOriginalFilename());
        return productRepository.save(productDto.toEntity()).getProduct_no();
    }
    
    // 상품 목록
    @Transactional
    public Page<ProductDto> findAll(Pageable pageable) {
        Page<ProductEntity> productEntities = productRepository.findAll(pageable);
        return productEntities.map(entity -> new ProductDto(entity));
    }

    // 상품 상세
    @Transactional
    public ProductDto findById(Long id) {
        ProductEntity productEntity = productRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 존재하지 않습니다. (게시글 ID : "+id+")"));
        return new ProductDto(productEntity);
    }
    
    //상품 삭제
    @Transactional
    public Long delete(Long id) {
        ProductEntity productEntity = productRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 존재하지 않습니다. (게시글 ID : "+id+")"));
        productRepository.delete(productEntity);
        return id;
    }

    //상품 수정
    @Transactional
    public Long updateWithImage(Long id, ProductDto productDto , MultipartFile file) {
        productDto.setProduct_photo(file.getOriginalFilename());
        ProductEntity productEntity = productRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 존재하지 않습니다. (게시글 ID : "+id+")"));
        productEntity.update(productDto);
        return id;
    }

    // 상품 수정 페이지 이동
    public ProductEntity toUpdate(Long product_no){
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

}
