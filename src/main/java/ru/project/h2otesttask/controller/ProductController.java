package ru.project.h2otesttask.controller;

import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.project.h2otesttask.dto.request.CreateProductRequestDto;
import ru.project.h2otesttask.dto.request.UpdateProductRequestDto;
import ru.project.h2otesttask.dto.response.ProductResponseDto;
import ru.project.h2otesttask.enums.ProductType;
import ru.project.h2otesttask.service.ProductService;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@Validated
public class ProductController {

  private final ProductService productService;

  @PostMapping()
  public ResponseEntity<ProductResponseDto> createProduct(
      @RequestBody @Valid CreateProductRequestDto requestDto) {

    return ResponseEntity.ok(productService.create(requestDto));
  }

  @PatchMapping("/{id}")
  public ResponseEntity<ProductResponseDto> updateProduct(
      @RequestBody @Valid UpdateProductRequestDto requestDto,
      @PathVariable("id") UUID id) {

    return ResponseEntity.ok(productService.update(id, requestDto));
  }

  @GetMapping
  public ResponseEntity<List<ProductResponseDto>> findAllByType(@RequestParam("type") ProductType type) {
    return ResponseEntity.ok(productService.findAllByType(type));
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProductResponseDto> findById(@PathVariable("id") UUID id) {
    return ResponseEntity.ok(productService.findById(id));
  }

}
