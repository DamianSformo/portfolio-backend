package com.portfolio.portfolio.domain.repository;

import com.portfolio.portfolio.domain.model.Bio;
import com.portfolio.portfolio.domain.projection.BioProjection;
import com.portfolio.portfolio.domain.projection.StatementProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IBioRepository extends JpaRepository<Bio, Long> {

    @Query("SELECT b FROM Bio b WHERE b.name = ?1 AND b.recordStatus = 'A'")
    Optional<BioProjection> getByName(String name);

    @Query("SELECT b FROM Bio b WHERE b.id = ?1 AND b.recordStatus = 'A'")
    Optional<StatementProjection> getStatement(Long id);

}
