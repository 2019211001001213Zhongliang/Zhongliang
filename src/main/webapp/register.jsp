<%--
  Created by IntelliJ IDEA.
  User: 86189
  Date: 2021/3/14
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="index.jsp">go to ecjtu</a><!-- method is GET-->
<form method="post" action="register">
    username :<input type="text" name="username"><br/>
    password :<input type="text" name="password"><br/>
    Email:<input type="text" name="email"/><br/>
    Gender:<input type="radio" name="gender"/>Male <input type="radio" name="gender">Female<br/>
    Date of Birth :<input type="text name" name="birthDate"><br/>
    <input type="submit" value="Register"/>
</form>
</body>
</html>