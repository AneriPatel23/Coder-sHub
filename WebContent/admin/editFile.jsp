<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Mosaddek">
<meta name="keyword"
	content="FlatLab, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<link rel="shortcut icon" href="img/favicon.png">

<title>Form Validation</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap-reset.css" rel="stylesheet">
<!--external css-->
<link href="css/font-awesome.css" rel="stylesheet" />
<!--right slidebar-->
<link href="css/slidebars.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="css/style.css" rel="stylesheet">
<link href="css/style-responsive.css" rel="stylesheet" />

<!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
<!--[if lt IE 9]>
      <script src="js/html5shiv.js"></script>
      <script src="js/respond.min.js"></script>
    <![endif]-->
    <script>
  function loadModule()
	{
		var projectId=document.getElementById("projectDrop");
		
		var xmlhttp;
		
		if (window.XMLHttpRequest)
		  {// code for IE7+, Firefox, Chrome, Opera, Safari
		  	xmlhttp=new XMLHttpRequest();
		  }
		else
		  {// code for IE6, IE5
		  	xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		  }
		
		removeAllModule();
		
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4) 
			{
				var jsonObj = JSON.parse(xmlhttp.responseText);
				
				for(i=0 ; i<jsonObj.length ; i++)
				{
					var createOption=document.createElement("option");
					
					createOption.value=jsonObj[i].moduleId;
					createOption.text=jsonObj[i].moduleName;
					
					document.fileForm.moduleDrop.options.add(createOption);
					
				}
				if(flag == "load")
				{
				selectModule();					
				}
			}
			
		}

		xmlhttp.open("get", "${pageContext.request.contextPath}/FileController?flag=loadModule&projectId="+projectId.value, true);
		xmlhttp.send();
		/* jQuery(".chosen-select1").chosen({'width':'100%','white-space':'nowrap'}); */
		/* Holds the status of the XMLHttpRequest. Changes from 0 to 4:
			0: request not initialized
			1: server connection established
			2: request received
			3: processing request
			4: request finished and response is ready */
	}
	
	function removeAllModule()
	{
		var removeModule=document.fileForm.moduleDrop.options.length;
		for(i=removeModule ; i>0 ; i-- )
		{
			document.fileForm.moduleDrop.remove(i);
		}
	}
loadModule("load");
	
	function selectModule()
	{
	var moduleName = document.getElementById("moduleDrop");
	var hdmoduleid = document.getElementById("hdnmoduleid");
	
	
	
	var removeModule=moduleName.options.length;
	
	if(removeModule!= "undefined"){
		var modulearr=moduleName.options;
		
		for(i=0 ; i<removeModule ; i++ )
	{
			
			var si = modulearr[i].value;
			var hc = modulearr[i].value==hdnmoduleid.value;
			
		if(	modulearr[i].value==hdnmoduleid.value)
			{
			modulearr[i].selected="selected";
			}
	}}
	}


	
</script>
    
    
</head>

