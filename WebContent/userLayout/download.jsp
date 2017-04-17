<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
yo
<%-- <%    

/* String path=(String)session.getAttribute("path"); 
System.out.println("donload> path - "+path);

String submit = request.getParameter("submit");
System.out.println(submit);

String file=(String)session.getAttribute("file"); 
System.out.println("donload> file - "+file);

  */
  String fileZip=(String)session.getAttribute("destZip"); 
  System.out.println("donload.jsp> file - "+fileZip);
 
  /* 
  String filename = file;   
  String filepath = path;    */
  response.setContentType("APPLICATION/OCTET-STREAM");   
  response.setHeader("Content-Disposition","attachment; filename=\"" + "zipCode" + "\"");   
  
  java.io.FileInputStream fileInputStream=new java.io.FileInputStream(fileZip);  
            
  int i;   
  while ((i=fileInputStream.read()) != -1) {  
    out.write(i);   
  }   
  fileInputStream.close();   
%>   
 --%>
 
 <%
 String projectName=(String) session.getAttribute("projectname");
 String path=(String) session.getAttribute("path31");

 System.out.print(projectName);
 System.out.print(path);
 
   String filename = projectName+".zip";   
   String filepath = path+"/";   
   response.setContentType("APPLICATION/OCTET-STREAM");   
   response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");   
   
   java.io.FileInputStream fileInputStream=new java.io.FileInputStream(filepath);  
             
   int i;   
   while ((i=fileInputStream.read()) != -1) {  
     out.write(i);   
   }   
   fileInputStream.close();   
 %>     
</body>
</html>