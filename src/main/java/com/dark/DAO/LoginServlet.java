package com.dark.DAO;

import com.dark.Entity.Student;
import com.dark.Entity.Teacher;
import com.dark.Util.JPAUtil;

import javax.persistence.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String role = request.getParameter("role");
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");

        EntityManager em = JPAUtil.getEntityManager();
        HttpSession session = request.getSession();

        try {
            boolean isAuthenticated = false;

            if ("student".equals(role)) {
                Student s = em.find(Student.class, userId);
                if (s != null && s.getPassword().equals(password)) {

                    // FIX: Force the Classroom to load while DB is still open
                    s.getClassroom().getTotalClassesHeld();

                    session.setAttribute("currentUser", s);
                    session.setAttribute("role", "student");
                    response.sendRedirect("profile/student/studentProfile.jsp");
                    isAuthenticated = true;
                }
            } else if ("teacher".equals(role)) {
                Teacher t = em.find(Teacher.class, userId);
                if (t != null && t.getPassword().equals(password)) {

                    // FIX: Force the Classroom to load here too
                    t.getClassroom().getTotalClassesHeld();

                    session.setAttribute("currentUser", t);
                    session.setAttribute("role", "teacher");
                    response.sendRedirect("profile/teacher/teacherProfile.jsp");
                    isAuthenticated = true;
                }
            }

            if (!isAuthenticated) {
                // Login failed
                request.setAttribute("errorMessage", "Invalid ID or Password");

                // Determine which login page to send them back to
                String page = "student".equals(role) ? "login/student/studentLogin.jsp" : "login/teacher/teacherLogin.jsp";

                // Note: Check if your login files are in "login/" or "login/student/"
                // Based on your previous structure, it might just be "login/studentLogin.jsp"
                // If your JSP files are directly in webapp/login, use this line instead:
                // String page = "student".equals(role) ? "login/studentLogin.jsp" : "login/teacherLogin.jsp";

                request.getRequestDispatcher(page).forward(request, response);
            }

        } catch (Exception e) {
            System.out.println("Login Error: " + e.getMessage());
             // Print full error to console for debugging
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }
    }
}