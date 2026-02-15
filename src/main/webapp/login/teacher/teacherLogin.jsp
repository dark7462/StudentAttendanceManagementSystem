<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Teacher Login</title>
    <link rel="stylesheet" href="teacherLogin.css">

</head>
<body>

<div class="login-card">
    <h2>Teacher Login</h2>

    <%-- Error Message Block --%>
    <% String error = (String) request.getAttribute("errorMessage"); %>
    <% if (error != null) { %>
    <div class="error"><%= error %></div>
    <% } %>

    <%-- Login Form --%>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <input type="hidden" name="role" value="teacher">

        <input type="text" name="userId" placeholder="Employee ID" required>
        <input type="password" name="password" placeholder="Password" required>

        <button type="submit">Login</button>
    </form>

    <a href="${pageContext.request.contextPath}/index.html" class="back-link">← Back to Home</a>
</div>

</body>
</html>