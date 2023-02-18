package servlets;

import beans.Point;
import beans.PointsList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

//@WebServlet(name = "ControllerServlet", value = "/Controller")
public class ControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double x = Double.parseDouble(new String(
                req.getParameter("X").getBytes(StandardCharsets.UTF_8)));
        double y = Double.parseDouble(new String(
                req.getParameter("Y").getBytes(StandardCharsets.UTF_8)));
        double r = Double.parseDouble(new String(
                req.getParameter("R").getBytes(StandardCharsets.UTF_8)));
        System.out.println("x=" + x);
        System.out.println("y=" + y);
        System.out.println("r=" + r);

        Point newPoint = new Point(x, y, r, false);
        PointsList.getPointList().add(newPoint);
    }
}
