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
import ru.project.h2otesttask.enums.LaptopSize;

@Entity
@Table(name = "laptops")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LaptopEntity extends ProductEntity {

  @Enumerated(EnumType.STRING)
  @Column(name = "laptop_size")
  private LaptopSize size;

}