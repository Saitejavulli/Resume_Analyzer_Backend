package com.saiteja.resumeanalyzer.service;

import com.saiteja.resumeanalyzer.model.Resume;
import com.saiteja.resumeanalyzer.repository.ResumeRepository;
import com.saiteja.resumeanalyzer.util.PdfUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ResumeService {

    private final ResumeRepository resumeRepository;

    public Resume uploadResume(MultipartFile file) throws IOException {

        String extractedText = PdfUtil.extractText(file);

        Resume resume = Resume.builder()
                .fileName(file.getOriginalFilename())
                .extractedText(extractedText)
                .uploadedAt(LocalDateTime.now())
                .build();

        return resumeRepository.save(resume);
    }

    public Resume getResumeById(Long id) {
        return resumeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resume not found with id: " + id));
    }
}