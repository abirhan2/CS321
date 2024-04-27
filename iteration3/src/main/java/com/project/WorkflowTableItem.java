package com.project;

import java.io.File;
/**
 * abstract parent class for ReviewItem and ApprovalItem classes, since they both have many similar traits. 
 * @author Arron Birhanu, Buckley O'Day, Logan Ericksen
 * @version 1.0
 */
public abstract class WorkflowTableItem{
    /**
     * uniqueue ID for the item in the workflowtable, number increases over time. Should allow for the table to stay sorted from oldest to youngest, since the younger an item is, the larger the ID it has. 
     */
    protected int ID;
    /**
     * String with the applicant's email.
     */
    protected String email;
    /**
     * returned boolean so that we know if this is an item that has failed the approval stage, and was returned to be reviewed again. 
     */
    public boolean returned;
    /**
     * getter for the ID
     * @return ID field
     */
    public int getID(){
        return ID;
    }

    /**
     * getter for the ID
     * @return email field
     */
    public String getEmail(){
        return email;
    }

    /**
     * The objects need to be able to be compared so that they are sorted correctly.
     * cnsult ApprovalItem if you want to see what this looks like. This method doesn't actually do anything and can be deleted
     * @return
     */
    public int compareTo(){
        return -1;
    }

}