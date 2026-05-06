package ru.project.h2otesttask.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.project.h2otesttask.dto.request.CreateProductRequestDto;
import ru.project.h2otesttask.dto.request.UpdateProductRequestDto;
import ru.project.h2otesttask.dto.response.ProductResponseDto;
import ru.project.h2otesttask.entity.ProductEntity;
import ru.project.h2otesttask.enums.ProductType;
import ru.project.h2otesttask.mapper.ProductMapper;
import ru.project.h2otesttask.repository.ComputersRepository;
import ru.project.h2otesttask.repository.HardDrivesRepository;
import ru.project.h2otesttask.repository.LaptopsRepository;
import ru.project.h2otesttask.repository.MonitorsRepository;
import ru.project.h2otesttask.repository.ProductsRepository;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductsRepository productsRepository;
  private final ComputersRepository computersRepository;
  private final HardDrivesRepository hardDrivesRepository;
  private final LaptopsRepository laptopsRepository;
  private final MonitorsRepository monitorsRepository;

  private final ProductMapper productMapper;

  @Transactional
  public ProductResponseDto create(CreateProductRequestDto requestDto) {
    ProductEntity product = productMapper.createRequestDtoToEntity(requestDto);
    ProductEntity result = productsRepository.save(product);

    return productMapper.entityToResponseDto(result);
  }

  @Transactional
  public ProductResponseDto update(UUID id, UpdateProductRequestDto requestDto) {
    ProductEntity product = productsRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Product not found"));

    productMapper.applyUpdate(product, requestDto);

    return productMapper.entityToResponseDto(product);
  }


  public List<ProductResponseDto> findAllByType(ProductType type) {
    List<? extends ProductEntity> productEntities =
    switch(type) {
      case COMPUTER -> computersRepository.findAll();
      case HARD_DRIVE -> hardDrivesRepository.findAll();
      case LAPTOP -> laptopsRepository.findAll();
      case MONITOR -> monitorsRepository.findAll();
    };

    return productMapper.entitiesToResponseListDto(productEntities);
  }

  public ProductResponseDto findById(UUID id) {
    return productMapper.entityToResponseDto(productsRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Product not found")));
  }
}
