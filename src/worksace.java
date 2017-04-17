
	import java.io.File;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;

	
public class worksace {

	
		public static void main(String[] args) throws IOException 
		{
			// TODO Auto-generated method stub
			
			
			File dir = new File("C:\\apache-tomcat-7.0.52\\webapps\\proj");	   
		    dir.mkdir();
		   
		  /*  File dir1 = new File("C:\\Root\\module");
		    dir1.mkdir();
		   	     
		    File dir2 = new File("C:\\Root\\module\\file");  
		    dir2.mkdir(); 
		   
		    File f=new File("C:\\Root\\module\\file\\rid.txt");
			f.createNewFile();
			FileWriter fw=new FileWriter(f);
			fw.write("hi ridd");
			fw.flush();
			fw.close();
			
			 File f1=new File("C:\\Root\\module\\file\\vid.txt");
		    f1.createNewFile();
		    FileWriter fw1=new FileWriter(f1);
			fw1.write("hi vidd");
			fw1.flush();
			fw1.close();

			 File f2=new File("C:\\Root\\module\\file\\khu.txt");
			 f2.createNewFile();
			 FileWriter fw2=new FileWriter(f2);
			 fw2.write("hi khu");
			 fw2.flush();
			 fw2.close();
			 
			 File f3=new File("C:\\Root\\module\\file\\anu.txt");
			 f3.createNewFile();
			 FileWriter fw3=new FileWriter(f3);
			 fw3.write("hi anuu");
		     fw3.flush();
			 fw3.close();
						
		     
		     /*rename a file*/
				 
		}
		
		}




