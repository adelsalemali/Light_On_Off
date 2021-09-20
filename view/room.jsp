<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body> 
                                                                                  
            <form action="ServletInsert" method="get">
              <a href="<c:url value="/ServletList"/>">Student List</a> 		
                <h2>Make Your Room</h2>
                
                <label>Room</label>
                <input type="text" name="room"><br><br>  
                
                
                <select name="country"> 
                
                	<c:forEach var="country" items="${countries}">
                	
                		<option value="${country.country_id}">${country.country_name}</option> 
                		
                	</c:forEach> 
                	
             </select>
                

                <input  type="submit" value="Create"> <br>

            </form>
            
             
            
</body>
</html>