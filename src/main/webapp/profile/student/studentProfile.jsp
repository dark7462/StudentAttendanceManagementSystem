<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- Security Check --%>
<%
    if (session.getAttribute("currentUser") == null || !"student".equals(session.getAttribute("role"))) {
        // Redirect back to login if unauthorized
        response.sendRedirect("../../login/student/studentLogin.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Profile</title>
    <link rel="stylesheet" href="studentProfile.css">
</head>
<body>

<div class="profile-container">
    <div class="header">
        <h1>Welcome, ${currentUser.name}</h1>
        <p>Student Dashboard</p>
    </div>

    <div class="stats-grid">
        <div class="card">
            <h2>${currentUser.attendencePercentage}%</h2>
            <span>Attendance</span>
        </div>
        <div class="card">
            <h2>${currentUser.daysPresent}</h2>
            <span>Days Present</span>
        </div>
        <div class="card">
            <h2>${currentUser.classroom.totalClassesHeld}</h2>
            <span>Total Classes</span>
        </div>
    </div>

    <div class="details-section">
        <p><strong>Roll Number:</strong> ${currentUser.rollNumber}</p>
        <p><strong>Class:</strong> ${currentUser.classroom.classId}</p>
    </div>

    <div class="footer">
        <a href="../../index.html" class="btn-logout">Logout</a>
    </div>
</div>

</body>
</html>