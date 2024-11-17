package com.wallet.wallet.domain.repository;

import com.wallet.wallet.domain.dto.response.StatementResponseDto;
import com.wallet.wallet.domain.model.Bio;
import com.wallet.wallet.domain.projection.StatementProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import java.util.List;
import java.util.Optional;

@Repository
public interface IBioRepository extends JpaRepository<Bio, Long> {

    @Query("SELECT b FROM Bio b WHERE b.recordStatus = 'A'")
    List<Bio> getView();

    @Query("SELECT b FROM Bio b WHERE b.id = ?1")
    Optional<StatementProjection> getStatement(Long id);

}
