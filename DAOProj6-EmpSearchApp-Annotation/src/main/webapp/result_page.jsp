<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <h1 style="color:green;text-align:center">Result page</h1><br>
   
   	<c:choose>
   		<c:when test="${!empty listEmps }">
   			<table align="center" bgcolor="pink" border="1">
   				<tr bgcolor="orange"><td>EMPNO</td><td>ENAME</td><td>JOB</td><td>SALARY</td><td>DEPTNO</td></tr>
   					<c:forEach var="emp" items="${listEmps }">
   						<tr bordercolor="blue">
   							<td>${emp.EMPNO }</td>
   							<td>${emp.ENAME }</td>
   							<td>${emp.JOB }</td>
   							<td>${emp.SAL }</td>
   							<td>${emp.DEPTNO }</td>
   						</tr>		
   					</c:forEach>   						
   			</table>
   		</c:when>
   		<c:otherwise>
   			<h1 style="color:red;text-align:center">Employee not found</h1>
   		</c:otherwise>
   	</c:choose>
    <br>
    <a href="main.html">Home</a>