package servlets;

import model.main.Cook;
import model.main.FruitSaladCook;
import model.main.VegetableSaladCook;
import model.salads.Salad;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/salads", loadOnStartup = 1)
public class SaladsServlet extends HttpServlet {

    List<Salad> salads = new ArrayList<>();

    private void createSalads() {
        Cook[] cooks = {new VegetableSaladCook(), new FruitSaladCook()};
        for(Cook cook : cooks) {
            Salad salad = cook.createSalad();
            salads.add(salad);
        }
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init();
        createSalads();
        config.getServletContext().setAttribute("salads", salads);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("salads", salads);
        request.getRequestDispatcher("/salads.jsp").forward(request, response);
        }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doPost(request, response);
    }
}
