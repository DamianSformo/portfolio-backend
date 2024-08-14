package com.wallet.wallet.domain.repository;

import com.wallet.wallet.domain.model.Project;
import com.wallet.wallet.domain.model.Study;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudyRepository extends JpaRepository<Study, Long> {

    @Query("SELECT s FROM Study s WHERE s.recordStatus = 'A'")
    List<Study> getView();

    @Query("SELECT s FROM Study s")
    List<Study> getAll();
}
