package com.wallet.wallet.domain.repository;

import com.wallet.wallet.domain.model.Project;
import com.wallet.wallet.domain.model.ProjectFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProjectFileRepository extends JpaRepository<ProjectFile, Long> {

    @Query("SELECT pf FROM ProjectFile pf WHERE pf.project.id = ?1")
    List<ProjectFile> getProjectFileByProjectId(Long id);

    @Query("SELECT pf FROM ProjectFile pf WHERE pf.project.id = ?1 AND isCover is TRUE")
    ProjectFile getProjectFilePreviewByProjectId(Long id);

}
