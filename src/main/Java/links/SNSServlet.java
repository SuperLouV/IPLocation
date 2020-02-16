package links;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Yilinlou
 * @date 2/16/20 4:05 下午
 * @Email:ylou7@stevens.edu
 */
@WebServlet(name = "SNSServlet",urlPatterns = "/IPLocation_war_exploded/SNSServlet")
public class SNSServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mobile1= request.getParameter("mobile");
        String front="+1";
        String mobile=front+mobile1;
        System.out.println(mobile);
        String ip= request.getParameter("ip");
        String city= request.getParameter("city");
        String country= request.getParameter("country");
        String region= request.getParameter("region");
        String latitude= request.getParameter("latitude");
        String longitude= request.getParameter("longitude");
        String message="ip:"+ip+"\n"+"city:"+city+"\n";
        StringBuilder message_bulider=new StringBuilder();
        message_bulider.append("ip:").append(ip).append("\n").append("city:").append(city).append("\n").append("country:").append(country).append("\n").append("region:").append(region).append("\n").append("latitude:").append(latitude).append("\n").append("longitude:").append(longitude).append("\n");
        message=message_bulider.toString();
        System.out.println(message);
        SNSPublisher snsPublisher=new SNSPublisher();
        snsPublisher.SendMessage(message,mobile);
        response.sendRedirect("/index.jsp");





    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
