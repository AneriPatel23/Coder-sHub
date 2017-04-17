<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
<base href="${pageContext.request.contextPath}/admin/">
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Mosaddek">
    <meta name="keyword" content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
    <link rel="shortcut icon" href="img/favicon.png">

    <title>FlatLab - Flat & Responsive Bootstrap Admin Template</title>

    <!-- Bootstrap core CSS -->
    
    <link href="../admin/css/bootstrap.min.css" rel="stylesheet">
    <link href="../admin/css/bootstrap-reset.css" rel="stylesheet">
    <!--external css-->
    <link href="../admin/css/font-awesome.css" rel="stylesheet" />
    <link href="../admin/css/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen"/>
    <link rel="stylesheet" href="../admin/css/owl.carousel.css" type="text/css">

      <!--right slidebar-->
      <link href="../admin/css/slidebars.css" rel="stylesheet">

    <!-- Custom styles for this template -->

    <link href="../admin/css/style.css" rel="stylesheet">
    <link href="../admin/css/style-responsive.css" rel="stylesheet" />



    <script type="text/javascript">

//ddtreemenu.createTree(treeid, enablepersist, opt_persist_in_days (default is 1))

var temp = 0;

function ProjectName()
{
	var ProjectName = document.getElementById("ProjectName").value;
	var xmlhttp=new XMLHttpRequest();
	 
	xmlhttp.onreadystatechange = function() 
	{
		if (xmlhttp.readyState == 4) 
		{
			var jsonObj = JSON.parse(xmlhttp.responseText);
			//alert(jsonObj.length);
			for(i=0 ; i<jsonObj.length ; i++)
			{
				
			}
		}
	}
	if(ProjectName != null)
	{
		xmlhttp.open("get","${pageContext.request.contextPath}/ProjectController?flag=insertFolder&cname="+ProjectName,true);
		xmlhttp.send();
	}
	else
	{
		alert("Add name..");
	}
		
}

</script>
<script>

