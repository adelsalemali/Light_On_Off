<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/styleList.css">  

</head>
<body> 
   <a href="<c:url value="ServletStart"/>">Form</a> 
          <h2>List of rooms</h2>
          <table>
              <thead>
              
                  <tr>
                  
              	    <th>ID</th>  
              	    <th>Room</th>
              	    <th>Country</th>
              	    <th>Action</th>
              	     
              	</tr>
              	
              </thead>
              
              <tbody> 
              
                 <c:forEach var="list"  items="${abady}">
                 
                   <tr>
                                  
                      <td><c:out value="${list.room_id}"/></td> 
                      <td><c:out value="${list.room_name}"/></td> 
                      <td><c:out value="${list.country_name}"/></td>
             
                     <td> <a href="<c:url value="page.jsp"><c:param name="id" value="${list.room_id}"/></c:url>">About room</a></td> 
                   </tr> 

                   </c:forEach>

              </tbody>
          </table>
          
           		
</body>
</html>