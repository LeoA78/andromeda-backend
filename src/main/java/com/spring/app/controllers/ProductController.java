package com.spring.app.controllers;

import com.spring.app.dtos.request.ProductDTO;
import com.spring.app.dtos.request.ProductDTO;
import com.spring.app.dtos.response.*;
import com.spring.app.dtos.response.ProductResponseDTO;
import com.spring.app.dtos.response.ProductResponseDTO;
import com.spring.app.services.IProductService;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Api(value = "Product Api", tags = {"Product Service"})
@RestController
@RequestMapping(value = "/product", produces = {MediaType.APPLICATION_JSON_VALUE})
public class ProductController {

    IProductService productService;

    @GetMapping(value = "/all")
    @ApiOperation(
            value = "Retrieves all Lists Products",
            httpMethod = "GET",
            response = ProductResponseDTO[].class
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Body content with information about an product list",
                    response = ProductResponseDTO[].class),
            @ApiResponse(
                    code = 404,
                    message = "Information about an product list not found")
    })
    public ResponseEntity<DataResponseDTO<PagesResponseDTO<ProductResponseDTO>>> getAllProducts(
            @ApiParam(value = "Page to display", required = true, example = "0")
            @RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
            @ApiParam(value = "Number of elements per page", required = true, example = "10")
            @RequestParam(value = "size", defaultValue = "10", required = false) Integer size) {



        PagesResponseDTO<ProductResponseDTO> productsList = productService.findAllProducts(page, size);

        DataResponseDTO<PagesResponseDTO<ProductResponseDTO>> result = new DataResponseDTO<>();

        result.setTimestamp(LocalDateTime.now());
        result.setData(productsList);
        result.setResponseCode(HttpStatus.OK.value());
        result.setStatus("SUCCESS");
        result.setMessage("OK");
        result.setPath("/product/all");

        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @GetMapping(value = "/{id}")
    @ApiOperation(
            value = "Retrieves all Lists Products",
            httpMethod = "GET",
            response = ProductResponseDTO.class
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Body content with information about an product",
                    response = ProductResponseDTO.class),
            @ApiResponse(
                    code = 404,
                    message = "Information about an product list not found")
    })
    public ResponseEntity<DataResponseDTO<ProductResponseDTO>> getProductById(
            @ApiParam(name = "id", required = true, value = "1", example = "1")
            @PathVariable("id") Long id) {

        ProductResponseDTO productResponseDTO = productService.findProductById(id);

        DataResponseDTO<ProductResponseDTO> result = new DataResponseDTO<>();

        result.setTimestamp(LocalDateTime.now());
        result.setData(productResponseDTO);
        result.setResponseCode(HttpStatus.OK.value());
        result.setStatus("SUCCESS");
        result.setMessage("OK");
        result.setPath("/product/id");

        return new ResponseEntity<>(result,HttpStatus.OK);
    }


    @PostMapping(value = "/add", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(
            value = "Retrieves data associated to List Master by Id",
            httpMethod = "POST",
            response = ProductResponseDTO.class
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 201,
                    message = "Body content with information about a successfully created product",
                    response = ProductResponseDTO.class),
            @ApiResponse(
                    code = 400,
                    message = "Information about an error creating a new product")
    })
    public ResponseEntity<DataResponseDTO<ProductResponseDTO>> addProduct(
            @ApiParam(name = "product", required = true, value = "Product")
            @Valid @RequestBody ProductDTO product) {

        ProductResponseDTO productResponseDTO = productService.createProduct(product);

        DataResponseDTO<ProductResponseDTO> result = new DataResponseDTO<>();

        result.setTimestamp(LocalDateTime.now());
        result.setData(productResponseDTO);
        result.setResponseCode(HttpStatus.OK.value());
        result.setStatus("SUCCESS");
        result.setMessage("OK");
        result.setPath("/product/id");

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }


    @PutMapping(value = "/update/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ApiOperation(
            value = "Retrieves data associated to List Master by Id",
            httpMethod = "PUT",
            response = ProductResponseDTO.class
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 201,
                    message = "Body content with information about a successfully updated product",
                    response = ProductResponseDTO.class),
            @ApiResponse(
                    code = 400,
                    message = "Information about an error updating a new product")
    })
    public ResponseEntity<DataResponseDTO<ProductResponseDTO>> updateProduct(
            @ApiParam(name = "id", required = true, value = "Id", example = "1")
            @PathVariable("id") Long id,
            @ApiParam(name = "product", required = true, value = "Product")
            @Valid @RequestBody ProductDTO product
    ){

        ProductResponseDTO productResponseDTO = productService.updateProduct(id,product);

        DataResponseDTO<ProductResponseDTO> result = new DataResponseDTO<>();

        result.setTimestamp(LocalDateTime.now());
        result.setData(productResponseDTO);
        result.setResponseCode(HttpStatus.OK.value());
        result.setStatus("SUCCESS");
        result.setMessage("OK");
        result.setPath("/product/id");

        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }


    @DeleteMapping (value = "/delete/{id}")
    @ApiOperation(
            value = "Retrieves all Lists Productes",
            httpMethod = "DELETE"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 204,
                    message = "Body content about a successfully deleted product"),
            @ApiResponse(
                    code = 400,
                    message = "Information about an error deleting a existing product"),
            @ApiResponse(
                    code = 404,
                    message = "Information about an product to delete not found")
    })
    public ResponseEntity<DataResponseDTO<Void>> deleteProductById(
            @ApiParam(name = "id", required = true, value = "id", example = "1")
            @PathVariable("id") Long id) {

        productService.deleteProductById(id);

        DataResponseDTO<Void> result = new DataResponseDTO<>();

        result.setTimestamp(LocalDateTime.now());
        result.setData(null);
        result.setResponseCode(HttpStatus.OK.value());
        result.setStatus("SUCCESS");
        result.setMessage("DELETED");
        result.setPath("/product/id");

        return new ResponseEntity<>(result,HttpStatus.OK);
    }

}
