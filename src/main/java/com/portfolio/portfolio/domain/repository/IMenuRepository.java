package com.portfolio.portfolio.domain.repository;

import com.portfolio.portfolio.domain.enums.ERecordStatus;
import com.portfolio.portfolio.domain.model.Menu;
import com.portfolio.portfolio.domain.model.Study;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMenuRepository extends JpaRepository<Menu, Long> {

    List<Menu> findByRecordStatusOrderByOrderIndexDesc(ERecordStatus recordStatus);

    List<Menu> findAll();
}
