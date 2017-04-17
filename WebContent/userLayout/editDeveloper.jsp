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
							<header class="panel-heading"> Developer Registration </header>
							<div class="panel-body">
								<div class=" form">
								
								 <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
								
								
									<form class="cmxform form-horizontal tasi-form"
										id="commentForm" method="post" action="${pageContext.request.contextPath}/RegisterDeveloperController">
										<c:forEach items="${sessionScope.DeveloperUserNameList}"
											var="l">
											<c:forEach items="${sessionScope.DeveloperUserProfileList}"
												var="i">
										
										<input type="hidden" value="updateDeveloper" name="flag">
										<input type="hidden" name="developerId" value="${i.developerId}">
										<div class="form-group ">
											<label for="cname" class="control-label col-lg-2">First
												Name</label>
											<div class="col-lg-10">
												<input class="form-control" id="cname" value="${i.firstName}" name="cname"
													 type="text" required />
											</div>
										</div>
										<div class="form-group ">
											<label for="cname1" class="control-label col-lg-2">Last 
											Name</label>
											<div class="col-lg-10">
												<input class="form-control" id="cname1" value="${i.lastName}" name="cname1"
													minlength="2" type="text" required />
											</div>
										</div>
										<div class="form-group ">
											<label for="cname" class="control-label col-lg-2">User
												Name</label>
											<div class="col-lg-10">
												<input class="form-control" id="username" value="${l.userName}" name="username"
													 type="text" required />
											</div>
										</div>
										<div class="form-group ">
											<label for="cname" class="control-label col-lg-2">Password</label>
											<div class="col-lg-10">
												<input class="form-control" id="password" value="${l.password}" name="password"
													 type="text" required />
											</div>
										</div>
										<div class="form-group ">
											<label for="cname" class="control-label col-lg-2">E-Mail</label>
											<div class="col-lg-10">
												<input class="form-control" id="cemail" value="${l.email}" name="cemail"
													 type="text" required />
											</div>
										</div>
										<div class="form-group ">
											<label for="cname2" class="control-label col-lg-2">D.O.B
											</label>
											<div class="col-lg-10">
												<input type="date" class=" form-control" id="cname2"  value="${i.dateOfBirth}"name="cname2" 
													minlength="2" type="text" required />
											</div>
										</div>
										<div class="form-group ">
											<label for="cname3" class="control-label col-lg-2">Address
												</label>
											<div class="col-lg-10">
												<input class=" form-control" id="cname3" value="${i.address}" name="cname3"
													minlength="2" type="text" required />
											</div>
										</div>
										
										<div class="form-group ">
											<label for="cname5" class="control-label col-lg-2">Phone-no
												</label>
											<div class="col-lg-10">
												<input class=" form-control" id="cname5" value="${i.phoneNumber}" name="cname5"
													minlength="2" type="text" required />
											</div>
										</div>
										
											<c:forEach items="${sessionScope.DeveloperList}"
												var="j">
										
										<input type="hidden" value="${j.companyVO.companyId}" name="cid"></c:forEach>
										
										
										<div class="form-group">
											<div class="col-lg-offset-2 col-lg-10">
												<button class="btn btn-danger" type="submit">Update</button>
												<button class="btn btn-default" type="button">Cancel</button>
											</div>
										</div>
								</c:forEach></c:forEach>
								
									</form>
								
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
					</div>
					<!-- media -->
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
					</div>
					<!-- media -->
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
					</div>
					<!-- media -->
				</li>
				<li class="online">
					<div class="media">
						<a href="#" class="pull-left media-thumb"> <img alt=""
							src="img/avatar1.jpg" class="media-object">
						</a>
						<div class="media-body">
							<strong>Anjelina Joli</strong> <small>Fockland, UK</small>
						</div>
					</div>
					<!-- media -->
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
					</div>
					<!-- media -->
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


</body>
</html>