<body>

	<section id="container" class="">
		<!--header start-->
		<jsp:include page="header.jsp"></jsp:include>
		<!--header end-->
		<!--sidebar start-->
		<jsp:include page="menu.jsp"></jsp:include>
		<!--sidebar end-->
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper">
				<!-- page start-->
				<div class="row">
					<div class="col-lg-12">
						<section class="panel">
							<header class="panel-heading"> File Details </header>
							<div class="panel-body">
								<div class=" form">
								<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
								<c:forEach items="${sessionScope.pqr}" var="row">
								
									<form class="cmxform form-horizontal tasi-form"
										id="commentForm" method="post" action="${pageContext.request.contextPath}/FileController">
										<input type="hidden" name="flag" value="update">
										<input type="hidden" name="fileId" value="${row.fileId}" >
										
										<div class="form-group ">
											<label for="cname" class="control-label col-lg-2">Project
												Name</label>
											<div class="col-lg-10">
												<select class="form-control m-bot15" name="projectDrop" id="projectDrop" onchange="loadModule()">
													<option>select</option>
													 
													 <c:forEach items="${sessionScope.projectList}" var="i">
													 <c:if test="${i.projectId eq row.pv.projectId}">
													 	<option value="${i.projectId}" selected="selected">${i.projectName}</option>
													 </c:if>
													 
													 <c:if test="${i.projectId ne row.pv.projectId}">
													 	<option value="${i.projectId}">${i.projectName}</option>
													 </c:if>
													 </c:forEach>
												</select>
											</div>
										</div>
										
										<div class="form-group ">
											<label for="cname1" class="control-label col-lg-2">Module
												Name</label>
											<div class="col-lg-10">
												<select class="form-control m-bot15" name="moduleDrop" id="moduleDrop">
													<option>select</option>
													 
													 <c:forEach items="${sessionScope.moduleList}" var="i">
													 <c:if test="${i.moduleId eq row.mv.moduleId}">
													 	<option value="${i.moduleId}" selected="selected">${i.moduleName}</option>
													 </c:if>
													 
													 <c:if test="${i.moduleId ne row.mv.moduleId}">
													 	<option value="${i.moduleId}">${i.moduleName}</option>
													 </c:if>
													 </c:forEach>
												</select>
											</div>
										</div>
										
										<c:forEach items="${sessionScope.pqr}" var="i">
										
										<div class="form-group ">
											<label for="cname2" class="control-label col-lg-2">File
												Name</label>
											<div class="col-lg-10">
												<input class=" form-control" id="cname2" value="${i.fileName}" name="cname2"
													minlength="2" type="text" required />
											</div>
										</div>
										</c:forEach>
										<div class="form-group">
											<div class="col-lg-offset-2 col-lg-10">
												<button class="btn btn-danger" type="submit">Save</button>
												<button class="btn btn-default" type="button">Cancel</button>
											</div>
										</div>
									</form>
									</c:forEach>
								</div>

							</div>
						</section>
					</div>
				</div>
				<!-- page end-->
			</section>
		</section>
		<!--main content end-->
		<!-- Right Slidebar start -->
		<div class="sb-slidebar sb-right sb-style-overlay">
			<h5 class="side-title">Online Customers</h5>
			<ul class="quick-chat-list">
				<li class="online">
					<div class="media">
						<a href="#" class="pull-left media-thumb"> <img alt=""
							src="img/chat-avatar2.jpg" class="media-object">
						</a>
						<div class="media-body">
							<strong>John Doe</strong> <small>Dream Land, AU</small>
						</div>
					</div> <!-- media -->
				</li>
				<li class="online">
					<div class="media">
						<a href="#" class="pull-left media-thumb"> <img alt=""
							src="img/chat-avatar.jpg" class="media-object">
						</a>
						<div class="media-body">
							<div class="media-status">
								<span class=" badge bg-important">3</span>
							</div>
							<strong>Jonathan Smith</strong> <small>United States</small>
						</div>
					</div> <!-- media -->
				</li>

				<li class="online">
					<div class="media">
						<a href="#" class="pull-left media-thumb"> <img alt=""
							src="img/pro-ac-1.png" class="media-object">
						</a>
						<div class="media-body">
							<div class="media-status">
								<span class=" badge bg-success">5</span>
							</div>
							<strong>Jane Doe</strong> <small>ABC, USA</small>
						</div>
					</div> <!-- media -->
				</li>
				<li class="online">
					<div class="media">
						<a href="#" class="pull-left media-thumb"> <img alt=""
							src="img/avatar1.jpg" class="media-object">
						</a>
						<div class="media-body">
							<strong>Anjelina Joli</strong> <small>Fockland, UK</small>
						</div>
					</div> <!-- media -->
				</li>
				<li class="online">
					<div class="media">
						<a href="#" class="pull-left media-thumb"> <img alt=""
							src="img/mail-avatar.jpg" class="media-object">
						</a>
						<div class="media-body">
							<div class="media-status">
								<span class=" badge bg-warning">7</span>
							</div>
							<strong>Mr Tasi</strong> <small>Dream Land, USA</small>
						</div>
					</div> <!-- media -->
				</li>
			</ul>
			<h5 class="side-title">pending Task</h5>
			<ul class="p-task tasks-bar">
				<li><a href="#">
						<div class="task-info">
							<div class="desc">Dashboard v1.3</div>
							<div class="percent">40%</div>
						</div>
						<div class="progress progress-striped">
							<div style="width: 40%" aria-valuemax="100" aria-valuemin="0"
								aria-valuenow="40" role="progressbar"
								class="progress-bar progress-bar-success">
								<span class="sr-only">40% Complete (success)</span>
							</div>
						</div>
				</a></li>
				<li><a href="#">
						<div class="task-info">
							<div class="desc">Database Update</div>
							<div class="percent">60%</div>
						</div>
						<div class="progress progress-striped">
							<div style="width: 60%" aria-valuemax="100" aria-valuemin="0"
								aria-valuenow="60" role="progressbar"
								class="progress-bar progress-bar-warning">
								<span class="sr-only">60% Complete (warning)</span>
							</div>
						</div>
				</a></li>
				<li><a href="#">
						<div class="task-info">
							<div class="desc">Iphone Development</div>
							<div class="percent">87%</div>
						</div>
						<div class="progress progress-striped">
							<div style="width: 87%" aria-valuemax="100" aria-valuemin="0"
								aria-valuenow="20" role="progressbar"
								class="progress-bar progress-bar-info">
								<span class="sr-only">87% Complete</span>
							</div>
						</div>
				</a></li>
				<li><a href="#">
						<div class="task-info">
							<div class="desc">Mobile App</div>
							<div class="percent">33%</div>
						</div>
						<div class="progress progress-striped">
							<div style="width: 33%" aria-valuemax="100" aria-valuemin="0"
								aria-valuenow="80" role="progressbar"
								class="progress-bar progress-bar-danger">
								<span class="sr-only">33% Complete (danger)</span>
							</div>
						</div>
				</a></li>
				<li><a href="#">
						<div class="task-info">
							<div class="desc">Dashboard v1.3</div>
							<div class="percent">45%</div>
						</div>
						<div class="progress progress-striped active">
							<div style="width: 45%" aria-valuemax="100" aria-valuemin="0"
								aria-valuenow="45" role="progressbar" class="progress-bar">
								<span class="sr-only">45% Complete</span>
							</div>
						</div>

				</a></li>
				<li class="external"><a href="#">See All Tasks</a></li>
			</ul>
		</div>
		<!-- Right Slidebar end -->
		<!--footer start-->
		<footer class="site-footer">
			<div class="text-center">
				2013 &copy; FlatLab by VectorLab. <a href="#" class="go-top"> <i
					class="fa fa-angle-up"></i>
				</a>
			</div>
		</footer>
		<!--footer end-->
	</section>

	<!-- js placed at the end of the document so the pages load faster -->
	<script src="js/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script class="include" type="text/javascript"
		src="js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="js/jquery.scrollTo.min.js"></script>
	<script src="js/jquery.nicescroll.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/jquery.validate.min.js"></script>
	<script src="js/respond.min.js"></script>

	<!--right slidebar-->
	<script src="js/slidebars.min.js"></script>

	<!--common script for all pages-->
	<script src="js/common-scripts.js"></script>

	<!--script for this page-->
	<script src="js/form-validation-script.js"></script>
	<script>
	loadModule("load");

</script>
	


</body>
</html>
