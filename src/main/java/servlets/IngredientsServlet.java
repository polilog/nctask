package servlets;

import model.ingredients.Ingredient;
import model.main.Cook;
import model.main.FruitSaladCook;
import model.main.VegetableSaladCook;
import model.salads.Salad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/ingredients", loadOnStartup = 0)
public class IngredientsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Salad> salads = (List<Salad>)request.getServletContext().getAttribute("salads");

        int id = Integer.parseInt(request.getParameter("id"));
        List<Ingredient> ingredients = salads.get(id - 1).getIngredients();
        request.setAttribute("ingredients", ingredients);
        request.getRequestDispatcher("/ingredients.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doPost(request, response);
    }
}

