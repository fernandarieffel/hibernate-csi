<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${usuarios}" var="u">
    ${u.nome} / ${u.login} / ${u.senha} <br />
    <ul>
        <c:forEach items="${u.logs}" var="l" >
            <li>alterou ${l.idObjeto}@${l.classe} em <fmt:formatDate value="${l.dataHora}" pattern="dd/MM/yyyy 'às' HH:mm"/> </li>
        </c:forEach>
    </ul>
</c:forEach>
</body>
</html>
