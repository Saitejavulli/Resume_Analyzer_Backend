package com.saiteja.resumeanalyzer.repository;

import com.saiteja.resumeanalyzer.model.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepository extends JpaRepository<Resume, Long> {
}