<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.request.contextPath}/userLayout/"/>
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

<link rel="stylesheet" href="css/theme.css" type="text/css"/>
   
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
	var treemenu1 = document.getElementById("treemenu1");
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
				var createListItem = document.createElement("li");
				createListItem.setAttribute("class","submenu");
				createListItem.setAttribute("id",jsonObj[i].projectId);
				createListItem.setAttribute("style","background-image: url('icons/closed.gif')");
				createListItem.setAttribute("onclick", "");
				createListItem.innerHTML = jsonObj[i].projectName;
				treemenu1.appendChild(createListItem);
				
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

 function hi(x)
 {
	 console.log(x.childNodes[1].innerHTML);
	 alert(x.childNodes[1].innerHTML);
	 var path=x.childNodes[1].innerHTML;
	 var xmlhttp;
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
			alert(xmlhttp.responseText);
			myeditor.innerHTML=xmlhttp.responseText;
			tinyMCE.activeEditor.setContent('<span>'+xmlhttp.responseText+'</span>');
			/* var jsonObj = JSON.parse(xmlhttp.responseText);
			alert(xmlhttp.responseText); */
						
			
		}
	 }
		alert("---");
		xmlhttp.open("get",path,true);
		xmlhttp.send();

 }

</script>
<style>
.c1
{
color:red;
}
</style>

</head>
<body>


	
	
	<div >
	
	
			 <div style="border:1px solid; font-style: italic;height: 100px; width: 1000px">
		<div id='cssmenu'>
<ul style="height: 55px">
   <li class='active has-sub' style="float:right"><a href='#'><span>Products</span></a>
      <ul>
         <li class='has-sub'><a href='#'><span>ADD</span></a>
            <ul>
               <li><a href="${pageContext.request.contextPath}/ComplainController?flag=searchAdmin"><span>Complain</span></a></li>
               <li class='last'><a href="${pageContext.request.contextPath}/FeedbackController?flag=searchAdmin"><span>Feedback</span></a></li>
            </ul>
         </li>
         <li class='has-sub'><a href='#'><span>Logout</span></a>
            
         </li>
      </ul>
   </li>
</ul>
</div> 
		<input type="button" name="create folder" value="create folder" onclick="createFolder()">
	
                    
		</div>
		<div>
			<div style="border:1px solid; font-style: italic;height: 796px; width: 300px; float:left">
			

<!-- <a href="javascript:ddtreemenu.flatten('treemenu1', 'expand')">Expand All</a> | <a href="javascript:ddtreemenu.flatten('treemenu1', 'contact')">Contact All</a> -->


<%@ taglib  prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<ul id="treemenu1" class="treeview">

<c:forEach items="${sessionScope.tree}" var="i" varStatus="j">${i}</c:forEach>
</ul>

<script type="text/javascript">

//ddtreemenu.createTree(treeid, enablepersist, opt_persist_in_days (default is 1))

ddtreemenu.createTree("treemenu1", true)
ddtreemenu.createTree("treemenu2", false)

</script>
 <script src="js/jquery.min.js"></script>

    <script src="js/jquery.contextMenu.js" type="text/javascript"></script>

<script type="text/javascript" class="showcase">
    $(function() {
        $.contextMenu({
            selector: '#treemenu1 .submenu', 
            callback: function(key, options) {
               // var m = "clicked: " + key;
             //  alert(options.$trigger.context.id);
               var m=prompt("Enter "+key+" Name","");
               
               
               createFile12(options.$trigger.context.id,key,m);

               ddtreemenu.createTree("treemenu1", true)
               ddtreemenu.createTree("treemenu2", false)
              //  window.console && console.log(m) || alert(m); 
            },
            items: {
                
                "new": {name: "New",
                	"items": {"Module" : {"name":"Module" },"File" : {"name":"File"}, "Folder" : {"name":"Folder"},
                		"Class" : {"name":"Class"}, "Package" : {"name":"Package"}, "Dynamic Web Project" : {"name":"Dynamic Web Project"},
                		
                }
                },
           
                
                "cut": {name: "Cut"},
                "copy": {name: "Copy"},
                 "paste": {name: "Paste"},
                 "delete": {name: "Delete"},
                 
                 }
            
            
        });

        $('#treemenu1 .submenu').on('click', function(e){
            console.log('clicked', this);
        })    
    });
</script>

			</div>
			<div  style="border:1px solid; font-style: italic;height: 796px; width: 698px;float: left">
			<textarea rows="50.5" cols="50" style="height: 680px;" id="myeditor">hiii</textarea>
				<input type="button" name="save" id="save" value="SAVE" >
				<input type="button" name="run" id="run" value="RUN">
			</div>
		</div>
		<div style="border:1px solid black;width:1000px;height:100px;clear:left;">
		<br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			
		</div>
	</div>
	
</body>
</html>