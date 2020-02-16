<%--
  Created by IntelliJ IDEA.
  User: louyilin
  Date: 2/15/20
  Time: 11:34 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="database.mongoBase" %>
<%@ page import="com.mongodb.*" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Array" %>
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
    //link mongodb
    MongoClient mongoClient = new MongoClient("localhost",27017);

    //link database
    DB db = mongoClient.getDB("IDTIP");

    //choose collection
    DBCollection collection = db.getCollection("IPLocation");
    DBCursor cursor = collection.find();
    int totalnumber=cursor.count();
    int n= (int) request.getAttribute("number");
    int start=totalnumber-n;

    DBCursor cursor1 = collection.find().limit(n).skip(start);
%>
<div class="htmleaf-container">
    <div class="container">
        <div class="row">
            <div class="col-sm-12 text-center">
                <a href="../search.jsp"><h1 class="h1">Start Search IP Address
                </h1></a>


            </div>
            <div class="col-sm-8 col-sm-offset-2">
                <h3> The latest <code>&lt;<%=n %>&gt;</code> data</h3>
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
                    <tbody>
                    <%
                        while(cursor1.hasNext()){
                        DBObject obj = cursor1.next();

                    %>


                    <tr>
                        <td><%=obj.get("ip")%></td>
                        <td><%=obj.get("city")%></td>
                        <td><%=obj.get("region")%></td>
                        <td><%=obj.get("country")%></td>
                        <td><%=obj.get("latitude")%></td>
                        <td><%=obj.get("longitude")%></td>
                    </tr>
                    <%}%>

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
</script>
</body>
</html>
