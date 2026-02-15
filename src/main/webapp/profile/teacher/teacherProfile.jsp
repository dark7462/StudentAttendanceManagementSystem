<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- Security Check --%>
<%
    if (session.getAttribute("currentUser") == null || !"teacher".equals(session.getAttribute("role"))) {
        response.sendRedirect("../../login/teacher/teacherLogin.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Teacher Dashboard</title>
    <link rel="stylesheet" href="teacherProfile.css">
</head>
<body>

<div class="profile-container">
    <div class="header">
        <h1>Hello, ${currentUser.name}</h1>
        <p>Teacher Dashboard</p>
    </div>

    <div class="info-section">
        <p><strong>Employee ID:</strong> ${currentUser.emp_id}</p>
        <p><strong>Assigned Class:</strong> ${currentUser.classroom.classId}</p>
        <p><strong>Lectures Delivered:</strong> ${currentUser.classroom.totalClassesHeld}</p>
    </div>

    <div class="action-section">
        <a href="../../attendanceForm.jsp" class="btn-action">Take Attendance</a>
    </div>

    <div class="footer">
        <a href="../../index.html" class="btn-logout">Logout</a>
    </div>
</div>

</body>
</html>