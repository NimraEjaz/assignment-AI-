/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nimra Ejaz
 */
import java.util.*;
import java.util.Queue; 
public class Driver {
    public static void main(String[] args) {
   int l, m, n;
   Scanner in = new Scanner(System.in);
   l=in.nextInt();
   m=in.nextInt();
   n=in.nextInt();
   String[] states=new String[l];
   System.out.println("enter states");
   for(int i=0;i<l;i++)
   {
       states[i] = in.next();
   }
   for(int i=0;i<l;i++)
   {
       System.out. println(states[i]);
   }
   System.out.println("enter actions");
   String[] actions=new String[m];
   for(int i=0;i<m;i++)
   {
       actions[i] = in.next();
   }
   for(int i=0;i<m;i++)
   {
       System.out. println(actions[i]);
   }
   System.out.println("enter results");
   int[][] results=new int[l][m];
   for(int i=0;i<l;i++)
   {
       for(int j=0;j<m;j++)
       {
           results[i][j]=in.nextInt();
       }
   }
   for(int i=0;i<l;i++)
   {
       for(int j=0;j<m;j++)
       {
           System.out. println(results[i][j]);
       }
   }
   System.out.println("enter inputs");
   
   for(int i=0;i<n;i++)
   {
       String inputs = in.next();
       String input=in.next();
       Node n2=new Node();
       String str=inputs+"   "+input;
       System.out.println(str);
      // String str="1,d,c    1,c,c";
      String res=n2.f1(l, m, n, actions,states,str,results);
       if(res==null)
        {
        System.out.println("no path exits");
        
        }
       else
           System.out.println(res);
    
   
   }
  }
}

   