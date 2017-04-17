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
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-reset.css" rel="stylesheet">
    <!--external css-->
    <link href="css/font-awesome.css" rel="stylesheet" />
    <!-- Custom styles for this template -->
    <link href="css/style.css" rel="stylesheet">
    <link href="css/style-responsive.css" rel="stylesheet" />

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
    <script>
  function loadState()
	{
		var countryId=document.getElementById("countryDrop");
		
		var xmlhttp;
		
		if (window.XMLHttpRequest)
		  {// code for IE7+, Firefox, Chrome, Opera, Safari
		  	xmlhttp=new XMLHttpRequest();
		  }
		else
		  {// code for IE6, IE5
		  	xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		  }
		
		removeAllState();
		
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4) 
			{
				var jsonObj = JSON.parse(xmlhttp.responseText);
				
				for(i=0 ; i<jsonObj.length ; i++)
				{
					var createOption=document.createElement("option");
					
					createOption.value=jsonObj[i].stateId;
					createOption.text=jsonObj[i].stateName;
					
					document.registerUserForm.stateDrop.options.add(createOption);
					
				}
			}
			
		}

		xmlhttp.open("get", "${pageContext.request.contextPath}/RegisterUserController?flag=loadState&countryId="+countryId.value, true);
		xmlhttp.send();
		/* jQuery(".chosen-select1").chosen({'width':'100%','white-space':'nowrap'}); */
		/* Holds the status of the XMLHttpRequest. Changes from 0 to 4:
			0: request not initialized
			1: server connection established
			2: request received
			3: processing request
			4: request finished and response is ready */
	}
	
	function removeAllState()
	{
		var removeState=document.registerUserForm.stateDrop.options.length;
		for(i=removeState ; i>0 ; i-- )
		{
			document.registerUserForm.stateDrop.remove(i);
		}
	}
	
</script>
</head>

  <body class="login-body">

    <div class="container">

      <form class="form-signin" action="${pageContext.request.contextPath}/RegisterUserController" method="post" name="registerUserForm">
        <h2 class="form-signin-heading">sign in now</h2>
        <div class="login-wrap">
          <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
            <input type="text" class="form-control" placeholder="First Name" autofocus name="cname">
             <input type="text" class="form-control" placeholder="Last Name" autofocus name="cname1">
                          <input type="text" class="form-control" placeholder="User Name" autofocus name="cname2">
              <input type="password" class="form-control" placeholder="Password" name="cname3">
             <input type="password" class="form-control" placeholder="Confirm Password" name="cname4">
          <!--    <input type="date" class=" form-control" id="cname5" placeholder="D.O.B" name="cname5"
													minlength="2" type="text" required /> -->
			<input type="text" class="form-control" placeholder="E-mail" autofocus name="cemail">
  
    	  <input type="text" class="form-control" placeholder="Phone no." autofocus name="cname6">
              <%--     <input type="text" class="form-control" placeholder="Address" autofocus name="cname7">
             <!-- <input type="text" class="form-control" placeholder="Country" autofocus name="countryName"> -->
             <select class="form-control" name="countryDrop" id="countryDrop" autofocus name="cname8" onchange="loadState()" required="">
             
													<option>Select Country</option>
													<c:forEach items="${sessionScope.lsCountryRU}" var="i">
													<option value="${i.countryId}">${i.countryName}</option>
													</c:forEach>
												</select>
              <!-- <input type="text" class="form-control" placeholder="State" autofocus name="stateName"> -->
              <select class="form-control"  name="stateDrop" id="stateDrop" autofocus name="cname9" required="">
													<option value="">Select State</option>
													
												</select>
               --%>
             <input type="hidden" name="flag" value="insertRegisteredUser">
            <button class="btn btn-lg btn-login btn-block" type="submit">Sign Up</button>
         <!--    <div class="registration">
                <p>Don't have an account yet?  Create an account</p>
                </a>
            </div> -->
           <!--  <div class="login-social-link">
               
                <a href="registerCompany.jsp" class="twitter">
                    company
                </a>
				<a href="registerDeveloper.jsp" class="facebook">
                    Company's Developer
                </a>
				
            </div>
             -->

        </div>

          <!-- Modal -->
          <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
              <div class="modal-dialog">
                  <div class="modal-content">
                      <div class="modal-header">
                          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                          <h4 class="modal-title">Forgot Password ?</h4>
                      </div>
                      <div class="modal-body">
                          <p>Enter your e-mail address below to reset your password.</p>
                          <input type="text" name="email" placeholder="Email" autocomplete="off" class="form-control placeholder-no-fix">

                      </div>
                      <div class="modal-footer">
                          <button data-dismiss="modal" class="btn btn-default" type="button">Cancel</button>
                          <button class="btn btn-success" type="button">Submit</button>
                      </div>
                  </div>
              </div>
          </div>
          <!-- modal -->

      </form>

    </div>



    <!-- js placed at the end of the document so the pages load faster -->
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>


  </body>
</html>
