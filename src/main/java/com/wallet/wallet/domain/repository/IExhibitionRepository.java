package com.wallet.wallet.domain.repository;

import com.wallet.wallet.domain.model.Exhibition;
import com.wallet.wallet.domain.model.Study;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IExhibitionRepository extends JpaRepository<Exhibition, Long> {

    @Query("SELECT e FROM Exhibition e WHERE e.recordStatus = 'A'")
    List<Exhibition> getView();

    @Query("SELECT e FROM Exhibition e")
    List<Exhibition> getAll();

    @Query("SELECT e FROM Exhibition e WHERE e.type = 'Group'")
    List<Exhibition> getExhibitionGroup();

    @Query("SELECT e FROM Exhibition e WHERE e.type = 'Individual'")
    List<Exhibition> getExhibitionIndividual();
}
