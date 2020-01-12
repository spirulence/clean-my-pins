package com.cleanmypins.test;

import com.cleanmypins.model.Report;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.time.Duration;
import java.util.Collections;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ReportFlowTest extends BaseTestConfig {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void runReportForBoard(){
        //user submits a board URL to an endpoint
        Map<String, String> variables = Collections.singletonMap("board", "cameronseebach/tech-art");
        Report report = restTemplate.postForObject("/report/run", variables, Report.class);

        Map<String, Long> reportId = Collections.singletonMap("reportId", report.reportId);

        //does the report object get created?
        assertNotNull(report);
        assertEquals(Report.State.STARTED, report.reportState);

        //does the report eventually finish?
        assertTimeout(Duration.ofSeconds(30), () -> {
            Report runningReport = restTemplate.getForObject("/report/{reportId}", Report.class, reportId);
            while (runningReport.reportState != Report.State.FINISHED){
                runningReport = restTemplate.getForObject("/report/{reportId}", Report.class, reportId);
            }
        });

        //does the report contain the right results?
        Report finishedReport = restTemplate.getForObject("/report/{reportId}", Report.class, reportId);
        assertNotNull(finishedReport.greenLinks);
        assertNotNull(finishedReport.redLinks);
    }

}
