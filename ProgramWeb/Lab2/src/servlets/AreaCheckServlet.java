package servlets;

import beans.Point;
import beans.PointsList;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//@WebServlet(name = "AreaCheckServlet", value = "/AreaCheck")
public class AreaCheckServlet extends HttpServlet {
    private PointsList pointsList;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        long startTime = System.currentTimeMillis();
        req.getServletContext().getRequestDispatcher("/result.jsp").include(req,resp);
        pointsList = (PointsList) req.getSession().getAttribute("pointsBean");

        double x = Double.parseDouble(req.getParameter("x_hidden").trim());
        double y = Double.parseDouble(req.getParameter("y_hidden").trim());
        double r = Double.parseDouble(req.getParameter("r_hidden").trim());

        Point point = new Point(x,y,r);
        checkPoint(point);

        long endTime = System.currentTimeMillis();
        long timeUsage = endTime - startTime;
        point.setTimeUsage(timeUsage);
        pointsList.addPoint(point);

        req.getServletContext().getRequestDispatcher("/index.jsp").forward(req,resp);
    }

    private void checkPoint(Point p) {
        if (0 <= p.getX() && p.getX() <= p.getR() && 0 <= p.getY() && p.getY() <= 0.5 * p.getR()) {
            p.setRes(true);
        } else if (p.getX() >= 0 && p.getY() <= 0 && p.getX() * p.getX() + p.getY() * p.getY() <= p.getR() * p.getR()){
            p.setRes(true);
        } else p.setRes(p.getX() <= 0 && p.getY() <= 0 && p.getX() + p.getY() <= p.getR());
    }

}
