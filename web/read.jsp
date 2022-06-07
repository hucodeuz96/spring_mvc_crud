<%--
  Created by IntelliJ IDEA.
  User: Husniddin
  Date: 6/3/2022
  Time: 4:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Spring MVC Create, Read, Update and Delete (CRUD) Example</h2>
<p><strong>Person List is Here | <a href="/student/create">Click for Create</a></strong></p>
<table border="1">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>email</th>
        <th>groups_name</th>
        <th>Action</th>
    </tr>
    <c:forEach var="student" items="${dtoList}">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.email}</td>
            <td>${student.groups_name}</td>
            <td><a href="update/<c:out value='${student.id}'/>">Update</a> ||| <a
                    href="delete/<c:out value='${student.id}'/>">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
