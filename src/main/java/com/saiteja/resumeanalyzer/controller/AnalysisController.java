package com.saiteja.resumeanalyzer.controller;

import com.saiteja.resumeanalyzer.dto.AnalysisRequest;
import com.saiteja.resumeanalyzer.dto.AnalysisResponse;
import com.saiteja.resumeanalyzer.service.AnalysisService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/analysis")
@CrossOrigin(origins = "http://localhost:3000")
public class AnalysisController {

    private final AnalysisService analysisService;

    public AnalysisController(AnalysisService analysisService) {
        this.analysisService = analysisService;
    }

    @PostMapping
    public ResponseEntity<AnalysisResponse> analyzeResume(@RequestBody AnalysisRequest request) {
        AnalysisResponse response = analysisService.analyzeResume(
                request.getResumeId(),
                request.getJobDescription()
        );
        return ResponseEntity.ok(response);
    }
}