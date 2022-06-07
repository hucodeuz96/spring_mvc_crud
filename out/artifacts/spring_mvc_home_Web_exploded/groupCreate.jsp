<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Create</title>
</head>
<body>
<h2>Spring MVC Create, Read, Update and Delete (CRUD) Example</h2>
<form action="groupCreate" method="post">
<pre>
    <strong>Create Here | <a href="./groupRead">Click for Read</a></strong>

	Name: <input type="text" name="groups_name"/>

	<input type="submit" value="Create"/>
</pre>
</form>
${msg}
</body>
</html>

