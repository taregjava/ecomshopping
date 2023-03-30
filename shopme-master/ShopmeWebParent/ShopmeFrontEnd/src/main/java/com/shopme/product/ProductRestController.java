package com.shopme.product;

import com.shopme.category.CategoryService;
import com.shopme.common.entity.Category;
import com.shopme.common.entity.product.Product;
import com.shopme.common.exception.CategoryNotFoundException;
import com.shopme.common.exception.ProductNotFoundException;
import com.shopme.dto.ApiResponse;
import com.shopme.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/product")
public class ProductRestController {

    @Autowired
    private ProductService productService;
    @Autowired private CategoryService categoryService;


    @GetMapping("/products/get/{id}")
    public ProductDTO getProductInfo(@PathVariable("id") Integer id)
            throws ProductNotFoundException {
        Product product = productService.getProduct(id);
        return new ProductDTO(product.getName(), product.getMainImagePath(),
                product.getDiscountPrice(), product.getCost());
    }
    @GetMapping("{category_alias}/page/{pageNum}")
    public Page<Product> getAll(@PathVariable("category_alias") String alias,
                                @PathVariable("pageNum") int pageNum) throws CategoryNotFoundException {
        List<ProductDTO> productDTOS = new ArrayList<>();
        Category category = categoryService.getCategory(alias);
        List<Category> listCategoryParents = categoryService.getCategoryParents(category);


        Page<Product> products = productService.listByCategory(pageNum, category.getId());
        return products;
    }
   /* @GetMapping("{category_alias}/page/{pageNum}")
    public Page<Product> getAll(@PathVariable("category_alias") String alias,
                                   @PathVariable("pageNum") int pageNum) throws CategoryNotFoundException {
        List<ProductDTO> productDTOS = new ArrayList<>();
        Category category = categoryService.getCategory(alias);
        List<Category> listCategoryParents = categoryService.getCategoryParents(category);


        Page<Product> products = productService.listByCategory(pageNum, category.getId());
         return products;
    }*/

    @GetMapping("/pagination")
    public Page<Product> findByByCategory(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam String alias
    ) {
        try {
            List<Product> products = new ArrayList<Product>();
            Pageable paging = PageRequest.of(page, size);
            Category category = categoryService.getCategory(alias);
            Page<Product> pageTuts = productService.listByCategory(page, category.getId());
          /*  tutorials = pageTuts.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("tutorials", tutorials);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());
*/

            return (Page<Product>) ResponseEntity.ok(pageTuts);
        } catch (Exception e) {
          //  return  ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            return (Page<Product>) ResponseEntity.ok("errrrrrrrrr");
        }
    }
    /*Category category = categoryService.getCategory(alias);
			List<Category> listCategoryParents = categoryService.getCategoryParents(category);

			Page<Product> pageProducts = productService.listByCategory(pageNum, category.getId());
			List<Product> listProducts = pageProducts.getContent();*/
    @GetMapping("/listByCat/{alias}")
    public ApiResponse<List<ProductDTO>> indexByCate(@PathVariable String alias ) throws CategoryNotFoundException {
        Category category = categoryService.getCategory(alias);
       // List<ProductDTO> productDTOS = productService.findAll();
        List<ProductDTO> pageProducts = productService.listCategory(category.getId());
        return new ApiResponse<>(pageProducts.size(),pageProducts);

    }
    @GetMapping
    public ApiResponse<List<ProductDTO>> index() {

        List<ProductDTO> productDTOS = productService.findAll();

        return new ApiResponse<>(productDTOS.size(), productDTOS);

    }
    @GetMapping("/{field}")
    public ApiResponse<List<ProductDTO>> getProductsWithSorted(@PathVariable String field) {

        List<ProductDTO> productDTOS = productService.findProductsWithSorting(field);

        return new ApiResponse<>(productDTOS.size(), productDTOS);

    }
    @GetMapping("/pagination/{offset}/{pageSize}")
    public ApiResponse<List<ProductDTO>> findProductsWithPagination(@PathVariable int offset,@PathVariable int pageSize) {

        List<ProductDTO> productDTOS = productService.findProductsWithPagination(offset,pageSize);

        return new ApiResponse<>(productDTOS.size(), productDTOS);

    }

    @GetMapping("/paginationAndSort/{offset}/{pageSize}/{field}")
    public ApiResponse<List<ProductDTO>> findProductsWithPaginationAndSort(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field) {

        List<ProductDTO> productDTOS = productService.findProductsWithPaginationAndSorting(offset,pageSize,field);

        return new ApiResponse<>(productDTOS.size(), productDTOS);

    }
}
