package com.project;

import java.io.File;

public abstract class WorkflowTableItem implements Comparable{
    //age of item, to be used to have a priority over younger 
    private int itemAge;
    private int priority;
    protected File form;
    private int ID;
    public boolean returned;
// 

    public int getAge(){
        return -1;
    }
    //we have to make this work for a priority queue
    public int compareTo(){
        return -1;
    }
    public File viewForm(){
        return null;
    }
    public int getID(){
        return ID; 
    }

}