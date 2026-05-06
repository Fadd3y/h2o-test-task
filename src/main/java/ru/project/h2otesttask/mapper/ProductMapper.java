package ru.project.h2otesttask.mapper;

import java.util.List;
import org.springframework.stereotype.Component;
import ru.project.h2otesttask.dto.request.CreateComputerRequestDto;
import ru.project.h2otesttask.dto.request.CreateHardDriveRequestDto;
import ru.project.h2otesttask.dto.request.CreateLaptopRequestDto;
import ru.project.h2otesttask.dto.request.CreateMonitorRequestDto;
import ru.project.h2otesttask.dto.request.CreateProductRequestDto;
import ru.project.h2otesttask.dto.request.UpdateProductRequestDto;
import ru.project.h2otesttask.dto.response.ProductResponseDto;
import ru.project.h2otesttask.dto.response.ProductResponseDto.ProductResponseDtoBuilder;
import ru.project.h2otesttask.entity.ComputerEntity;
import ru.project.h2otesttask.entity.HardDriveEntity;
import ru.project.h2otesttask.entity.LaptopEntity;
import ru.project.h2otesttask.entity.MonitorEntity;
import ru.project.h2otesttask.entity.ProductEntity;

@Component
public final class ProductMapper {

  public ProductResponseDto entityToResponseDto(ProductEntity product) {
    ProductResponseDtoBuilder responseDto = ProductResponseDto.builder()
        .id(product.getId())
        .serialNumber(product.getSerialNumber())
        .manufacturer(product.getManufacturer())
        .price(product.getPrice())
        .quantity(product.getQuantity());

    if (product instanceof LaptopEntity laptopEntity) {
      responseDto.size(laptopEntity.getSize());

    } else if (product instanceof MonitorEntity monitorEntity) {
      responseDto.diagonal(monitorEntity.getDiagonal());

    } else if (product instanceof HardDriveEntity hardDriveEntity) {
      responseDto.capacityGb(hardDriveEntity.getCapacityGb());

    } else if (product instanceof ComputerEntity computerEntity) {
      responseDto.formFactor(computerEntity.getFormFactor());

    } else {
      throw new IllegalArgumentException("Unknown type");
    }

    return responseDto.build();
  }

  public List<ProductResponseDto> entitiesToResponseListDto(List<? extends ProductEntity> productEntities) {
    return productEntities.stream().map(this::entityToResponseDto).toList();
  }

  public ProductEntity createRequestDtoToEntity(CreateProductRequestDto requestDto) {
    ProductEntity product;

    if (requestDto instanceof CreateLaptopRequestDto laptopRequestDto) {
      LaptopEntity laptop = new LaptopEntity();
      laptop.setSize(laptopRequestDto.getSize());
      product = laptop;

    } else if (requestDto instanceof CreateMonitorRequestDto monitorRequestDto) {
      MonitorEntity monitor = new MonitorEntity();
      monitor.setDiagonal(monitorRequestDto.getDiagonal());
      product = monitor;

    } else if (requestDto instanceof CreateHardDriveRequestDto hardDriveRequestDto) {
      HardDriveEntity hardDriveEntity = new HardDriveEntity();
      hardDriveEntity.setCapacityGb(hardDriveRequestDto.getCapacityGb());
      product = hardDriveEntity;

    } else if (requestDto instanceof CreateComputerRequestDto computerRequestDto) {
      ComputerEntity computerEntity = new ComputerEntity();
      computerEntity.setFormFactor(computerRequestDto.getFormFactor());
      product = computerEntity;

    } else {
      throw new IllegalArgumentException("Unknown type");
    }

    fillBase(product, requestDto);
    return product;
  }

  public void applyUpdate(ProductEntity product, UpdateProductRequestDto requestDto) {
    if (requestDto.getSerialNumber() != null) {
      product.setSerialNumber(requestDto.getSerialNumber());
    }

    if (requestDto.getManufacturer() != null) {
      product.setManufacturer(requestDto.getManufacturer());
    }

    if (requestDto.getQuantity() != null) {
      product.setQuantity(requestDto.getQuantity());
    }

    if (requestDto.getPrice() != null) {
      product.setPrice(requestDto.getPrice());
    }

    if (product instanceof LaptopEntity laptopEntity && requestDto.getSize() != null) {
      laptopEntity.setSize(requestDto.getSize());
    }

    if (product instanceof MonitorEntity monitorEntity && requestDto.getDiagonal() != null) {
      if (requestDto.getDiagonal() <= 0) {
        throw new IllegalArgumentException("Diagonal must be positive");
      }
      monitorEntity.setDiagonal(requestDto.getDiagonal());
    }

    if (product instanceof HardDriveEntity hardDriveEntity && requestDto.getCapacityGb() != null) {
      if (requestDto.getCapacityGb() <= 0) {
        throw new IllegalArgumentException("Capacity must be positive");
      }
      hardDriveEntity.setCapacityGb(requestDto.getCapacityGb());
    }

    if (product instanceof ComputerEntity computerEntity && requestDto.getFormFactor() != null) {
      computerEntity.setFormFactor(requestDto.getFormFactor());
    }
  }

  private void fillBase(ProductEntity product, CreateProductRequestDto requestDto) {
    product.setSerialNumber(requestDto.getSerialNumber());
    product.setManufacturer(requestDto.getManufacturer());
    product.setPrice(requestDto.getPrice());
    product.setQuantity(requestDto.getQuantity());
  }

}
