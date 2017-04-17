package controller;

import java.io.*;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class RecursiveTraversal {

	List ls = new ArrayList();
	StringBuffer ul = new StringBuffer();
	String path;
	
	public List traverse(File file) {
		String s = null;
		String path = file.toString();
		System.out.println(path);
		int path1 = path.lastIndexOf('\\');
		String path2 = path.substring(path1);
		String l[]=path.split("wtpwebapps");
		ls.add(path2);

		if (file.isDirectory()) {
			ul = ul.append("<ul><a>");
			String entries[] = file.list();
			// System.out.println(entries.length);
			if (entries != null) {

				for (String entry : entries) 
				{
					if(entry.contains("."))
					{
						ul.append("<li><a value='"+l[1]+"\\"+entry+"' name='filepath' id='filepath'  oncontextmenu='fn(this)' onclick='hi(this)'>" + entry );
						ul.append("<p style='display:none'>"+l[1]+"\\"+entry+"</p>");	
						traverse(new File(file, entry));
						ul.append("</a></li>");
					}
					else
					{
						ul.append("<li><a value='"+path+"\\"+entry+" name='path' oncontextmenu='fn(this)'>" + entry );
						ul.append("<p style='display:none'>"+path+"\\"+entry+"</p>");	
						traverse(new File(file, entry));
						ul.append("</a></li>");
					}
					
				}
			}
			ul.append("</a></ul>");
		//	HttpServletRequest request;
			
			
		}
		return ls;
	}
	
	public String traverse1(File file) {
		String s = null;
		path = file.toString();
		int path1 = path.lastIndexOf('\\');
		String path2 = path.substring(path1);
		
		ls.add(path2);
		ul.append("<div class='tree'>");
		if (file.isDirectory()) {
			ul = ul.append("<ul>");
			String entries[] = file.list();
			// System.out.println(entries.length);
			if (entries != null) {

				for (String entry : entries) {

					ul.append("<li><a value='"+path+"\\"+entry+" name='path' oncontextmenu='fn(this)'>" + entry);
					ul.append("<p style='display:none'>"+path+"\\"+entry+"</p>");
					traverse(new File(file, entry));
					ul.append("</a></li>");

				}
			}
			
			ul.append("</ul></div></div>");

		}
		s=ul.toString();
		return s;
	}

}
