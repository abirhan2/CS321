package com.project;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.Normalizer.Form;

/**
 * This class is for the Review Item for the Review stage.
 * 
 * @author Buckley O'Day
 * @version 1.0
 */
public class ReviewItem extends WorkflowTableItem implements Comparable<ReviewItem>{
    
    // this boolean will signify whether a form has been sent back by the approver,
    // in which case it will have higher priority
    boolean approved;

    /**
     * A constructor for the Review Item.
     * 
     * @param form The form being used.
     * @param uid The form's uID.
     */
    public ReviewItem(String email, int uid){
        super.ID = uid;
        super.email = email;
        this.approved = false;
    }
    
    /**
     * This method sets the email.
     * 
     * @param email The new email.
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * The overriden compareTo method so that the Priority Queue 
     * for Review Items stays organized
     * @param item The other Review item that is being compared to.
     * @return int The value used for sorting.
     */
    @Override
    public int compareTo(ReviewItem item) {
        
        // if both have priority since they were rejected from approval
        if((item.returned == true) && (this.returned == true)){
            return this.ID - item.getID();
        }
        // if an item has priority from being rejected by the Approver
        if(item.returned == true){
            return -1;
        }
        // if the other ReviewItem has priority from being rejected
        if(this.returned){
            return -1;
        }
        // else sort by ID
        return ID - item.getID();
    }
}