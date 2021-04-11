
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>

<form method="post" action="login"><!-- within doPost() in servlet-->
    Login<br/><br/>
    username<input type="text" name="username"/><br/>
    password<input type="password" name="password"/><br/>
    <input type="submit" value="Login" />

</form>
<%@include file="footer.jsp"%>