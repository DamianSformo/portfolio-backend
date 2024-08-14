package com.wallet.wallet.domain.repository;

import com.wallet.wallet.domain.model.Bio;
import com.wallet.wallet.domain.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBioRepository extends JpaRepository<Bio, Long> {

    @Query("SELECT b FROM Bio b WHERE b.recordStatus = 'A'")
    List<Bio> getView();

}
