package io.github.app.repository;

import io.github.app.domain.Historia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoriaRepository extends JpaRepository<Historia, Long> {

    List<Historia> findStoriesBySalaId(Long salaId);


}
