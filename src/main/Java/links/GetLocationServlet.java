package links;

import com.alibaba.fastjson.JSONObject;
import database.mongoBase;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.ResultSet;

//import com.alibaba.fastjson.JSONObject;
/**
 * @author Yilinlou
 * @date 2/11/20 5:39 下午
 * @Email:ylou7@stevens.edu
 */
@WebServlet(name = "GetLocationServlet",urlPatterns= "/IPLocation_war_exploded/GetLocationServlet")
public class GetLocationServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=gb2312");

        request.setCharacterEncoding("utf-8");
        String ip=request.getParameter("ip");
//        System.out.println(ip);
        StringBuilder newip=new StringBuilder();
        newip.append("https://ipapi.co/").append(ip).append("/json/");
        String ip1=newip.toString();
//        System.out.println(ip1);

        URL ipapi = new URL(ip1);

        URLConnection c = ipapi.openConnection();
        c.setRequestProperty("User-Agent", "java-ipapi-client");

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(c.getInputStream())
        );

        String line;
        String json="";
        while ((line = reader.readLine()) != null)
        {
            json=json+line+"\n";

        }
//        System.out.println(json);


        JSONObject jsonObject = JSONObject.parseObject(json);
// 获取到key为shoppingCartItemList的值
        String ip_info = jsonObject.getString("ip");

        String city_info = jsonObject.getString("city");

        String region_info = jsonObject.getString("region_code");

        String country_info = jsonObject.getString("country");

        String latitude_info = jsonObject.getString("latitude");

        String longitude_info = jsonObject.getString("longitude");
        System.out.println("ip address:"+ip_info);
        System.out.println("city:"+city_info);
        System.out.println("region:"+region_info);
        System.out.println("country:"+country_info);
        System.out.println("geolocation: latitude:"+latitude_info+"  longitude: "+longitude_info);

        reader.close();
//////////////////////////////have got all datas



        /////////////////insert databases
        mongoBase mongoBase=new mongoBase();

        if(mongoBase.isthere(ip_info)){                 //if true
            mongoBase.delete1(ip_info);
            try {
                mongoBase.insert(country_info,ip_info,city_info,region_info,latitude_info,longitude_info);

            }catch (Exception e){
                e.printStackTrace();
            };


        }
        else {
            try {
                mongoBase.insert(country_info,ip_info,city_info,region_info,latitude_info,longitude_info);

            }catch (Exception e){
                e.printStackTrace();
            };


        }
        request.setAttribute("ip_info",ip_info);
        request.setAttribute("city_info",city_info);
        request.setAttribute("region_info",region_info);
        request.setAttribute("country_info",country_info);
        request.setAttribute("latitude_info",latitude_info);
        request.setAttribute("longitude_info",longitude_info);


        RequestDispatcher requestDispatcher = this.getServletContext().getRequestDispatcher("/showresult.jsp");
        requestDispatcher.forward(request, response);






    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
