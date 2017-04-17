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

<link rel="stylesheet" type="text/css" href="css/simpletree.css" />
<link rel="stylesheet" type="text/css" href="css/style3.css" />

<link rel="stylesheet" href="css/theme.css" type="text/css"/>
   
 <link href="css/jquery.contextMenu.css" rel="stylesheet" type="text/css" />


<script type="text/javascript">

//ddtreemenu.createTree(treeid, enablepersist, opt_persist_in_days (default is 1))

ddtreemenu.createTree("treemenu2", true, 5)

var temp = 0;

function createFolder()
{

	
 	var treemenu1 = document.getElementById("treemenu1");
 	
	var foldername = prompt("Enter Folder Name","Folder");
	if(foldername != null)
		{
	var folder = document.createElement("li");
	folder.innerHTML = foldername;
	
	var subUl = document.createElement("ul");
	var subList = document.createElement("li");
	
	subList.innerHTML = "Sub Item";
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
				createListItem.setAttribute("id","idli"+i);
				createListItem.setAttribute("style","background-image: url('icons/closed.gif')");
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
	
	for (var i = 0; i < treemenu1.childNodes.length; i++) {
		if (treemenu1.childNodes[i].nodeName == "LI") {
			if(treemenu1.childNodes[i].id == liid)
				{
				var txt = treemenu1.childNodes[i].innerHTML;
			treemenu1.childNodes[i].innerHTML = txt+"<ul><li>"+name+"</li></ul>";
			
				}
			
			if (window.XMLHttpRequest)
			  {// code for IE7+, Firefox, Chrome, Opera, Safari
			  	xmlhttp=new XMLHttpRequest();
			  }
			else
			  {// code for IE6, IE5
			  	xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
			  }
			
			xmlhttp.open("get","${pageContext.request.contextPath}/ModuleController?flag=insertModule&cname1="+name,true);
			xmlhttp.send();
			
		}
	}

	//ddtreemenu.createTree("treemenu1", true, 5)
	
}


</script>
<style>
.c1
{
color:red;
}
</style>

</head>
<body onload="loadFolder()">


	
	
	<div >
	
	
		<div style="border:1px solid; font-style: italic;height: 100px; width: 1000px">
		<div id='cssmenu'>
<ul style="height: 55px">
   <li class='active has-sub' style="float:right"><a href='#'><span>Products</span></a>
      <ul>
         <li class='has-sub'><a href='#'><span>ADD</span></a>
            <ul>
               <li><a href="addComplain.jsp"><span>Complain</span></a></li>
               <li class='last'><a href='#'><span>Feedback</span></a></li>
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


<ul id="treemenu1" class="treeview">
<li>Item 1</li>
<li>Item 2</li>

<li>Folder 1
	<ul>
	<li>Sub Item 1.1</li>
	<li>Sub Item 1.2</li>
	</ul>
</li>
<li>Item 3</li>

<li>Folder 2
	<ul>
	<li>Sub Item 2.1</li>
	<li>Folder 2.1
		<ul>
		<li>Sub Item 2.1.1</li>
		<li>Sub Item 2.1.2</li>
		</ul>
	</li>
</ul>
</li>

<li>Item 4</li>
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
               var m=prompt("Enter"+key+"Name","");
               
               createFile12(options.$trigger.context.id,key,m);

               ddtreemenu.createTree("treemenu1", true)
               ddtreemenu.createTree("treemenu2", false)
              //  window.console && console.log(m) || alert(m); 
            },
            items: {
                
                "new": {name: "New",
                	"items": {"Module" : {"name":"Module" },"File" : {"name":"File"}, "Folder" : {"name":"Folder"},
                		"Class" : {"name":"Class"}, "Package" : {"name":"Package"}, "Dynamic Web Project" : {"name":"Dynamic Web Project"},
                		"HTML File" : {"name":"HTML File"},"JSP File" : {"name":"JSP File"},"Filter" : {"name":"Filter"},"Servlet" : {"name":"Servlet"},"Interface" : {"name":"Interface"}
                }
                },
           
                
                "cut": {name: "Cut"},
                "copy": {name: "Copy"},
                 "paste": {name: "Paste"},
                 "delete": {name: "Delete"},
                 "rename": {name: "rename"},
                 "move": {name: "move"},
                "import": {name: "import"},
                 "export": {name: "export"},
                 "refresh": {name: "refresh"},
                 "validate": {name: "validate"},
                 "source": {name: "source","items":{"Format":{"name":"Format"}}},
                 "debug as": {name: "debug as","items":{"debug Configurations":{"name":"debug Configurations"}}},
                 "run as": {name: "run as"},
                 "Properties": {name: "Properties"},
                 }
            
            
        });

        $('#treemenu1 .submenu').on('click', function(e){
            console.log('clicked', this);
        })    
    });
</script>

			</div>
			<div  style="border:1px solid; font-style: italic;height: 796px; width: 698px;float: left">
			<textarea rows="50.5" cols="50" id="myeditor"></textarea>
			</div>
		</div>
		<div style="border:1px solid black;width:1000px;height:100px;clear:left;"></div>
	</div>
	 <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>