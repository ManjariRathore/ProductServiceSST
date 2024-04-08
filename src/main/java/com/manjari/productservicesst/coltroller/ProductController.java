package com.manjari.productservicesst.coltroller;
import com.manjari.productservicesst.models.Product;
import com.manjari.productservicesst.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// localhost:8080/products -> Product Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    ProductController( ProductService productService){
        this.productService = productService;
    }
    //localhost:8080/products/id
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }
    @GetMapping
    public Product[] getAllProducts(){
        return productService.getAllProducts();
    }
}
