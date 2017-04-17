<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<base href="${pageContext.request.contextPath}/userLayout/">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/tinymce/tinymce.min.js"></script>

<link rel="stylesheet" href="jquery.treeview.css" />
<link rel="stylesheet" href="screen.css" />

<script src="js/jquery-1.11.0.min.js"></script>
<script src="js/contextmenu.js"></script>
<script src="js/jquery.magnific-popup.min.js"></script>
<script src="js/console_runner-19b53204114bb6697f7c32c3c848fd19.js"></script>
<link rel="stylesheet" href="css/contextmenu.css" />
<link rel="stylesheet" href="css/magnific-popup.css" />
<link rel='stylesheet prefetch' href="css/magnific-popup.css">
<link rel="stylesheet" href="css/stylet.css">
<link rel="stylesheet" href="css/style.css">
<!--<script type="text/javascript" src="js/jquery.min1.js"></script>-->
<script src="js/jquery.cookie1.js" type="text/javascript"></script>
<script src="js/jquery.treeview1.js" type="text/javascript"></script>
<script type="text/javascript" src="js/demo.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap1.min.css">-->
<style>
#header {
	background-color: gray;
	height: 100px;
	width: 1540px;
	color: black;
	text-align: center;
}

.menu {
	background-color: white;
	height: 500px;
	width: 260px;
	color: gra;
	float: left;
}

.tree {
	background-color: white;
	width: 200px;
	color: black;
	text-align: center;
	float: left;
}

#editor {
	float: left;
	height: 500px;
	width: 1030px;
	color: white;
	text-align: center;
	background-color: white;
}

 #footer {
	float: left;
	background-color: gray;
	height: 100px;
	width: 1540px;
	color: black;
	text-align: center;
} 
</style>
<script type="text/javascript">
	$(document).ready(function() {
		$('.tree li').each(function() {
			if ($(this).children('ul').length > 0) {
				$(this).addClass('parent');
			}
		});

		$('.tree li.parent > a').click(function() {
			$(this).parent().toggleClass('active');
			$(this).parent().children('ul').slideToggle('fast');
		});

		$('#all').click(function() {

			$('.tree li').each(function() {
				$(this).toggleClass('active');
				$(this).children('ul').slideToggle('fast');
			});
		});

		$('.tree li').each(function() {
			$(this).toggleClass('active');
			$(this).children('ul').slideToggle('fast');
		});

	});
	
	function reload1()
	{
		var iframe1=document.getElementById("iframe1");
		iframe1.contentWindow.location.reload(true);
	}
	
	function saveTextAsFile() {
		j = i;

		var filename = prompt("Please enter your File-Name & Extension",
				"abc.txt");
		;
		var textToWrite = tinyMCE.activeEditor.getContent().replace(/<[^>]*>/g,
				"");
		//document.getElementById("inputTextToSave"+j).value;
		/* var res = textToWrite.replace("<pre>", "");
		var main=res.replace("</pre>","");
		 */var textFileAsBlob = new Blob([ textToWrite ], {
			type : 'text/plain'
		});
		var fileNameToSaveAs = filename;
		var downloadLink = document.createElement("a");
		downloadLink.download = fileNameToSaveAs;
		downloadLink.innerHTML = "Download File";
		if (window.webkitURL != null) {
			// Chrome allows the link to be clicked
			// without actually adding it to the DOM.
			downloadLink.href = window.webkitURL
					.createObjectURL(textFileAsBlob);
		} else {
			// Firefox requires the link to be added to the DOM
			// before it can be clicked.
			downloadLink.href = window.URL.createObjectURL(textFileAsBlob);
			downloadLink.onclick = destroyClickedElement;
			downloadLink.style.display = "none";
			document.body.appendChild(downloadLink);
		}

		downloadLink.click();
	}

	function destroyClickedElement(event) {
		document.body.removeChild(event.target);
	}

	function loadFileAsText() {
		var fileToLoad = document.getElementById("fileToLoad" + i).files[0];

		var fileReader = new FileReader();
		fileReader.onload = function(fileLoadedEvent) {
			var textFromFileLoaded = fileLoadedEvent.target.result;

			tinyMCE.activeEditor.setContent("<pre>" + textFromFileLoaded+ "</pre>");
			//tinymce.get('title').getBody().innerHTML = textFromFileLoaded;
		};
		fileReader.readAsText(fileToLoad, "UTF-8");
	}

	
	function fn(x1) {
		var a = x1.childNodes[1].innerHTML;

/* 		alert(x1.childNodes[1].innerHTML);
 */		
		var path1 = document.getElementById("path1");
		path1.value = x1.childNodes[1].innerHTML;
		var file1 = document.getElementById("file");
		file1.value= x1.childNodes[1].innerHTML;
		var file310 = document.getElementById("file310");
		file310.value= x1.childNodes[1].innerHTML;
		
		
	
        document.getElementById("rmenu").className = "show";  
        document.getElementById("rmenu").style.display =  "";
        document.getElementById("rmenu").style.top =  mouseY(event) + 'px';
        document.getElementById("rmenu").style.left = mouseX(event) + 'px';
		
        window.event.returnValue = false;

	}
