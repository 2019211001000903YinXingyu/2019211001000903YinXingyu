<%--
  Created by IntelliJ IDEA.
  User: 殷星雨
  Date: 2021/4/1
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>

    <h1>Login<br>

    <form method="post" action="/login">
        <label for="Username">USERNAME</label><br/>
        <input type="text" name="Username" id="Username" placeholder="Please input username" required autofocus><br/>

        <label for="Password">PASSWORD</label><br/>
        <input type="password" name="Password" id="Password" placeholder="Please input password" required autofocus minlength="8"><br/>

        <input type="submit" value="login"/><br/>
    </form>
<%@include file="footer.jsp"%>
