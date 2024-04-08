package com.project;


//may be deleted 

/**
 * A basic implementation of the Approval step for the Original Document
 * Return Request Functional Area
 * @author Logan Ericksen
 * @version 1.0
 */
public class Approve {
    
    // relevant attributes for this step 
    public String email;
    public int curFormID;

    /**
     * This is a constructor for an item that has gone through Review.
     * 
     * @param email
     * @param formID
     */
    public Approve(String email, int formID) {
        this.email = email;
        this.curFormID = formID;
    }

    /**
     * This method is called when the Approver approves an applicant.
     * They are then sent an email.
     * @return
     */
    public boolean approve() {
        // imagine that an email is sent here
        System.out.println("APPROVED!");
        return true;
    }

    /**
     * This method is called when the Approver rejects an applicant
     * for any reason.
     * 
     * @return boolean
     */
    public boolean reject() {
        // imagine that it gets sent back to the Reviewer 
        // with higher priority
      
        return false;
    }
}