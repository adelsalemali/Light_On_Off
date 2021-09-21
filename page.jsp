<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
const id = ${param['id']};
</script> 
</head>

<body onload="myFunction(false); setInterval(myFunction, 100, false);">

           <button onclick="myFunction(true)">Turn Off/On</button> 
          <!-- initial value of element if our browser not support JS, otherwise, if JS supported
          function myFunction(false) will started automatically after page will load and this.
          function replace content of this element -->   
          <div id="myDIV">JavaScript not supported</div>
           
            <script> 
            async  function myFunction(action) {
            	let url = 'ServletLight_Off_On?roomid=' + id;
            	if(action) {
            		url += '&turn';
            	}
           		let response = await fetch(new Request(url));
               	let light = await response.text();
               	console.log(light);
               	let message = (light == 'true') ? 'Turn on' : 'Turn off';
	         	var x = document.getElementById("myDIV");
            	x.innerHTML = message;
            } 
            </script>
</body>
</html>