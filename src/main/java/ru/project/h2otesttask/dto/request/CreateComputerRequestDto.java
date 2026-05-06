package ru.project.h2otesttask.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.project.h2otesttask.enums.ComputerFormFactor;

@Getter
@AllArgsConstructor
public class CreateComputerRequestDto extends CreateProductRequestDto {

  @NotNull
  private ComputerFormFactor formFactor;

}
