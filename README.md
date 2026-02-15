# 🎓 Student Attendance Management System (SAMS)

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=hibernate&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
![Apache Tomcat](https://img.shields.io/badge/Apache%20Tomcat-F8DC75?style=for-the-badge&logo=apache-tomcat&logoColor=black)

A robust web-based application designed to streamline the process of tracking student attendance. Built using **Java Servlets**, **JSP**, and **Hibernate (JPA)**, this system allows teachers to mark attendance digitally and students to view their real-time attendance statistics.

---

## 🚀 Features

### 👨‍🏫 For Teachers
* **Secure Login:** Role-based authentication using Employee ID.
* **Dashboard:** View assigned class details and total lectures delivered.
* **Take Attendance:** Easy-to-use checkbox interface to mark present students for a specific class.
* **Real-time Updates:** Instantly updates database records for both students and classroom stats.

### 👨‍🎓 For Students
* **Student Profile:** View personal details (Roll Number, Name, Class).
* **Attendance Tracking:** Real-time visibility of:
    * Attendance Percentage (%)
    * Total Days Present
    * Total Classes Held

---

## 🛠️ Tech Stack

* **Backend:** Java (JDK 17+), Servlets, JSP
* **ORM / Database:** Hibernate 5.6 (JPA), MySQL 8.0
* **Frontend:** HTML5, CSS3
* **Build Tool:** Maven
* **Server:** Apache Tomcat 9.0 (Required for `javax.*` support)
* **IDE:** IntelliJ IDEA (Recommended)

---

## ⚙️ Prerequisites

Before running the project, ensure you have the following installed:

1.  **Java Development Kit (JDK):** Version 17 or higher.
2.  **Apache Maven:** For dependency management.
3.  **Apache Tomcat 9:** (Do not use Tomcat 10+ as this project uses `javax.servlet`).
4.  **MySQL Server:** Running locally on port 3306.

---

## 📥 Installation & Setup

### 1. Clone the Repository
```bash
git clone https://github.com/dark7462/StudentAttendanceManagementSystem
cd StudentAttendanceManagementSystem
```
### 2. Database Configuration

1.  Open **MySQL Workbench** or your terminal.

2.  Create a database named `db` (or whatever you prefer).

``` sql
CREATE DATABASE db;
```

3.  **Note:** Hibernate is configured to `update`, so tables (`Student`,
    `Teacher`, `Classroom`) will be created automatically when you run
    the app.

------------------------------------------------------------------------

### 3. Configure `persistence.xml`

Check:

    src/main/resources/META-INF/persistence.xml

Update your MySQL credentials:

``` xml
<property name="javax.persistence.jdbc.user" value="root" />
<property name="javax.persistence.jdbc.password" value="YOUR_PASSWORD_HERE" />
```

------------------------------------------------------------------------

### 4. IntelliJ IDEA Configuration

1.  Open the project in IntelliJ.

2.  **Add Configuration (Run/Debug):**

    -   Click `+` → **Tomcat Server** → **Local**
    -   **Server:** Select your Tomcat 9 installation folder.
    -   **Deployment Tab:** Click `+` → **Artifact** → Select\
        `Student_Attendance_mgmt_system:war exploded`
    -   **Application Context:** Change to `/` (Root)

3.  Click **Apply** and **OK**.

------------------------------------------------------------------------

### ▶ Usage Guide

1.  **Run the Server:**\
    Click the green **Play** button in IntelliJ.

2.  **Access the App:**\
    Open your browser and go to:

```bash
    http://localhost:8080/
```
------------------------------------------------------------------------

### Dummy Data for Testing

Since the database starts empty, insert some dummy data in MySQL to test
login:

``` sql
-- 1. Create a Classroom
INSERT INTO Classroom (class_id, class_held)
VALUES ('AIML-2A', 0);

-- 2. Create a Student (Password: 123)
INSERT INTO Student (rollNumber, name, password, daysPresent, class_id)
VALUES ('24b11ai014', 'John Doe', '123', 0, 'AIML-2A');

-- 3. Create a Teacher (Password: admin)
INSERT INTO Teacher (emp_id, name, password, assigned_class_id)
VALUES ('T001', 'Prof. Smith', 'admin', 'AIML-2A');
```

------------------------------------------------------------------------

### 📁 Project Structure

``` plaintext
src
└── main
    ├── java
    │   └── com.dark
    │       ├── Entity      # Database Models (Student, Teacher, Classroom)
    │       ├── DAO         # Servlets (LoginServlet)
    │       ├── Service     # Business Logic (AttendanceService)
    │       └── Util        # JPA Connection Helper
    │
    ├── resources
    │   └── META-INF
    │       └── persistence.xml   # Database Config
    │
    └── webapp
        ├── css          # Stylesheets
        ├── login        # Login JSPs
        ├── profile      # Dashboard JSPs
        └── index.html   # Landing Page
```

------------------------------------------------------------------------

### 🤝 Contributing

Contributions are welcome!\
Please fork the repository and create a pull request.

------------------------------------------------------------------------

### 📄 License

This project is licensed under the **MIT License**.
