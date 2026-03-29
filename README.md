#  Resume Analyzer (Spring Boot + React)

##  Overview

AI Resume Analyzer is a full-stack web application that helps users evaluate how well their resume matches a job description.

It extracts text from uploaded resumes (PDF), compares it with job requirements, and provides:

*  Match Score
*  Matched Skills
*  Missing Skills
*  Suggestions for improvement

---

##  Tech Stack

###  Backend

* Java 17
* Spring Boot
* Spring Data JPA
* PostgreSQL
* Maven

### Frontend

* React.js
* Axios
* HTML / CSS

---

##  Features

*  Upload resume (PDF)
*  Extract text from resume
*  Analyze job description
*  Match score calculation
*  Skill comparison
*  Smart suggestions

---

##  Project Structure

```
resume-analyzer-backend/
 ┣ controller/
 ┣ service/
 ┣ repository/
 ┣ model/
 ┣ dto/
 ┣ util/
 ┣ resources/
 ┗ pom.xml

resume-analyzer-frontend/
 ┣ src/
 ┣ public/
 ┗ package.json
```

---

##  How to Run Locally

###  Backend

```bash
cd resume_analyzer
mvn spring-boot:run
```

Make sure PostgreSQL is running and update your database config.

---

###  Frontend

```bash
cd resume-analyzer-frontend
npm install
npm start
```

Frontend runs on:

```
http://localhost:3000
```

Backend runs on:

```
http://localhost:8080
```

---

##  API Endpoints

###  Upload Resume

```
POST /api/resumes/upload
```

###  Analyze Resume

```
POST /api/analysis
```

Example request:

```json
{
  "resumeId": 1,
  "jobDescription": "Java, Spring Boot, SQL, REST API"
}
```

---

##  Deployment 

* Backend: Render
* Frontend: Vercel
* Database: Neon PostgreSQL

---

##  Screenshots

* Resume Upload UI
* Analysis Results Dashboard

---

##  Future Enhancements

*  AI/NLP-based semantic matching
*  Advanced scoring algorithm
*  User authentication
*  Multiple resume support
*  Cloud storage integration

---

##  Author

**Saiteja Vulli**

* 💼 Software Engineer | AI Engineer| AI Enthusiast
*  LinkedIn: https://www.linkedin.com/in/saiteja-vulli-896221247
*  GitHub: https://github.com/Saitejavulli

---
