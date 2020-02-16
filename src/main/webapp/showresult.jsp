<%--
  Created by IntelliJ IDEA.
  User: louyilin
  Date: 2/15/20
  Time: 5:58 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="database.mongoBase" %>
<%@ page import="com.mongodb.*" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%

%>
<div class="htmleaf-container">
    <div class="container">
        <form method="post" action="/IPLocation_war_exploded/SNSServlet" name="form_table" id="form_table" onsubmit="return check_post()">

        <div class="row">
            <div class="col-sm-12 text-center">
                <a href="../search.jsp"><h1 class="h1">Start Search IP Address
                </h1></a>


            </div>
            <div class="col-sm-8 col-sm-offset-2">
                <h3>  <code>&lt;History&gt;</code></h3>
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>IP address</th>
                        <th>city</th>
                        <th>region</th>
                        <th>country</th>
                        <th>latitude</th>
                        <th>longitude</th>
                    </tr>
                    </thead>
                    <%
                        String ip=(String)request.getAttribute( "ip_info");
                        String city=(String)request.getAttribute( "city_info");
                        String region=(String)request.getAttribute( "region_info");
                        String country=(String)request.getAttribute( "country_info");
                        String latitude=(String)request.getAttribute( "latitude_info");
                        String longitude=(String)request.getAttribute( "longitude_info");



                    %>
                    <input type="hidden" name="ip" value= <%=ip%> >
                    <input type="hidden" name="city" value= <%=city%> >
                    <input type="hidden" name="region" value= <%=region%> >
                    <input type="hidden" name="country" value= <%=country%> >
                    <input type="hidden" name="latitude" value= <%=latitude%> >
                    <input type="hidden" name="longitude" value= <%=longitude%> >

                    <tbody>

                    <tr>
                        <td><%=ip%></td>

                        <td><%=city%></td>
                        <td><%=region%></td>
                        <td><%=country%></td>
                        <td><%=latitude%></td>
                        <td><%=longitude%></td>
                    </tr>


                    </tbody>
                </table>
            </div>


        </div>
        <div>
            <center>
                <a href="../index.jsp">
                    <h2>
                        Back To Home
                    </h2>
                </a>
            </center>

        </div>
        <div >
            <center>
                <h3>

            +1 <input  style="width: 250px;display: inline"  placeholder=" mobil number" id="mobile" name="mobile">
                <button type="submit">Send with message</button>
                </h3>
            </center>



        </div>
        </form>



    </div>
</div>

<script src="http://cdn.bootcss.com/jquery/1.11.0/jquery.min.js" type="text/javascript"></script>
<script>window.jQuery || document.write('<script src="js/jquery-1.11.0.min.js"><\/script>')</script>
<script type="text/javascript" src="js/paginathing.js"></script>
<script type="text/javascript">
    jQuery(document).ready(function($){
        for (var i = 1; i <= 150; i++) {
            $('.list-group').append('<li class="list-group-item"> Item ' + i + '</li>');
        }

        $('.list-group').paginathing({
            perPage: 5,
            limitPagination: 9,
            containerClass: 'panel-footer',
            pageNumbers: true
        })

        $('.table tbody').paginathing({
            perPage: 5,
            insertAfter: '.table',
            pageNumbers: true
        });
    });

        function check_post() {
            var n=form_table.mobile.value;
            if(n == null || n == undefined || n == ''||n.length!=10){
                alert("please check mobile number")
                return false;

            }else {
                alert("send successful")
                return true

            }



        }




</script>
</body>
</html>

