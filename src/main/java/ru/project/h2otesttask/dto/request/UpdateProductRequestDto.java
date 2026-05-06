package ru.project.h2otesttask.dto.request;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import lombok.Getter;
import ru.project.h2otesttask.enums.ComputerFormFactor;
import ru.project.h2otesttask.enums.LaptopSize;

@Getter
public class UpdateProductRequestDto {

  private String serialNumber;

  private String manufacturer;

  @Positive
  private BigDecimal price;

  @PositiveOrZero
  private Integer quantity;

  private ComputerFormFactor formFactor;

  private Integer capacityGb;

  private Double diagonal;

  private LaptopSize size;

}
