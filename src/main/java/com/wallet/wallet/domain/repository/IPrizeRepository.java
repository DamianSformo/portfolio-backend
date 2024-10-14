package com.wallet.wallet.domain.repository;

import com.wallet.wallet.domain.model.Exhibition;
import com.wallet.wallet.domain.model.Prize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPrizeRepository extends JpaRepository<Prize, Long> {

    @Query("SELECT p FROM Prize p WHERE p.recordStatus = 'A'")
    List<Prize> getView();

    @Query("SELECT p FROM Prize p")
    List<Prize> getAll();

}
