$(document).ready(function(){
		
	// first example
	$("#navigation").treeview({
		collapsed: true,
		unique: true,
		persist: "location"
	});

	
	// second example
	$("#browser").treeview({
		animated:"normal",
		persist: "cookie"
	});

	$("#samplebutton").click(function(){ 
		var projectName = document.getElementById("ProjectName");
		var branches = $("<li class='collapsable' id='"+projectName.value+"Id'><div class='hitarea collapsable-hitarea'></div><span class='folder'><a class='test1'>"+projectName.value+"</a></span><ul><li class='collapsable' id='"+projectName.value+"srcId'><div class='hitarea collapsable-hitarea'></div><span class='folder'><a class='test1'>src</a></span></li><li class='collapsable' id='"+projectName.value+"webcontentId'><div class='hitarea collapsable-hitarea'></div><span class='folder'><a class='test1'>webcontent</a></span></li></ul></li>").appendTo("#browser");
		
		$("#browser").treeview({
			add: branches
		});
		
		document.addproject.projectName.value="";
	});


	$("#samplebuttonfolder").click(function(){ 
		var CreateNewFolder = document.getElementById("CreateNewFolder");
		var branches = $("<li id='"+CreateNewFolder.value+"' class='collapsable'><div class='hitarea collapsable-hitarea'></div><span class='folder'><a class='test1'>"+CreateNewFolder.value+"</a></span></li>").appendTo("#folder2");
		
		$("#folder2").treeview({
			add: branches
		});
		
		document.tree.addproject.CreateNewFolder.value="";
	});


	$("#samplebuttonfile").click(function(){ 
		var CreateNewFile = document.getElementById("CreateNewFile");
		var branches = $("<li class='last'><span class='file'>"+CreateNewFile.value+"</span></li>").appendTo("#folder2");
		
		$("#folder2").treeview({
			add: branches
		});
		
		document.tree.addproject.folder2.value="";
	});


	// third examplezzzzzzzz
	$("#red").treeview({
		animated: "fast",
		collapsed: true,
		control: "#treecontrol"
	});


});