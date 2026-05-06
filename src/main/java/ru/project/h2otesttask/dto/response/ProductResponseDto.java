package ru.project.h2otesttask.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import ru.project.h2otesttask.enums.ComputerFormFactor;
import ru.project.h2otesttask.enums.LaptopSize;

@JsonInclude(Include.NON_NULL)
@Getter
@Builder
public class ProductResponseDto {

  private UUID id;

  private String serialNumber;

  private String manufacturer;

  private BigDecimal price;

  private Integer quantity;

  private ComputerFormFactor formFactor;

  private Integer capacityGb;

  private Double diagonal;

  private LaptopSize size;
}
