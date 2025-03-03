package com.portfolio.portfolio.domain.repository;

import com.portfolio.portfolio.domain.model.ProcessingFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProcessingFileRepository extends JpaRepository<ProcessingFile, Long> {

    @Query(value = "SELECT * FROM processing_file WHERE record_status = 'A' ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Optional<ProcessingFile> getRandomProcessingFile();

}
