package ru.project.h2otesttask.dto.request;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@JsonTypeInfo(use = Id.NAME, property = "type", visible = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = CreateComputerRequestDto.class, name = "COMPUTER"),
    @JsonSubTypes.Type(value = CreateHardDriveRequestDto.class, name = "HARD_DRIVE"),
    @JsonSubTypes.Type(value = CreateLaptopRequestDto.class, name = "LAPTOP"),
    @JsonSubTypes.Type(value = CreateMonitorRequestDto.class, name = "MONITOR")
})
@Getter
public abstract class CreateProductRequestDto {

  @NotNull
  private String serialNumber;

  @NotNull
  private String manufacturer;

  @NotNull
  @Positive
  private BigDecimal price;

  @NotNull
  @PositiveOrZero
  private Integer quantity;
}
