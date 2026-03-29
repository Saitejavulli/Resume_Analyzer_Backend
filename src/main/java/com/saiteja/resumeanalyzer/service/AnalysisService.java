package com.saiteja.resumeanalyzer.service;

import com.saiteja.resumeanalyzer.dto.AnalysisResponse;
import com.saiteja.resumeanalyzer.model.Resume;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnalysisService {

    private final ResumeService resumeService;

    public AnalysisService(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    public AnalysisResponse analyzeResume(Long resumeId, String jobDescription) {
        Resume resume = resumeService.getResumeById(resumeId);

        String resumeText = resume.getExtractedText().toLowerCase();
        String jdText = jobDescription.toLowerCase();

        List<String> commonSkills = List.of(
                "java", "spring boot", "sql", "postgresql", "mysql",
                "html", "css", "javascript", "react", "git",
                "rest api", "hibernate", "jpa", "docker", "aws"
        );

        List<String> matchedSkills = new ArrayList<>();
        List<String> missingSkills = new ArrayList<>();

        for (String skill : commonSkills) {
            if (jdText.contains(skill)) {
                if (resumeText.contains(skill)) {
                    matchedSkills.add(skill);
                } else {
                    missingSkills.add(skill);
                }
            }
        }

        double matchScore = 0.0;
        int totalRequiredSkills = matchedSkills.size() + missingSkills.size();

        if (totalRequiredSkills > 0) {
            matchScore = ((double) matchedSkills.size() / totalRequiredSkills) * 100;
        }

        String suggestions;
        if (missingSkills.isEmpty()) {
    suggestions = "Your resume matches the job description well. Try improving project impact and measurable achievements.";
} else if (matchScore >= 70) {
    suggestions = "Your resume is fairly aligned. Consider adding these missing skills or related project work: " + String.join(", ", missingSkills);
} else if (matchScore >= 40) {
    suggestions = "Your resume is moderately aligned. Add stronger backend project descriptions and mention: " + String.join(", ", missingSkills);
} else {
    suggestions = "Your resume has low alignment with this role. Add relevant skills, resume keywords, and projects for: " + String.join(", ", missingSkills);
}

        return new AnalysisResponse(matchScore, matchedSkills, missingSkills, suggestions);
    }
}