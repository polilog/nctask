package servlets;

import dao.JDBCUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(urlPatterns = "/salads", loadOnStartup = 1)
public class SaladsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Connection conn = JDBCUtils.getConnectionPool().checkOut();
        request.setAttribute("salads", JDBCUtils.getSalads(conn));
        request.getRequestDispatcher("/salads.jsp").forward(request, response);
        }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doPost(request, response);
    }
}
