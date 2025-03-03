package com.portfolio.portfolio.domain.repository;

import com.portfolio.portfolio.domain.model.ProjectFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProjectFileRepository extends JpaRepository<ProjectFile, Long> {

    @Query("SELECT pf FROM ProjectFile pf WHERE pf.project.id = ?1 ORDER BY pf.orderIndex")
    List<ProjectFile> getProjectFileByProjectId(Long id);

    @Query("SELECT pf FROM ProjectFile pf WHERE pf.project.id = ?1 AND isCover is TRUE")
    ProjectFile getProjectFilePreviewByProjectId(Long id);

}
