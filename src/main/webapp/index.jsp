<%@ page import="database.mongoBase" %>
<%@ page import="com.mongodb.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="http://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<h4>author: yilin lou</h4>
<h4>email: ylou7@stevens.edu</h4>

<%
    MongoClient mongoClient = new MongoClient("localhost",27017);

    //link database
    DB db = mongoClient.getDB("IDTIP");

    //choose collection
    DBCollection collection = db.getCollection("IPLocation");
    //显示集合中的数据,查询集合时，常返回DBCursor对象
        DBCursor cursor = collection.find();
%>
<div class="htmleaf-container">
    <div class="container">
        <div class="row">
            <div class="col-sm-12 text-center">
                <a href="search.jsp"><h1 class="h1">Start Search IP Address
                </h1></a>


            </div>
            <div class="col-sm-8 col-sm-offset-2">
                <h3>History <code>&lt;Based on the latest query&gt;</code></h3>

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
                        while(cursor.hasNext()){
                            DBObject obj = cursor.next();


                    %>
                    <tr>
                        <td><%=obj.get("ip")%></td>
                        <td><%=obj.get("city")%></td>
                        <td><%=obj.get("region")%></td>
                        <td><%=obj.get("country")%></td>
                        <td><%=obj.get("latitude")%></td>
                        <td><%=obj.get("longitude")%></td>

                    </tr>
                    <%
                        }
                    %>
                    </tbody>
                </table>
            </div>


        </div>
        <%
//            DBCursor cursor_country = collection.distinct("country");
//            System.out.println(cursor_country.count()+"111111111111111");

            int num=collection.distinct("country").size();
        %>
        <div class="col-sm-8 col-sm-offset-2">
            <form method="post" action="/IPLocation_war_exploded/ShowLatestServlet" id="numberform" name="numberform" onsubmit="return check_post()">
                <h3>Display the latest <input style="width: 250px" type="text" placeholder="please input number" id="number" name="number" > data&nbsp&nbsp&nbsp<button>search</button></h3>

            </form>
            <form method="post" action="/IPLocation_war_exploded/ChooseCountryServlet">
                <h3>Choose a country
                    <select name="country">
                        <%for (int i=0;i<num;i++){
                        %>
                        <option value="<%=collection.distinct("country").get(i)%>">
                            <%=collection.distinct("country").get(i)%>
                        </option>
                        <%}%>

                </select> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                    <button type="submit">search</button></h3>

            </form>
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
<script type="text/javascript">
    function check_post() {

        var n=numberform.number.value;
        if(n == null || n == undefined || n == ''){
            alert("please input a number")
            return false;

        }else {
            alert(n)
            return true

        }



    }


</script>
</body>
</html>
