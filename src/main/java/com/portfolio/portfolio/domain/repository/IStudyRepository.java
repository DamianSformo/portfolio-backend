package com.portfolio.portfolio.domain.repository;

import com.portfolio.portfolio.domain.enums.ERecordStatus;
import com.portfolio.portfolio.domain.model.Exhibition;
import com.portfolio.portfolio.domain.model.Study;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudyRepository extends JpaRepository<Study, Long> {

    List<Study> findByRecordStatusOrderByStartYearDesc(ERecordStatus recordStatus);

    List<Study> findAll();
}
