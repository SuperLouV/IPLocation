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
 * @date 2/15/20 11:08 下午
 * @Email:ylou7@stevens.edu
 */
@WebServlet(name = "ShowLatestServlet",urlPatterns = "/IPLocation_war_exploded/ShowLatestServlet")
public class ShowLatestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int number=Integer.parseInt(request.getParameter("number"));

        System.out.println(number);
        request.setAttribute("number",number);


        RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/showlatest.jsp");
        requestDispatcher.forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
