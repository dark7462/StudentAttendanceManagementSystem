<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Login</title>
    <link rel="stylesheet" href="studentLogin.css">

</head>
<body>

<div class="login-card">
    <h2>Student Login</h2>

    <%-- Error Message Block --%>
    <% String error = (String) request.getAttribute("errorMessage"); %>
    <% if (error != null) { %>
    <div class="error"><%= error %></div>
    <% } %>

    <%-- Login Form --%>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <input type="hidden" name="role" value="student">

        <label>
            <input type="text" name="userId" placeholder="Roll Number (e.g. 24b11ai014)" required>
        </label>
        <label>
            <input type="password" name="password" placeholder="Password" required>
        </label>

        <button type="submit">Login</button>
    </form>

    <a href="${pageContext.request.contextPath}/index.html" class="back-link">← Back to Home</a>
</div>

</body>
</html>