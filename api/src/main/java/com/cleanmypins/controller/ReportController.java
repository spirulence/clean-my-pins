package com.cleanmypins.controller;

import com.cleanmypins.model.Report;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/report")
public class ReportController {

    @PostMapping(path = "/run")
    public Report runReport(){

        return new Report();
    }

    @GetMapping(path = "/{reportId}")
    public Report getReport(@PathVariable String reportId){
        return new Report();
    }

}
