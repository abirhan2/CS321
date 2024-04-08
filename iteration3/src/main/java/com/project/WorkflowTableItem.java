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
     * File attatched to an item that is associated with the immigrant applying for theiir form
     */
    protected File form;
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
     * The objects need to be able to be compared so that they are sorted correctly.
     * cnsult ApprovalItem if you want to see what this looks like. This method doesn't actually do anything and can be deleted
     * @return
     */
    public int compareTo(){
        return -1;
    }
    /**
     * getter for the form field above. 
     * @return form File field
     */
    public File viewForm(){
        return form;
    }


}