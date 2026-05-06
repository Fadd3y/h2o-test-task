package ru.project.h2otesttask.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "hard_drives")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HardDriveEntity extends ProductEntity {

  @Column(name = "capacity_gb")
  private Integer capacityGb;

}