function loadFolder()
{
	
	//alert("hiii");
	
	var xmlhttp;
	var form1 = document.getElementById("form1");
	if (window.XMLHttpRequest)
	  {// code for IE7+, Firefox, Chrome, Opera, Safari
	  	xmlhttp=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
	  	xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	
	
	
	xmlhttp.onreadystatechange = function() {
			
		if (xmlhttp.readyState == 4) 
		{
			var jsonObj = JSON.parse(xmlhttp.responseText);
			//alert(jsonObj.length);
			for(i=0 ; i<jsonObj.length ; i++)
			{
				/* var createListItem = document.createElement("input");
				createListItem.setAttribute("type","submit");
				createListItem.setAttribute("style","margin:10px;height:200px");
				createListItem.setAttribute("class","col-lg-3 col-sm-6");
				createListItem.setAttribute("id",jsonObj[i].projectId);
				createListItem.setAttribute("value",jsonObj[i].projectName);
				form1.appendChild(createListItem); */
				
				var a = document.createElement("a");
				var div = document.createElement("div");
				var section = document.createElement("section");
				var div1 = document.createElement("div");
				var h1 = document.createElement("h1");
				var p = document.createElement("p");
				
				p.innerHTML=jsonObj[i].projectName;
				div1.setAttribute("style","margin-top:20px");
				div1.appendChild(p);
				section.setAttribute("class","panel");
				section.setAttribute("style","TEXT-ALIGN: -webkit-center;");
				section.appendChild(div1);
				a.setAttribute("href","${pageContext.request.contextPath}/ProjectController?flag=inside&projectName="+jsonObj[i].projectName);
				a.appendChild(section);
				div.setAttribute("class","col-lg-3 col-sm-6");
				div.setAttribute("style","height:50px;background-color:white;font-size:20px;margin:10px;border-radius:10px");
				div.appendChild(a);
				form1.appendChild(div);
				//document.registeredUserForm.stateDrop.options.add(createOption);
				
			}
		}
		
	}

	xmlhttp.open("get", "${pageContext.request.contextPath}/ProjectController?flag=loadFolder", true);
	xmlhttp.send();
	/* jQuery(".chosen-select1").chosen({'width':'100%','white-space':'nowrap'}); */
	/* Holds the status of the XMLHttpRequest. Changes from 0 to 4:
		0: request not initialized
		1: server connection established
		2: request received
		3: processing request
		4: request finished and response is ready */
	//ddtreemenu.createTree("treemenu1", true, 5)
	
}

 function createFile12(liid,key,name)
{
	
	
	var xmlhttp;
	var treemenu1 = document.getElementById("treemenu1");
	var projId=liid;
	alert(projId.innerHTML);
	
	for (var i = 0; i < treemenu1.childNodes.length; i++) 
	{
		if (treemenu1.childNodes[i].nodeName == "LI")
		{
			if(treemenu1.childNodes[i].id == liid)
				{
				var txt = treemenu1.childNodes[i].innerHTML;
			treemenu1.childNodes[i].innerHTML = txt+"<ul><li>"+name+"</li></ul>";
			
				}
			
			
			
		}
	}
	if (window.XMLHttpRequest)
	  {// code for IE7+, Firefox, Chrome, Opera, Safari
	  	xmlhttp=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
	  	xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	
	xmlhttp.open("get","${pageContext.request.contextPath}/ModuleController?flag=insertModule&cname1="+name+"&projId="+projId,true);
	xmlhttp.send();

	//ddtreemenu.createTree("treemenu1", true, 5)
	
}


</script>
  </head>

  <body  onload="loadFolder()">
  <section id="container" >
      <!--header start-->
      <jsp:include page="header.jsp"></jsp:include>
      <!--header end-->
      <!--sidebar start-->
      
      
      <jsp:include page="menu.jsp"></jsp:include>
    
      <!--sidebar end-->
      <!--main content start-->
      <section id="main-content">
          <section class="wrapper">
              <!--state overview start-->
              <div class="row state-overview">
                  <form action="<%=request.getContextPath()%>/ProjectController" method="post" id="form1" class="raw">
                   Create Project : <input type="text" name="cname" id="ProjectName">
                   <input type="hidden" name="flag" value="createProject">
                   <input type="submit" name="Create">
                   <br>
                   
					<!-- <div class="col-lg-3 col-sm-6">
                      <section class="panel">
                          <div class="symbol terques">
                              <i class="fa fa-user"></i>
                          </div>
                          <div class="value">
                              <h1 class="count">
                                  0
                                  
                              </h1>
                              <p>New Users</p>
                          </div>
                      </section>
                  </div> -->
                  </form>
              </div>
              <!--state overview end-->

          </section>
      </section>
      <!--main content end-->
	
	
	   <!--footer start-->
       <jsp:include page="footer.jsp"></jsp:include>
     
      <!--footer end-->
  </section>

    <!-- js placed at the end of the document so the pages load faster -->
    <script src="../admin/js/jquery.js"></script>
    <script src="../admin/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="../admin/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="../admin/js/jquery.scrollTo.min.js"></script>
    <script src="../admin/js/jquery.nicescroll.js" type="text/javascript"></script>
    <script src="../admin/js/jquery.sparkline.js" type="text/javascript"></script>
    <script src="../admin/js/jquery.easy-pie-chart.js"></script>
    <script src="../admin/js/owl.carousel.js" ></script>
    <script src="../admin/js/jquery.customSelect.min.js" ></script>
    <script src="../admin/js/respond.min.js" ></script>

    <!--right slidebar-->
    <script src="../admin/js/slidebars.min.js"></script>

    <!--common script for all pages-->
    <script src="../admin/js/common-scripts.js"></script>

    <!--script for this page-->
    <script src="../admin/js/sparkline-chart.js"></script>
    <script src="../admin/js/easy-pie-chart.js"></script>
    <script src="../admin/js/count.js"></script>

  <script>

      //owl carousel

      $(document).ready(function() {
          $("#owl-demo").owlCarousel({
              navigation : true,
              slideSpeed : 300,
              paginationSpeed : 400,
              singleItem : true,
			  autoPlay:true

          });
      });

      //custom select box

      $(function(){
          $('select.styled').customSelect();
      });

  </script>

  </body>
</html>