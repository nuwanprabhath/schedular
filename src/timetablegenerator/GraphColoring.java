/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package timetablegenerator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GraphColoring {
    
    private static ArrayList<Node> graph = new ArrayList<Node>();
    private final static int DOMAIN_SIZE=22;
//    
//    public static void main(String[] args) {
//        test2();
//        
//        createTable(1);
//    }
    
    public static ArrayList<ArrayList<TimeSlot>> createTable(ArrayList<Subject> subjects,int semester)
    {   graph = new ArrayList<Node>();
        createGraph(subjects);
        colorGraph();
        System.out.println("ddddddddddddd"+subjects);
        //test();
        Map<Integer,ArrayList<Node>> arrangedByColor=new HashMap<Integer,ArrayList<Node>>();
        
        for(Node node:graph)
        {
            if(node.getSubject().getSemester()==semester){
                if(arrangedByColor.containsKey(node.getColor()))
                {
                    arrangedByColor.get(node.getColor()).add(node);
                }
                else{
                    ArrayList<Node> lst=new ArrayList<Node>();
                    lst.add(node);
                    arrangedByColor.put(node.getColor(), lst);
                }
            }
        }
        
//        for(Entry e:arrangedByColor.entrySet())
//        {
//            System.out.println(e.getValue());
//        }
        
        ArrayList<ArrayList<TimeSlot>> timeTable=new ArrayList<ArrayList<TimeSlot>>();
        Collection<ArrayList<Node>> entries = arrangedByColor.values();
        ArrayList<ArrayList<Node>> entries2 = new ArrayList<>();
        entries2.addAll(entries);
        System.out.println(entries2);
        int count = 0;
        for(int i=0;i<5;i++)
        {
            ArrayList<TimeSlot> dayTable=new ArrayList<>();
            int time=8;
            
            for (; count < entries2.size(); count++) {
                ArrayList<Node> slot = entries2.get(count);
                
                int maxTime = 0;
                
                for(Node n:slot){
                    if(n.getSubject().getDuration()>maxTime){
                        maxTime=n.getSubject().getDuration();
                    }
                }
                System.out.println(maxTime);
                if(time<=12 && (time+maxTime)>12){
                    time=13;
                    count--;
                    continue;
                }
                else if(time<=18 && (time+maxTime)>18){
//                    count--;
                    break;
                }
                else{
                    for(Node n:slot){
                        TimeSlot timeslot = new TimeSlot(time, n.getSubject());
                        dayTable.add(timeslot);
                    }
                    time+=maxTime;
                }
            }
            timeTable.add(dayTable);
        }
        System.out.println(timeTable);
        return timeTable;
    }
    public static void test2()
    {
        Subject s1 = new Subject("1", "1", 1, 3);
        Subject s2 = new Subject("2", "2", 1, 3);
        Subject s3 = new Subject("3", "3", 2, 2);
        Subject s4 = new Subject("4", "4", 1, 3);
        Subject s5 = new Subject("5", "5", 1, 3);
        
        ArrayList<String> st1 = new ArrayList();
        st1.add("a");
        ArrayList<String> st2 = new ArrayList();
        st2.add("a");
        st2.add("b");
        ArrayList<String> st3 = new ArrayList();
        st3.add("b");
        st3.add("c");
        st3.add("d");
        ArrayList<String> st4 = new ArrayList();
        st4.add("c");
        st4.add("e");
        ArrayList<String> st5 = new ArrayList();
        st5.add("d");
        st5.add("e");
        
        s1.setParticipants(st1);
        s2.setParticipants(st2);
        s3.setParticipants(st3);
        s4.setParticipants(st4);
        s5.setParticipants(st5);
        
        ArrayList<Subject> subjects = new ArrayList<Subject>();
        
        subjects.add(s1);
        subjects.add(s2);
        subjects.add(s3);
        subjects.add(s4);
        subjects.add(s5);
        
        
        System.out.println(colorGraph());
        
        for (Node n:graph) {
            System.out.println(n.getColor());
        }
    }
    
    
    public static void test()
    {
        Subject s1 = new Subject("1", "1", 1, 2);
        Subject s2 = new Subject("2", "2", 1, 2);
        Subject s3 = new Subject("3", "3", 1, 2);
        Subject s4 = new Subject("4", "4", 1, 2);
        Subject s5 = new Subject("5", "5", 1, 2);
        
        ArrayList<String> st1 = new ArrayList();
        st1.add("a");
        ArrayList<String> st2 = new ArrayList();
        st2.add("a");
        st2.add("b");
        ArrayList<String> st3 = new ArrayList();
        st3.add("b");
        st3.add("c");
        st3.add("d");
        ArrayList<String> st4 = new ArrayList();
        st4.add("c");
        st4.add("e");
        ArrayList<String> st5 = new ArrayList();
        st5.add("d");
        st5.add("e");
        
        s1.setParticipants(st1);
        s2.setParticipants(st2);
        s3.setParticipants(st3);
        s4.setParticipants(st4);
        s5.setParticipants(st5);
        
        ArrayList<Subject> subjects = new ArrayList<Subject>();
        
        subjects.add(s1);
        subjects.add(s2);
        subjects.add(s3);
        subjects.add(s4);
        subjects.add(s5);
        
        createGraph(subjects);
        System.out.println(colorGraph());
        
        for (Node n:graph) {
            System.out.println(n.getColor());
        }
    }
    public static boolean colorGraph(){
        ArrayList<Node> graphCopy = new ArrayList<>();
        graphCopy.addAll(graph);
        
        while(!graphCopy.isEmpty()){
            ArrayList<Node> leastDomains=new ArrayList();
            int minDomainSize=Integer.MAX_VALUE;
            for(Node node:graphCopy)
            {
                if(node.getDomainSize()<minDomainSize)
                {
                    minDomainSize=node.getDomainSize();
                    leastDomains=new ArrayList();
                    leastDomains.add(node);
                }
                else if(node.getDomainSize()==minDomainSize)
                {
                    leastDomains.add(node);
                }
            }
            System.out.println(leastDomains.size());
            if(minDomainSize==0){
                return false;
            }
            int maxRefs=Integer.MIN_VALUE;
            Node maxReference=null;

            for(Node node:leastDomains)
            {
                if(node.getNodes().size()>maxRefs)
                {
                    maxReference=node;
                    maxRefs=node.getNodes().size();
                }
            }
            //System.out.println(maxReference.getSubject().getModuleName());
            int maxColor=Integer.MIN_VALUE;
            int colour = 0;
            for(Integer color:maxReference.getDomain()){
                int total=0;
                for(Node node:maxReference.getNodes())
                {
                    if(node.getDomain().contains(color))
                    {
                        total+=node.getDomainSize()-1;
                    }
                    else
                    {
                        total+=node.getDomainSize();
                    }

                }
                if(total>maxColor){
                    maxColor=total;
                    colour = color;
                }
            }
            maxReference.setColor(colour);
            maxReference.getDomain().remove(colour);
            for (Node n:maxReference.getNodes()) {
                System.out.println("x");
                n.getDomain().remove(colour);
                
                //n.getNodes().remove(maxReference);
            }
            System.out.println(graph.toString());
            
            graphCopy.remove(maxReference);
        }
        
        return true;
    }
    
    public static void createGraph(ArrayList<Subject> subjects)
    {
        graph=new ArrayList<Node>();
        
        
        
        for(Subject sub:subjects)
        {
            Set<Integer> domain = new HashSet();
        
            for (int i = 1; i <= DOMAIN_SIZE; i++) {
                domain.add(i);
            }
            graph.add(new Node(sub,domain));
        }
        
        for(int i=0;i<graph.size();i++)
        {
            for(int j=i+1;j<graph.size();j++)
            {
                Node node1=graph.get(i);
                Node node2=graph.get(j);
                
                if(!isIndependent(node1.getSubject().getParticipants(), node2.getSubject().getParticipants()))
                {
                    System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    node1.addAdjacentNode(node2);
                    node2.addAdjacentNode(node1);
                }
            }
        }
        
    }
    
    public static boolean isIndependent(ArrayList<String> ids1,ArrayList<String> ids2) //checks the independency of two string lists
    {
        for(String str:ids1)
        {
            if(ids2.contains(str))
            {
                return false;
            }
        }
        return true;
    }
    
}
