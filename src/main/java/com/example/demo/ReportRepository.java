package com.example.demo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Repository
@Transactional(propagation = Propagation.REQUIRES_NEW)
public interface ReportRepository extends PagingAndSortingRepository<Report, UUID> {

    @Query(nativeQuery = true,
            value = "select ID as id, CREATE_DATE as createDate from report")
    Page<ReportProjection> search(Pageable pageable);
}
