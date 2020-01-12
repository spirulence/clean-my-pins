package com.cleanmypins.repository;

import com.cleanmypins.model.Report;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReportRepository extends CrudRepository<Report, Long> {

    List<Report> findByReportId(Long reportId);

}
