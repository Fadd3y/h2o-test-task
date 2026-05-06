package ru.project.h2otesttask.repository;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.project.h2otesttask.entity.ProductEntity;

@Repository
public interface ProductsRepository extends JpaRepository<ProductEntity, UUID> {

  boolean existsBySerialNumber(String serialNumber);
}
