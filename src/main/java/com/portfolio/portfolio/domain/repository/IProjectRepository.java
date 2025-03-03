package com.portfolio.portfolio.domain.repository;

import com.portfolio.portfolio.domain.enums.ERecordStatus;
import com.portfolio.portfolio.domain.model.Menu;
import com.portfolio.portfolio.domain.model.Project;
import com.portfolio.portfolio.domain.projection.BioProjection;
import com.portfolio.portfolio.domain.projection.ProjectPreviewProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findByRecordStatusOrderByOrderIndexAsc(ERecordStatus recordStatus);

    List<Project> findAll();

    @Query("SELECT p FROM Project p WHERE p.recordStatus = 'A' ORDER BY p.orderIndex")
    List<ProjectPreviewProjection> getPreview();
}
