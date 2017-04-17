$(document).ready(function() {




    if ($("#test").addEventListener) {
        $("#test").addEventListener('contextmenu', function(e) {
			alert("Changed: " + this.id);
            alert("You've tried to open context menu"); //here you draw your own menu
            e.preventDefault();
        }, false);
    } else {

        //document.getElementById("test").attachEvent('oncontextmenu', function() {
        //$(".test").bind('contextmenu', function() {
            $('body').on('contextmenu', 'a.test', function() {

            alert("---11");
            alert("contextmenu"+event);
            document.getElementById("rmenu").className = "show";  
            document.getElementById("rmenu").style.top =  mouseY(event) + 'px';
            document.getElementById("rmenu").style.left = mouseX(event) + 'px';

            window.event.returnValue = false;


        });
    }

});
// this is from another SO post...  
    $(document).bind("click", function(event) {
        document.getElementById("rmenu").className = "hide";
    });

	
//Create new folder
$(document).ready(function() {


    if ($("#test1").addEventListener) {
        $("#test1").addEventListener('contextmenu', function(e) {
            alert("You've tried to open context menu"); //here you draw your own menu
            e.preventDefault();
        }, false);
    } else {

        //document.getElementById("test").attachEvent('oncontextmenu', function() {
        //$(".test").bind('contextmenu', function() {
            $('body').on('contextmenu', 'a.test1', function(e) 
            {
            alert("-23-");
            console.log(e.currentTarget.innerHTML);
            var p = document.createElement("p");
            p.setAttribute("id","123");
            
            
            document.getElementById("test-popup1").appendChild(p);
            var nd = e.currentTarget.childNodes;
            p.innerHTML = nd[1].innerHTML;
            alert(nd[1].innerHTML);
            alert(document.getElementById("path123").value);
            document.getElementById("path123").setAttribute("value",nd[1].innerHTML);
            document.getElementById("file").setAttribute("value",nd[1].innerHTML);
            document.getElementById("file310").setAttribute("value",nd[1].innerHTML);
            
            document.getElementById("rmenu1").className = "show";  
            document.getElementById("rmenu1").style.top =  mouseY(event) + 'px';
            document.getElementById("rmenu1").style.left = mouseX(event) + 'px';
           
           
             window.event.returnValue = false;


        });
    }

});

//src folder

$(document).bind("click", function(event) {
    document.getElementById("rmenu").className = "hide";
});

$(document).ready(function() {


    if ($("#test1").addEventListener) {
        $("#test1").addEventListener('contextmenu', function(e) {
            alert("You've tried to open context menu"); //here you draw your own menu
            e.preventDefault();
        }, false);
    } else {

        
            $('body').on('contextmenu', 'a.test1', function(e) 
            {
            
            console.log(e.currentTarget.innerHTML);
            document.getElementById("rmenu1").className = "show";  
            document.getElementById("rmenu1").style.top =  mouseY(event) + 'px';
            document.getElementById("rmenu1").style.left = mouseX(event) + 'px';
            var p = document.createElement("p");
            p.setAttribute("id","789");
            
            document.getElementById("test-popup").appendChild(p);
            var nd = e.currentTarget.childNodes;
            p.innerHTML = nd[1].innerHTML;
            
            document.getElementById("file").setAttribute("value",nd[1].innerHTML);
            document.getElementById("file310").setAttribute("value",nd[1].innerHTML);
             window.event.returnValue = false;


        });
    }

});

$(document).ready(function() {


    if ($("#test1").addEventListener) {
        $("#test1").addEventListener('contextmenu', function(e) {
            alert("You've tried to open context menu"); //here you draw your own menu
            e.preventDefault();
        }, false);
    } else {

        //document.getElementById("test").attachEvent('oncontextmenu', function() {
        //$(".test").bind('contextmenu', function() {
            $('body').on('contextmenu', 'a.test1', function(e) 
            {
           
            console.log(e.currentTarget.innerHTML);
            document.getElementById("rmenu1").className = "show";  
            document.getElementById("rmenu1").style.top =  mouseY(event) + 'px';
            document.getElementById("rmenu1").style.left = mouseX(event) + 'px';
            var p = document.createElement("p");
            p.setAttribute("id","456");
            
            document.getElementById("test-popup2").appendChild(p);
            var nd = e.currentTarget.childNodes;
            p.innerHTML = nd[1].innerHTML;
            
            document.getElementById("path1").setAttribute("value",nd[1].innerHTML);
            document.getElementById("file").setAttribute("value",nd[1].innerHTML);
            document.getElementById("file310").setAttribute("value",nd[1].innerHTML);
            window.event.returnValue = false;


        });
    }

});
// this is from another SO post...  
    $(document).bind("click", function(event) {
        document.getElementById("rmenu1").className = "hide";
    });



function mouseX(evt) {
    if (evt.pageX) {
        return evt.pageX;
    } else if (evt.clientX) {
       return evt.clientX + (document.documentElement.scrollLeft ?
           document.documentElement.scrollLeft :
           document.body.scrollLeft);
    } else {
        return null;
    }
}

function mouseY(evt) {
    if (evt.pageY) {
        return evt.pageY;
    } else if (evt.clientY) {
       return evt.clientY + (document.documentElement.scrollTop ?
       document.documentElement.scrollTop :
       document.body.scrollTop);
    } else {
        return null;
    }
}