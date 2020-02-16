package links;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Yilinlou
 * @date 2/15/20 5:45 下午
 * @Email:ylou7@stevens.edu
 */
@WebServlet(name = "ShowResultServlet",urlPatterns = "/IPLocation_war_exploded/ShowResultServlet")
public class ShowResultServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
