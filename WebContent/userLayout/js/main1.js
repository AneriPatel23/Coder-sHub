
(function() {
	var id2=null;		  
	
	$(function() {
	    $('#browser ').first().on("contextmenu","li", function (e) {
	    	id2=this.id;
	        
	       e.preventDefault();
	       
	       $("#hdnval").val(id2);
	  
	      //$(this.attr("id"));
	        
	        
	      /* var x = document.createElement("input");
	        x.setAttribute("type", "hidden");
	        x.setAttribute("id",id2);
	                 
	        var a=document.getElementById(id2);
	        a.appendChild(x);
	      */ 
	       alert("fffffffffffffff"+id2);
	    
	    });
	});	

	
	  
		    
	  
	
  "use strict";

  //////////////////////////////////////////////////////////////////////////////
  //////////////////////////////////////////////////////////////////////////////
  //
  // H E L P E R    F U N C T I O N S
  //
  //////////////////////////////////////////////////////////////////////////////
  //////////////////////////////////////////////////////////////////////////////

  /**
   * Function to check if we clicked inside an element with a particular class
   * name.
   * 
   * @param {Object} e The event
   * @param {String} className The class name to check against
   * @return {Boolean}
   */
  function clickInsideElement( e, className ) {
    var el = e.srcElement || e.target;
    
    if ( el.classList.contains(className) ) {
      return el;
    } else {
      while ( el = el.parentNode ) {
        if ( el.classList && el.classList.contains(className) ) {
          return el;
        }
      }
    }

    return false;
  }

  /**
   * Get's exact position of event.
   * 
   * @param {Object} e The event passed in
   * @return {Object} Returns the x and y position
   */
  function getPosition(e) {
    var posx = 0;
    var posy = 0;

    if (!e) var e = window.event;
    
    if (e.pageX || e.pageY) {
      posx = e.pageX;
      posy = e.pageY;
    } else if (e.clientX || e.clientY) {
      posx = e.clientX + document.body.scrollLeft + document.documentElement.scrollLeft;
      posy = e.clientY + document.body.scrollTop + document.documentElement.scrollTop;
    }

    return {
      x: posx,
      y: posy
    }
  }

  //////////////////////////////////////////////////////////////////////////////
  //////////////////////////////////////////////////////////////////////////////
  //
  // C O R E    F U N C T I O N S
  //
  //////////////////////////////////////////////////////////////////////////////
  //////////////////////////////////////////////////////////////////////////////
  
  /**
   * Variables.
   */
  var contextMenuClassName = "context-menu";
  var contextMenuItemClassName = "context-menu__item";
  var contextMenuLinkClassName = "context-menu__link";
  var contextMenuActive = "context-menu--active";

  var taskItemClassName = "task";
  var taskItemInContext;

  var clickCoords;
  var clickCoordsX;
  var clickCoordsY;

  var menu = document.querySelector("#context-menu");
  var menuItems = menu.querySelectorAll(".context-menu__item");
  var menuState = 0;
  var menuWidth;
  var menuHeight;
  var menuPosition;
  var menuPositionX;
  var menuPositionY;

  var windowWidth;
  var windowHeight;

  /**
   * Initialise our application's code.
   */
  function init() {
    contextListener();
    clickListener();
    keyupListener();
    resizeListener();
  }

  /**
   * Listens for contextmenu events.
   */
  
  
  function contextListener() {
	  
    document.addEventListener( "contextmenu", function(e) {
      taskItemInContext = clickInsideElement( e, taskItemClassName );
      
      if ( taskItemInContext ) {
        e.preventDefault();
        toggleMenuOn();
        positionMenu(e);
        
     
      } else {
        taskItemInContext = null;
        toggleMenuOff();
      }
    });
    
  }

  /**
   * Listens for click events.
   */
  function clickListener() {
    document.addEventListener( "click", function(e) {
      var clickeElIsLink = clickInsideElement( e, contextMenuLinkClassName );
     
      if (clickeElIsLink ) {
    	     	  
    	  e.preventDefault();
        menuItemListener(clickeElIsLink );
        
      } else {
        var button = e.which || e.button;
        if ( button === 1 ) {
          toggleMenuOff();
        }
      }
    });
  }

  /**
   * Listens for keyup events.
   */
  function keyupListener() {
    window.onkeyup = function(e) {
      if ( e.keyCode === 27 ) {
        toggleMenuOff();
      }
    }
  }

  /**
   * Window resize event listener
   */
  function resizeListener() {
    window.onresize = function(e) {
      toggleMenuOff();
    };
  }

  /**
   * Turns the custom context menu on.
   */
  function toggleMenuOn() {
    if ( menuState !== 1 ) {
      menuState = 1;
      menu.classList.add( contextMenuActive );
    }
  }

  /**
   * Turns the custom context menu off.
   */
  function toggleMenuOff() {
    if ( menuState !== 0 ) {
      menuState = 0;
      menu.classList.remove( contextMenuActive );
    }
  }
  /**
   * Positions the menu properly.
   * 
   * @param {Object} e The event
   */
  function positionMenu(e) {
	  
	  clickCoords = getPosition(e);
    clickCoordsX = clickCoords.x;
    clickCoordsY = clickCoords.y;

    menuWidth = menu.offsetWidth + 4;
    menuHeight = menu.offsetHeight + 4;

    windowWidth = window.innerWidth;
    windowHeight = window.innerHeight;

    if ( (windowWidth - clickCoordsX) < menuWidth ) {
      menu.style.left = windowWidth - menuWidth + "px";
    } else {
      menu.style.left = clickCoordsX + "px";
    }

    if ( (windowHeight - clickCoordsY) < menuHeight ) {
      menu.style.top = windowHeight - menuHeight + "px";
    } else {
      menu.style.top = clickCoordsY + "px";
    }
  }

  /**
   * Dummy action function that logs an action when a menu item link is clicked
   * 
   * @param {HTMLElement} link The link that was clicked
   */var i=0;
   
  
   function menuItemListener( link) {	   
	   
	   var a=link.getAttribute("data-action");
	  var j;
	  
	  console.log( "Task ID - " + a + ", Task action - " + link.getAttribute("data-action"));
	  if(a=='ADDPACKAGE'){
		  toggleMenuOff();
		  var folname=prompt("Please enter your Folder-Name","");
				  
				  if(folname != null)
					{
				  i++;		
				  
				  //var l=document.getElementById($(this).attr("id"));
				//
				  /*var branches = $("<li class='task' id="+i+
						"><span class='folder'>"+
						folname+
						"</span><ul>").appendTo(l);
				
				
				$("#browser").treeview({
					add:branches,
				*/	
				  
				  				  var element1 = document.createElement("span");
				  var att1= document.createAttribute("class",'folder');      
				  element1.setAttributeNode(att1)
				  		  
				  var node = document.createTextNode(folname);
				  
				  element1.appendChild(node);
				  var element = document.createElement("li");
				  var att2= document.createAttribute("class",'task');
				  var att = document.createAttribute("id",i);       // Create a "class" attribute
				  var element3 = document.createElement("ul");
				  element.setAttributeNode(att);
				  
				  element.setAttributeNode(att2);

				  element3.appendChild(element);
				  element.appendChild(element1);
				  
				  var x=$("#hdnval").val();
				  alert(x);
				  
				  //var l=document.getElementById(id);
				  
				  //alert(id2);
				  var b=document.getElementById(id2);
				 
				  b.appendChild(element);
					
					}

		   		/*$("#folder1").treeview({
				add:branches
			*/
			//});
	}
	  
	
	  if(a=='ADDFILE'){
		  var filename=prompt("Please enter your Folder-Name","");
		    
			if(filename != null)
				{
					
			var branches = $("<li><span class='file'>"+
					filename+
					"</span><ul>").appendTo("#browser");
			$("#browser").treeview({
				add:branches
			});
				}
		  toggleMenuOff();
		}
	  
	  if(a=='DELETE'){
		  toggleMenuOff(); 
		  var a=document.getElementById("filejsp");
		  
			  $("span").remove(".file");
		  				}
		 
	  }
	  
  

  /**
   * Run the app.
   */
  init();

  
})();