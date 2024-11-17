package com.wallet.wallet.domain.repository;

import com.wallet.wallet.domain.model.Menu;
import com.wallet.wallet.domain.model.ProcessingFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IProcessingFileRepository extends JpaRepository<ProcessingFile, Long> {

    @Query(value = "SELECT * FROM processing_file WHERE record_status = 'A' ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Optional<ProcessingFile> getRandomProcessingFile();

}
