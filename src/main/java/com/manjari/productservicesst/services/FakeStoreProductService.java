package com.manjari.productservicesst.services;

import com.manjari.productservicesst.DTOs.FakeStoreProductDto;
import com.manjari.productservicesst.exception.ProductNotFoundException;
import com.manjari.productservicesst.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements ProductService{
    @Override
    public Product getProductById(Long id) {
        //call the fake store API to get the product with the given id.
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/"+id,
                FakeStoreProductDto.class);
        if(fakeStoreProductDto==null)throw new ProductNotFoundException(id,"Please pass a valid product id") ;
        return convertFakeStoreDto(fakeStoreProductDto);
    }

    @Override
    public Product[] getAllProducts() {
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDto[] list = restTemplate.getForObject("https://fakestoreapi.com/products",FakeStoreProductDto[].class);
        if( list == null ) return null;
        Product[]  ret = new Product[list.length];
        for (int i = 0 ; i < list.length ; i++) {
            ret[i] = convertFakeStoreDto(list[i]);
        }
        return ret;
    }
    public Product convertFakeStoreDto(FakeStoreProductDto fakeStoreProductDto){
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setImg(fakeStoreProductDto.getImg());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setCategory(fakeStoreProductDto.getCategory());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        return product;
    }
}
