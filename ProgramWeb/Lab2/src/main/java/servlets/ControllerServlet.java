package servlets;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

//@WebServlet(name = "ControllerServlet", value = "/Controller")
public class ControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double x = Double.parseDouble(new String(
                req.getParameter("x_hidden").getBytes(StandardCharsets.UTF_8)));
        double y = Double.parseDouble(new String(
                req.getParameter("y_hidden").getBytes(StandardCharsets.UTF_8)));
        double r = Double.parseDouble(new String(
                req.getParameter("r_hidden").getBytes(StandardCharsets.UTF_8)));
        System.out.println("Receiving data: x=" + x + ", y=" + y + ", r=" + r);

        req.getServletContext().getRequestDispatcher("/AreaCheck").forward(req,resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.getServletContext().getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
