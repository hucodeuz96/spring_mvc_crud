<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Update</title>
</head>
<body>
<h2>Spring MVC Create, Read, Update and Delete (CRUD) Example</h2>
<p><strong>Update Here | <a href="/group/groupRead/">Click for Read</a></strong></p>
<form action="../groupUpdate" method="post">
<pre>
<c:forEach var="group" items="${listGroup}">

    Id:    	<input type="text" name="dispId" value="${group.id}" disabled="disabled"/>
    <input type="hidden" name="id" value="${group.id}"/>
    Name:  	<input type="text" name="groups_name" value="${group.groups_name}" />

    <input type="submit" value="Update" />
</c:forEach>
</pre>
</form>
${msg}
</body>
</html>