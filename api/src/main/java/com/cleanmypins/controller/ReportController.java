package com.cleanmypins.controller;

import com.cleanmypins.model.Report;
import com.cleanmypins.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/report")
public class ReportController {

    @Autowired
    ReportRepository reportRepository;

    @PostMapping(path = "/run")
    public Report runReport(){
        Report report =  new Report();

        return reportRepository.save(report);
    }

    @GetMapping(path = "/{reportId}")
    public Report getReport(@PathVariable Long reportId){
        return reportRepository.findByReportId(reportId).get(0);
    }

}
