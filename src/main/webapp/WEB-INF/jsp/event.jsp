<head>
<%@ page isELIgnored="false" %>
</head>
<html>
<head>
<title> Event Page </title>
<style type="text/css">
.error{
color: #ff0000;
}
.errorblock{
color: #000;
background-color: #ffEEEE;
border: 3px solid #ff0000;
padding: 8px;
margin: 16px;
}
</style>
</head>
<body>
<form:form commandName = "MyEvent">
<label for="textinput1">Enter Minutes:</label>
<form:input path="name" cssErrorClass="error" />
<form:error path="name" cssClass="error" />
<br>
<input type="submit" class="btn" value="Enter Event"/>
<h2>${MyEvent}</h2>
</form:form>
</body>
</html>