</script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery1.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script>
	tinymce.init({
		selector:'#myeditor',
		menubar: "false"    
		
	});
	
</script>
<script>
	$('.open-popup-link').magnificPopup({
		type : 'inline',
		midClick : true
	});
</script>
<style>
.white-popup {
	position: relative;
	background: #fff;
	padding: 20px;
	width: auto;
	max-width: 500px;
	margin: 20px auto;
}
</style>
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
	/* alert(projId.innerHTML);
 */	
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
	 //alert("path"+x.childNodes[1].innerHTML);
	 var path=x.childNodes[1].innerHTML;
	 
	 var path21=document.getElementById("path21");
	 path21.value=x.childNodes[1].innerHTML;
	 
	 var download1=document.getElementById("download1");
	 download1.setAttribute("href",x.childNodes[1].innerHTML);
	 var s=path.split('\\');
	 //s=s.splice(1,1);
	 //alert("kkkkkkkkkkkkkkkk"+s)
	 
	 s.splice(1,1);
	 s=s.join("/");
	 //s=s.join("/");
	 //alert("---------:"+s.length);
	 
	 var s1=s.lastIndexOf("\\");
	 var s2=s.split("/");
	 var s3=s2[s2.length-1].split(".");
	 //alert("- - - -"+s3[0]+":::"+s3[1]);
	 if(s3[1]=='java')
	 {
		 <%  System.out.println(".....hii.....");%>
	 	//alert("Friday");
	 	s=s3[0];
	 }
	 else
	 {
		 s=s;
	 }
	 var iframe1=document.getElementById("iframe1");
	 var filename=document.getElementById("filename");
	 filename.value=s3[0]+"."+s3[1];
	 
	 iframe1.src="${pageContext.request.contextPath}/"+s;
	 
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
			//alert(xmlhttp.responseText);
			var editor=document.getElementById("editortextarea");
			editor.innerHTML=xmlhttp.responseText;
			//myeditor.innerHTML=xmlhttp.responseText;
			//tinyMCE.activeEditor.setContent(xmlhttp.responseText);
			/* var jsonObj = JSON.parse(xmlhttp.responseText);
			alert(xmlhttp.responseText); */
						
			
		}
	 }
	 var realpath=document.getElementById("pathreal").value;
	/*  alert(path); */
	 console.log(path);
	/*  alert(realpath); */
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
	
	<input type="text" id="pathreal" value="<%out.print((String)session.getAttribute("pathreal"));%>">
			 <div style="font-style: italic;height: 100px; width: 100%">
	 	<div id='cssmenu'>
<ul style="height: 55px">
   <li class='active has-sub' style="float:right"><a href='#'> <span class="username"><%out.print((String)session.getAttribute("userName")); %></span></a>
      <ul>
         <%-- <li class='has-sub'><a href='#'><span>ADD</span></a>
            <ul>
               <li><a href="${pageContext.request.contextPath}/ComplainController?flag=searchAdmin"><span>Complain</span></a></li>
               <li class='last'><a href="${pageContext.request.contextPath}/FeedbackController?flag=searchAdmin"><span>Feedback</span></a></li>
            </ul>
         </li>
 --%>        <li><a href="<%=request.getContextPath()%>/asd?flag=logout"><i class="fa fa-key"></i> Log Out</a></li>
      </ul>
   </li>
</ul>
</div> 
		<!-- <input type="button" name="create folder" value="create folder" onclick="createFolder()"> -->
	 
                    
		</div>
		<div>
			<div style=" font-style: italic;height: 100%; width: 300px; float:left">
			

<!-- <a href="javascript:ddtreemenu.flatten('treemenu1', 'expand')">Expand All</a> | <a href="javascript:ddtreemenu.flatten('treemenu1', 'contact')">Contact All</a> -->


