package com.wallet.wallet.domain.repository;

import com.wallet.wallet.domain.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProjectRepository extends JpaRepository<Project, Long> {

    @Query("SELECT p FROM Project p WHERE p.recordStatus = 'A'")
    List<Project> getView();

    @Query("SELECT p FROM Project p")
    List<Project> getAll();
}
