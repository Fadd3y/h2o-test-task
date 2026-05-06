package ru.project.h2otesttask.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class CreateMonitorRequestDto extends CreateProductRequestDto {

  @NotNull
  @Positive
  private Double diagonal;

}
