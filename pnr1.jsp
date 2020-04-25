<!DOCTYPE html>
<html>
<head>
<%@ page import="rlwy.*" %>
<%@ page import="java.sql.*" %>

<title>pnr</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>

<body style="background-color: rgb(255,255,200);">
    
<div id= "icon">
	<img src="G:\priya\semproj\image\1.gif" alt="ICON" >
</div>
<div id="top_strip">PNR STATUS</div>
<div id = "img">
	<img src="G:\priya\semproj\image\4.jpg" alt="ICON" >
</div>

<div id = "box">
	<h2 id = "option">Type your Pnr:</h2>
        <form action = "pnrr.java" method="GET">
	<input type ="text" name = "pnr_no">
        <input type="submit" value="Get Status">
	</form>
        
</div>
</body>
</html>