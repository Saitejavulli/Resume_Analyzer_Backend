package com.saiteja.resumeanalyzer.dto;

import java.util.List;

public class AnalysisResponse {
    private double matchScore;
    private List<String> matchedSkills;
    private List<String> missingSkills;
    private String suggestions;

    public AnalysisResponse() {
    }

    public AnalysisResponse(double matchScore, List<String> matchedSkills, List<String> missingSkills, String suggestions) {
        this.matchScore = matchScore;
        this.matchedSkills = matchedSkills;
        this.missingSkills = missingSkills;
        this.suggestions = suggestions;
    }

    public double getMatchScore() {
        return matchScore;
    }

    public void setMatchScore(double matchScore) {
        this.matchScore = matchScore;
    }

    public List<String> getMatchedSkills() {
        return matchedSkills;
    }

    public void setMatchedSkills(List<String> matchedSkills) {
        this.matchedSkills = matchedSkills;
    }

    public List<String> getMissingSkills() {
        return missingSkills;
    }

    public void setMissingSkills(List<String> missingSkills) {
        this.missingSkills = missingSkills;
    }

    public String getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(String suggestions) {
        this.suggestions = suggestions;
    }
}