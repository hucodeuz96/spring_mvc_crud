<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Update</title>
</head>
<body>
<h2>Spring MVC Create, Read, Update and Delete (CRUD) Example</h2>
<p><strong>Update Here | <a href="/student/read">Click for Read</a></strong></p>
<form action="../update" method="post">
<pre>
<c:forEach var="student" items="${listStudent}">

    Id:    	<input type="text" name="dispId" value="${student.id}" disabled="disabled"/>
    <input type="hidden" name="id" value="${student.id}"/>
    Name:  	<input type="text" name="name" value="${student.name}" />

    Email: 	<input type="text" name="email" value="${student.email}" />

    <label>Choose a new group:</label>
    <label>
    <select name="groups_name">
           <c:forEach items="${listGroup}" var="groups" varStatus="loop">
		         <option value="${groups.groups_name}">
                         ${groups.groups_name}
                 </option>
           </c:forEach>
    </select>
	</label>

    <input type="submit" value="Update" />
</c:forEach>
</pre>
</form>
${msg}
</body>
</html>