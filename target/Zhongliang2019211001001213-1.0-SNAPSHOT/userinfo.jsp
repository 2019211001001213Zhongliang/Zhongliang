
<%@page import="com.Zhongliang.model.User" %><%--...--%>
<%@page  contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="header.jsp"%>
<%
    User user=(User) request.getAttribute("user");
%>


<h1>User Info</h1>

<table>
    <tr>
        <td>Username:</td><td><%=user.getUsername()%></td>
    </tr><tr>
    <td>Password:</td><td><%=user.getPassword()%></td>
</tr><tr>
    <td>Email:</td> <td><%=user.getEmail()%></td>
</tr><tr>
    <td>Gender</td><td><%=user.getGender()%></td>
</tr><tr>
    <td>Birthdate:</td> <td><%=user.getBirthdate()%></td>
    </tr>
</table>

<%@include file="footer.jsp" %>