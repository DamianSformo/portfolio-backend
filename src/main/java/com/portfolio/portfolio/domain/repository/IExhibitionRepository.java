package com.portfolio.portfolio.domain.repository;

import com.portfolio.portfolio.domain.enums.EExhibitionType;
import com.portfolio.portfolio.domain.enums.ERecordStatus;
import com.portfolio.portfolio.domain.model.Exhibition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IExhibitionRepository extends JpaRepository<Exhibition, Long> {

    List<Exhibition> findByRecordStatusOrderByYearDesc(ERecordStatus recordStatus);

    List<Exhibition> findAll();

    List<Exhibition> findByTypeAndRecordStatusOrderByYearDesc(EExhibitionType type, ERecordStatus recordStatus);

}
