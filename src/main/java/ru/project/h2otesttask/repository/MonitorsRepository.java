package ru.project.h2otesttask.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.project.h2otesttask.entity.MonitorEntity;

@Repository
public interface MonitorsRepository extends JpaRepository<MonitorEntity, UUID> {

}
