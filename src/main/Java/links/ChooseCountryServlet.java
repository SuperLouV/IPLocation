package links;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Yilinlou
 * @date 2/16/20 12:30 上午
 * @Email:ylou7@stevens.edu
 */
@WebServlet(name = "ChooseCountryServlet" ,urlPatterns="/IPLocation_war_exploded/ChooseCountryServlet")
public class ChooseCountryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String country=request.getParameter("country");
        System.out.println(country);
        request.setAttribute("country",country);


        RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/choosecountry.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
