<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Create</title>
</head>
<body>
<h2>Spring MVC Create, Read, Update and Delete (CRUD) Example</h2>
<form action="create" method="post">
<pre>
    <strong>Create Here | <a href="./read">Click for Read</a></strong>

	Name: <input type="text" name="name"/>

	Email: <input type="text" name="email"/>

	 <label>Choose a group:</label>
	<label>
    <select name="groups_name">
           <c:forEach items="${listGroup}" var="groups" varStatus="loop">
		         <option value="${groups.groups_name}">
						 ${groups.groups_name}
				 </option>
		   </c:forEach>
    </select>
	</label>
	<input type="submit" value="Create"/>
</pre>
</form>
${msg}
</body>
</html>

