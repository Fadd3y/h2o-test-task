package ru.project.h2otesttask.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.project.h2otesttask.enums.LaptopSize;

@Getter
@AllArgsConstructor
public class CreateLaptopRequestDto extends CreateProductRequestDto {

  @NotNull
  private LaptopSize size;

}
