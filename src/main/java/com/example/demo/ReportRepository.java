package com.example.demo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ReportRepository extends PagingAndSortingRepository<Report, UUID> {

    @Query(nativeQuery = true,
            value = "select cast(id as string) as id, createdate from report ")
    Page<ReportProjection> search(Pageable pageable);
}
