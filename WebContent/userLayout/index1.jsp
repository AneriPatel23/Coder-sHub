<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath}/userLayout/" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/tinymce/tinymce.min.js"></script>
<script>
	tinymce.init({
		selector:'#myeditor',
		menubar: "false"    
		
	});
	
</script>
<script type="text/javascript" src="js/simpletreemenu.js">

/***********************************************
* Simple Tree Menu- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* Please keep this notice intact
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/

</script>
<link rel="stylesheet" type="text/css" href="css/style3.css" />
<link rel="stylesheet" type="text/css" href="css/simpletree.css" />

<link rel="stylesheet" href="css/theme.css" type="text/css" />
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />

<link href="css/jquery.contextMenu.css" rel="stylesheet" type="text/css" />


<script type="text/javascript">

//ddtreemenu.createTree(treeid, enablepersist, opt_persist_in_days (default is 1))

ddtreemenu.createTree("treemenu2", true, 5)

var temp = 0;

function createFolder()
{
	<%
	HttpSession session1=request.getSession();
	String menuPath=(String)session1.getAttribute("tree");
	System.out.print("??????????"+menuPath);
	%>

	
 	var treemenu1 = document.getElementById("treemenu1");
 	
	var foldername = prompt("Enter Folder Name","Folder");
	if(foldername != null)
		{
	var folder = document.createElement("li");
	folder.innerHTML = foldername;
	
	var subUl = document.createElement("ul");
	var subList = document.createElement("li");
	
	
	subList.innerHTML = "li";
	subUl.appendChild(subList);
	
	folder.appendChild(subUl); 
	
	treemenu1.appendChild(folder);

	//ddtreemenu.createTree("treemenu1", true, 5)
	var xmlhttp;
	
	if (window.XMLHttpRequest)
	  {// code for IE7+, Firefox, Chrome, Opera, Safari
	  	xmlhttp=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
	  	xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	
	xmlhttp.open("get","${pageContext.request.contextPath}/ProjectController?flag=insertFolder&cname="+foldername,true);
	xmlhttp.send();
	/* jQuery(".chosen-select1").chosen({'width':'100%','white-space':'nowrap'}); */
	/* Holds the status of the XMLHttpRequest. Changes from 0 to 4:
		0: request not initialized
		1: server connection established
		2: request received++++
		3: processing request
		4: request finished and response is ready */

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
				var createListItem = document.createElement("input");
				createListItem.setAttribute("type","submit");
				createListItem.setAttribute("style","margin:10px;height:200px");
				createListItem.setAttribute("class","col-md-3 btn btn-info");
				createListItem.setAttribute("id",jsonObj[i].projectId);
				createListItem.setAttribute("value",jsonObj[i].projectName);
				form1.appendChild(createListItem);
				
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
<style>
.c1 {
	color: red;
}
</style>

</head>
<body onload="loadFolder()">




	<div>


		<div
			style="border: 1px solid; font-style: italic; height: 100px; width: 100%">
			<div id='cssmenu'>
				<ul style="height: 55px">
					<li class='active has-sub' style="float: right"><a href='#'><span><%out.print((String)session.getAttribute("userName")); %></span></a>
						<ul>
							<li class='has-sub'><a href='#'><span>ADD</span></a></li>
								
							<li class='has-sub'><a href='asd?flag=logout'><span>Logout</span></a></li>
						</ul></li>
				</ul>
			</div>
			<input type="button" name="create folder" value="create folder"
				onclick="createFolder()">


		</div>
		<div>
			<div style="border: 1px solid; font-style: italic; height: 796px; width: 20%; float: left">
				
				


				
				<script src="js/jquery.min.js"></script>

				<script src="js/jquery.contextMenu.js" type="text/javascript"></script>



			</div>
			<div style="border: 1px solid; font-style: italic; height: 796px; width: 80%; float: left">
				<div style="margin: 10px;" >
				 	<form action="<%=request.getContextPath()%>/ProjectController?flag=inside" method="post" id="form1" class="raw">
						
						
					</form>
				</div>
			</div>
		</div>
		
	</div>

</body>
</html>