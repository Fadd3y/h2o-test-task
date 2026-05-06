package ru.project.h2otesttask.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.project.h2otesttask.enums.ComputerFormFactor;

@Entity
@Table(name = "computers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ComputerEntity extends ProductEntity {

  @Column(name = "form_factor")
  @Enumerated(EnumType.STRING)
  private ComputerFormFactor formFactor;

}