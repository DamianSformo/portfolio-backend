package com.wallet.wallet.domain.repository;

import com.wallet.wallet.domain.model.Menu;
import com.wallet.wallet.domain.model.Study;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMenuRepository extends JpaRepository<Menu, Long> {

    @Query("SELECT m FROM Menu m WHERE m.recordStatus = 'A' ORDER BY m.orderIndex")
    List<Menu> getView();

    @Query("SELECT m FROM Menu m")
    List<Menu> getAll();
}
