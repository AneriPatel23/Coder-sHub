<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/simpletreemenu.js">

/***********************************************
* Simple Tree Menu- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
* Please keep this notice intact
* Visit Dynamic Drive at http://www.dynamicdrive.com/ for full source code
***********************************************/

</script>

<link rel="stylesheet" type="text/css" href="css/simpletree.css" />

<script type="text/javascript">

//ddtreemenu.createTree(treeid, enablepersist, opt_persist_in_days (default is 1))
ddtreemenu.createTree("treemenu2", true, 5)

</script>


</head>


<body>
<h4>Simple Tree Menu #1 (persist enabled):</h4>

<a href="javascript:ddtreemenu.flatten('treemenu1', 'expand')">Expand All</a> | <a href="javascript:ddtreemenu.flatten('treemenu1', 'contact')">Contact All</a>

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
</body>
</html>