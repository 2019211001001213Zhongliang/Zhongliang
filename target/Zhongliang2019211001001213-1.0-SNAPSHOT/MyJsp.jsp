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
<form method="post"><!--what is method when we use form?--><!-- its GET , why? default is GET, form data is added in the URL , u can see-->
    <!-- its better to use POST in form , data in not added in the URL -->
    姓名usename :<input type="text" name="name"><br/>
    学号id :<input type="text" name="id"><br/>
    邮箱mailbox:<input type="text" name="URL" size="20" maxlength="50" value="http://" /><br/><br/>
    您的性别:
    <input type="radio" name="sex" value="男man"/>男man
    <input type="radio" name="sex" value="女woman"/>女
    <input type="radio" name="sex" value="无"/>无<br/><br/>
    <input type="submit" value="Send data server"/>
</form>
</body>
</html>
