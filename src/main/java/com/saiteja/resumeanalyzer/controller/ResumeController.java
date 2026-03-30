package com.saiteja.resumeanalyzer.controller;

import com.saiteja.resumeanalyzer.model.Resume;
import com.saiteja.resumeanalyzer.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/resumes")
@RequiredArgsConstructor
@CrossOrigin(origins = "https://resume-analyzer-frontend-jet.vercel.app")
public class ResumeController {

    private final ResumeService resumeService;

    @PostMapping("/upload")
    public ResponseEntity<Resume> uploadResume(@RequestParam("file") MultipartFile file) throws Exception {
        Resume saved = resumeService.uploadResume(file);
        return ResponseEntity.ok(saved);
    }
}