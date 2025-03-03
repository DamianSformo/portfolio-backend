package com.portfolio.portfolio.domain.repository;

import com.portfolio.portfolio.domain.enums.ERecordStatus;
import com.portfolio.portfolio.domain.model.Prize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPrizeRepository extends JpaRepository<Prize, Long> {

    List<Prize> findByRecordStatusOrderByOrderIndexAscYearDesc(ERecordStatus recordStatus);

    List<Prize> findAll();

}
