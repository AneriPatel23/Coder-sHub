i<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
$(function(){
    $.contextMenu('html5');
});
</script>
</head>
<body>
<span class="context-menu-one btn btn-neutral" contextmenu="html5polyfill">right click me</span>

<menu id="html5polyfill" type="context">  
    <command label="rotate" onclick="alert('rotate')" icon="images/cut.png">
    <command label="resize" onclick="alert('resize')" icon="images/door.png">
    <menu label="share">
        <command label="twitter" onclick="alert('twitter')" icon="images/page_white_copy.png">
        <hr>
        <command label="facebook" onclick="alert('facebook')" icon="images/page_white_edit.png">
        <hr>
        <label>foo bar<input type="text" name="foo"></label>
    </menu>
</menu>
</body>

</html>