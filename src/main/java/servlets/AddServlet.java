package servlets;

import dao.JDBCUtils;
import model.ingredients.Ingredient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(urlPatterns = "/add", loadOnStartup = 0)
public class AddServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("id"));
        request.setAttribute("id", id);
        request.getRequestDispatcher("/add.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn = JDBCUtils.getConnectionPool().checkOut();
        String name = request.getParameter("name");
        double weight = Double.parseDouble(request.getParameter("weight"));
        double caloricity = Double.parseDouble(request.getParameter("caloricity"));
        Ingredient ingredient = new Ingredient(name, caloricity, weight);
        int id = Integer.parseInt(request.getParameter("id"));
        JDBCUtils.addIngredient(conn, ingredient, id);
        request.setAttribute("id", id);
        request.getRequestDispatcher("/ingredients").forward(request, response);
    }
}

