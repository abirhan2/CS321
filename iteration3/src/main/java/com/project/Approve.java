package com.project;

/**
 * A basic implementation of the Approval step for the Original Document
 * Return Request Functional Area
 * @author Logan Ericksen
 * @version 1.0
 */
public class Approve {
    
    // relevant attributes for this step 
    String email;
    int formID;
    boolean isApproved;

    /**
     * This is a constructor for an item that has gone through Review.
     * 
     * @param email
     * @param formID
     */
    public Approve(String email, int formID) {
        this.email = email;
        this.formID = formID;
    }

    /**
     * This method is called when the Approver approves an applicant.
     * They are then sent an email.
     * @return
     */
    public boolean approve() {
        // imagine that an email is sent here
        isApproved = true;
        return isApproved;
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
        isApproved = false;
        return isApproved;
    }
}