<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h1>Person List</h1>
<table>
  <tr>
    <th>Name</th>
    <th>Age</th>
  </tr>
  <c:forEach items="${personList}" var="person">
    <tr>
      <td>${person.name}</td>
      <td>${person.age}</td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