<%@ taglib  prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
				<div>
					<a href="<%=request.getContextPath()%>/userLayout/download.jsp">Download</a>
				</div>
				<div id="test1" name="tree">
					<ul id="treemenu1" class="treeview">

						<c:forEach items="${sessionScope.tree}" var="i" varStatus="j">${i}</c:forEach>
					</ul>
				</div>
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
			<form action="<%=request.getContextPath()%>/ProjectController?flag=write">
			<div  style="border:1px solid; font-style: italic;height: 796px; width: 70%;float: left">
			<input type="text" class="btn btn-info" id="filename" value="none"/>
			<textarea id="editortextarea" rows="50.5" name="code" cols="50" style="height: 680px;width: 100%" ></textarea>
			<input type="text" name="path" id="path21">
			<input type="hidden" name="flag" value="write">
				<input type="submit" class="btn btn-info" name="save" id="save" value="SAVE" >
				<a class="btn btn-info"  name="download" id="download1" download>Download</a>
				<!-- <input type="button" class="btn btn-info" name="download" id="download" value="DOWNLOAD" onclick="javascript:saveTextAsFile()"> -->
			</div>
			</form>
			
			<iframe src="" id="iframe1" style="width: 92%; background-color: white; border-width: 25px;">
			<input type="button" value="Output" name="Output"> 
			</iframe>
		</div>
		<div style="width:1000px;height:100px;">
		
		
		<!-- initially hidden right-click menu -->
			<div class="hide" id="rmenu1" style="position: fixed;display:none">
				<ul style="margin: 5px">
					<li><a href="#test-popup" class="open-popup-link">Create
							New Project</a></li>
				</ul>
			</div>

			<!-- initially hidden right-click menu -->
			<div class="hide" id="rmenu" style="position: fixed;display:none">
				<ul style="margin: 5px">
					<li><a href="#test-popup1" class="open-popup-link-folder">Create
							New Folder1</a></li>
					<li><a href="#test-popup2" class="open-popup-link-file">Create
							New File1</a></li>
					<li><a href="#test-popup3" class="open-popup-link-file">Delete</a></li>
				</ul>
			</div>
			
			<div class="hide" id="rmenu1" style="position: fixed;display:none">
				<ul style="margin: 5px">
					<li><a href="#test-popup3" class="open-popup-link-folder">Delete</a></li>
				
			</div>

			<!-- initially hidden Project NAme -->
			<form id="test-popup" name="folderName" method="post"
				class="white-popup mfp-hide" 
				action="<%=request.getContextPath()%>/ProjectController?flag=foldername">
				<h2>Project Name</h2>
				<input type="text" id="ProjectName" name="folderName1"
					placeholder="Project --- Name" class="form-control"><br>
				<input type="text" id="srcfolder" name="path1"> <input
					type="submit" value="submit" class="btn btn-info">
			</form>

			<!-- initially hidden Project NAme -->
			<form id="test-popup1" name="addproject" class="white-popup mfp-hide"
				method="post"
				action="<%=request.getContextPath()%>/ProjectController?flag=foldername">
				<h2>Create New Folder</h2>
				<input type="text" id="folderName" name="folderName1"
					placeholder="Create New Folder" class="form-control"><br>
				<input type="text" id="path1" name="path1"> <input
					type="submit" value="submit" onClick="fn() " />
			</form>

			<!-- initially hidden Project NAme -->
			<form id="test-popup2" name="addproject" class="white-popup mfp-hide"
				method="post"
				action="<%=request.getContextPath()%>/ProjectController?flag=filename">
				<h2>Create New File</h2>
				<input type="hidden" value="<%session.getAttribute("path1");%>"
					name="filepath" id="filepath" /> <input type="text" id="FileName"
					name="fileName" placeholder="Create New File" class="form-control">
				<input type="text" id="file" name="path1"> <input
					type="submit" value="submit" onClick="fn1()" />

			</form>
	<form id="test-popup3" name="addproject" class="white-popup mfp-hide"
				method="post"
				action="<%=request.getContextPath()%>/ProjectController?flag=deletefile">
				<h2>Delete</h2>
				<input type="hidden" value="<%session.getAttribute("path1");%>"
					name="filepath" id="filepath" /> 
				<input type="text" id="FileName"
					name="fileName" placeholder="Delete" class="form-control">
				<input type="text" id="file310" name="path1"> 
				<input type="submit" value="submit" onClick="fn1()" />

			</form>
			
			
			
		</div>
		 <footer class="site-footer">
	<div class="text-center">
		2016  @ Online Workspace. </i>
		</a>
	</div>
</footer>
	</div>
	
<script src="js/jquery.min.js"></script>
<script src="js/jquery.magnific-popup.min.js"></script>

<script src="js/index.js"></script>
</body>
</html>