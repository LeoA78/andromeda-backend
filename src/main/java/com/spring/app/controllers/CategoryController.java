package com.spring.app.controllers;

import com.spring.app.dtos.response.DataResponseDTO;
import com.spring.app.dtos.response.PagesResponseDTO;
import com.spring.app.dtos.response.CategoryResponseDTO;
import com.spring.app.services.ICategoryService;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Api(value = "Category Api", tags = {"Category Service"})
@RestController
@RequestMapping(value = "/category", produces = {MediaType.APPLICATION_JSON_VALUE})
public class CategoryController {

    private ICategoryService categoryService;

    @GetMapping(value = "/all")
    @ApiOperation(
            value = "Retrieves all Lists Categories",
            httpMethod = "GET",
            response = CategoryResponseDTO[].class
    )
    @ApiResponses(value = {
            @ApiResponse(
                    code = 200,
                    message = "Body content with information about an category list",
                    response = CategoryResponseDTO[].class),
            @ApiResponse(
                    code = 404,
                    message = "Information about an category list not found")
    })
    public ResponseEntity<DataResponseDTO<List<CategoryResponseDTO>>> getAllCategories() {

        List<CategoryResponseDTO> categoriesList = categoryService.findAllCategories();

        DataResponseDTO<List<CategoryResponseDTO>> result = new DataResponseDTO<>();

        result.setTimestamp(LocalDateTime.now());
        result.setData(categoriesList);
        result.setResponseCode(HttpStatus.OK.value());
        result.setStatus("SUCCESS");
        result.setMessage("OK");
        result.setPath("/category/all");

        return new ResponseEntity<>(result, HttpStatus.OK);

    }
}
