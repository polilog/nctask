package servlets;

import dao.JDBCUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(urlPatterns = "/ingredients", loadOnStartup = 0)
public class IngredientsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Connection conn = JDBCUtils.getConnectionPool().checkOut();
        request.setAttribute("ingredients", JDBCUtils.getIngredients(conn, id));
        request.setAttribute("id", id);
        request.getRequestDispatcher("/ingredients.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

