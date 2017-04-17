<aside>
	<div id="sidebar" class="nav-collapse ">
		<!-- sidebar menu start-->
		<ul class="sidebar-menu" id="nav-accordion">
			<li><a class="active" href="index.jsp"> <i
					class="fa fa-dashboard"></i> <span>Dashboard</span>
			</a></li>
			<!-- <li><a href="login.jsp"> <i class="fa fa-laptop"></i> <span>Login
						Page</span>
			</a></li> -->
			<li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-laptop"></i> <span>Manage Country</span>
			</a>
				<ul class="sub">
					<li><a href="addCountry.jsp">Add Country</a></li>
					<li><a href="${pageContext.request.contextPath}/CountryController?flag=search">Search Country</a></li>
				</ul></li>
			<li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-laptop"></i> <span>Manage State</span>
			</a>
				<ul class="sub">
					<li><a href="${pageContext.request.contextPath}/StateController?flag=search">Add State</a></li>
					<li><a href="${pageContext.request.contextPath}/StateController?flag=search1">Search State</a></li>
				</ul></li>
			<li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-laptop"></i> <span>Manage Company</span>
			</a>
				<ul class="sub">
				<%-- 	<li><a href="${pageContext.request.contextPath}/CompanyController?flag=search">Add Company</a></li> --%>
					<li><a href="${pageContext.request.contextPath}/CompanyController?flag=searchCompany">Search Company</a></li>
				</ul></li>
			
			<li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-laptop"></i> <span>Manage Developer</span>
			</a>
				<ul class="sub">
					<!-- <li><a href="addDeveloper.jsp">Add Developer</a></li> -->
					<li><a href="${pageContext.request.contextPath}/DeveloperController?flag=searchDeveloper">Search Developer</a></li>
				</ul></li>
			
			<li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-laptop"></i> <span>Manage Registered User</span>
			</a>
				<ul class="sub">
					<%-- <li><a href="${pageContext.request.contextPath}/RegisteredUserController?flag=search">Add Registered User</a></li> --%>
					<li><a href="${pageContext.request.contextPath}/RegisteredUserController?flag=searchRegisteredUser">Search Registered User</a></li>
				</ul></li>
				<li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-laptop"></i> <span>Manage Project</span>
			</a>
				<ul class="sub">
				<!-- 	<li><a href="addProject.jsp">Add Project</a></li> -->
					<li><a href="${pageContext.request.contextPath}/ProjectController?flag=searchUser">Search Project</a></li>
				</ul></li>
				<!-- <li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-laptop"></i> <span>Manage Module</span> -->
			</a>
				<%-- <ul class="sub">
					<li><a href="${pageContext.request.contextPath}/ModuleController?flag=search">Add Module</a></li>
					<li><a href="${pageContext.request.contextPath}/ModuleController?flag=search1">Search Module</a></li>
				</ul> --%></li>
			
			<!-- <li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-laptop"></i> <span>Manage File</span> -->
			</a>
				<ul class="sub">
					<%-- <li><a href="${pageContext.request.contextPath}/FileController?flag=search">Add File</a></li> --%>
					<%-- <li><a href="${pageContext.request.contextPath}/FileController?flag=search2">Search File</a></li> --%>
				</ul></li>
			<!-- 	<li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-laptop"></i> <span>Manage Database</span> -->
			</a>
				<ul class="sub">
				<%-- 	<li><a href="addDatabase.jsp">Add Database</a></li>
					<li><a href="${pageContext.request.contextPath}/DatabaseController?flag=searchDatabase">Search Database</a></li> --%>
				</ul></li>
				<li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-laptop"></i> <span>Manage Complain</span>
			</a>
				<ul class="sub">
					<!-- <li><a href="addComplain.jsp">Add Complain</a></li> -->
					<li><a href="${pageContext.request.contextPath}/ComplainController?flag=searchComplain">Search Complain</a></li>
				</ul></li>
				<li class="sub-menu"><a href="javascript:;"> <i
					class="fa fa-laptop"></i> <span>Manage Feedback</span>
			</a>
				<ul class="sub">
					<!-- <li><a href="addFeedback.jsp">Add Feedback</a></li> -->
					<li><a href="${pageContext.request.contextPath}/FeedbackController?flag=searchFeedback">Search Feedback</a></li>
				</ul></li>
			
			
			

			<!--multi level menu start-->
			
			<!--multi level menu end-->

		</ul>
		<!-- sidebar menu end-->
	</div>
</aside>