<%@ page import="com.vilo3.model.TTMRate" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: yuchenwu
  Date: 16-12-1
  Time: 下午12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<form method="post" action="/ttmRateList.do">
    <label>营业日
        <input type="text" name="tradeDate" value="<%=request.getAttribute("tradeDate")%>"/>
    </label>
    <label>
        <input type="submit" name="Submit" value="检索"/>
    </label>
</form>
<h1>当日评价汇率</h1>
<% List<TTMRate> list = (List<TTMRate>) request.getAttribute("ttmRates"); %>
<% for(TTMRate t : list) {%>
<%= t.getCurrencyPair()%> = <%= t.getValue()%> <br>
<%}%>
</body>
</html>
