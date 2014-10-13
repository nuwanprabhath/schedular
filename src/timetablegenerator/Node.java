/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package timetablegenerator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Node {
    
    private Subject subject;
    private ArrayList<Node> nodes=new ArrayList<Node>();
    private int color;
    private Set<Integer> domain=new HashSet<Integer>();
    
    public Node(Subject subject) {
        this.subject = subject;
    }

    Node(Subject s1, Set<Integer> domain) {
        this.subject = s1;
        this.domain = domain;
    }

    public Subject getSubject() {
        return subject;
    }

    public int getColor() {
        return color;
    }
    
    

    public void setSubject(Subject subject) {
        this.subject = subject;
    }


    public void setNodes(ArrayList<Node> node) {
        this.nodes = node;
    }
    
    public void addAdjacentNode(Node node)
    {
        nodes.add(node);
    }
    
    public void reduceDomain(int color)
    {
        this.domain.add(color);
    }
    
    public void setColor(int color)
    {
        this.color=color;
    }
    
    public int getDomainSize()
    {
        return this.domain.size();
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public Set<Integer> getDomain() {
        return domain;
    }

    public String toString(){
        return String.valueOf(subject.getModuleName()+" "+domain.size());
    }
}
