import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;


class FDemo
   {
	public static void main(String args[]) throws Exception
	 {
	  BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
	  String s,fl;
	  int i=1,j=1,k=1;
	  System.out.println("Enter file name:");
	  fl=input.readLine();
	  FileReader fr = new FileReader(fl);
	  BufferedReader br = new BufferedReader(fr);
          int flg_j=0,flg_p=0,flg_r=0;


   		try{
		   Pattern pj = Pattern.compile("^i?[(public|private|protected)*[\\s]+]*class[\\s]+[\\w]*+([\\s]|[\\t]|[\\n])*\\z");

		   Pattern pp = Pattern.compile("^i?([<?php]+([\\s]|[\\t]|[\\n])*)|(([var]+[\\s]+[\\w])+)|([function]+[\\s]+[\\w]+)\\z");
	 	   Pattern pr = Pattern.compile("^i?[class]+\\z");
		   Pattern p_class = Pattern.compile("^\\s*class (\\w+)");
		   Pattern p_rubymethod = Pattern.compile("[\\w|\\s|\\t|\\n]*def[\\s]+(\\w+)(\\s+)");
		   Pattern p_fun = Pattern.compile("\\w+ +(\\w+) *\\(.*\\) *\\{");
		   
		   Matcher m,mcls,mfun,meth;
 
		  	while((s = br.readLine()) != null)
				{
 				m = pj.matcher(s);
				 
				mcls = p_class.matcher(s);
 				mfun = p_fun.matcher(s);
 				meth = p_rubymethod.matcher(s);
 
				if(m.matches())
				{

				flg_j++;

				}

				m = pr.matcher(s);

				if(m.matches())
				{

				flg_r++;
				}

				m = pp.matcher(s);
				if(m.matches())
				{
				flg_p++;
				}

				//....CLASS MATCHER......//
 				if (mcls.find())
    				{
      				System.out.println("class"+i+" : "+mcls.group(1));
      				i++;
    				}
   
				//....JAVA METHOD MATCHER......//   
 				if (mfun.find())
    				{
      				System.out.println("Methods"+j+" : "+mfun.group(1));
      				j++;
    				}

				if(meth.find())
				{
				System.out.println("methods from "+k+": "+meth.group(1));
				k++;}

		}

				if(flg_j>0)
				{
				System.out.println("Java language");
				}

				if(flg_p>0)
				{
				System.out.println("php language");
				}

				if(flg_r>0)
				{
				System.out.println("ruby languages");
				}

			}
			catch(Exception e)
			{

		}

		fr.close();
	  }

}

