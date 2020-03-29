
import java.util.Queue;
import java.util.LinkedList;
import java.util.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nimra Ejaz
 */
public class Node {
    int action;
    int state;
    int cost;
    Node parent;
    int no;
    public Node()
    {
        
    }
    public Node(int action, int state, int cost, Node parent) {
        this.action = action;
        this.state = state;
        this.cost = cost;
        this.parent = parent;
    }
    public String f1(int l,int m,int n,String[] actions,String[] s,String input,int[][] result)
    {
        Queue<Node> q =new LinkedList<>();
        Set<Integer> set = new HashSet<Integer>(); 
        String[] s1=input.split("   ");
        String[] first=s1[0].split(",");
        String[] last=s1[1].split(",");
        String[][] state=new String[l][m];
        for(int i=0;i<l;i++)
        {
            state[i]=s[i].split(",");
        }
        boolean[] flag=new boolean[l];
        for(int i=0;i<l;i++)
            flag[i]=false;
        int lastIndex=-1;
        int count=0;
        for(int i=0;i<m;i++)
        {
            if(first[i].equals(last[i]))
            {
                if(count==m-1)
                {
                    String j="source is destination";
                    return j;
                }
                count++;
            }
        }
        count=0;
        for(int i=0;i<l;i++)
        {              
            for(int j=0;j<m;j++)
                { 
                   // System.out.print(state[i][j]);
                    if(first[j].equals(state[i][j]))
                    {
                        
                        if(count==m-1)
                        {   //System.out.println(i);
                             Node n1=new Node(-1,i,1,null);
                             q.add(n1);
                        }
                        count++;
                    }
                    //else
                    //count=0;
                }
            //System.out.println("");
          count=0;
          for(int j=0;j<m;j++)
          { 
                String ll=last[j];
                if(last[j].equals(state[i][j]))
                {
                    if(count==m-1)
                    { 
                        lastIndex=i;
                    }
                    count++;
                }
                
          }
          count=0;
        }
        if(q.isEmpty())
            {
                //System.out.println("empty");
                return null;
            }
            if(lastIndex==-1)
            {
                return null;
            }
        flag[q.peek().state]=true;
        //System.out.println(q.peek().state);
        while(!q.isEmpty())
        {
            Node n2=q.remove();
            int nm=n2.state;                    
            set.add(n2.state);
            for(int i=0;i<m;i++)
            {
                int no=result[n2.state][i];
                Node check=new Node(i, no, n2.cost+1, n2);
                int f=check.state;
                if(result[n2.state][i]==lastIndex)
                {
                    //System.out.println(check.action);
                    String r=String.valueOf(check.action);
                    String res=r+"*"+" ";
                    Node n3=check;
                    while(n3.parent!=null)
                    {
                        int nn=check.state;
                        int nkl=check.action;
                       check=n3.parent;
                      // System.out.println(n3.action);
                       if(check.action!=-1)
                       { r=String.valueOf(check.action);}
                       else
                       { r="";}
                        res=res+r+"*"+" ";
                       n3=check;
                    }
                    StringBuilder input1 = new StringBuilder(); 
                    input1.append(res); 
                    input1 = input1.reverse();
                    String str=input1.toString();
                    //System.out.println(str);
                    str=str.replace(' ','-');
                    str=str.replace('*','>');
                    str=str.substring(4,str.length());
                    for(int k=0;k<n;k++)
                    {
                        str=str.replace(String.valueOf(k), actions[k]);
                    }
                    return str;
                }
                else if(flag[no]!=true&&!set.contains(no))
                {
                    
                    q.add(check);
                    flag[no]=true;
               
                }
            }
        }
        return null;  
    } 
}
