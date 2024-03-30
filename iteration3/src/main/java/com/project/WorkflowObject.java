package com.project;

/**
 * A representation of each Workflow Object in the Workflow Table. 
 * Each object is for one applicant.
 * 
 * 
 */
public class WorkflowObject {

    // relevant attributes for the Applicant 
    private String email;
    private int formID;

    /**
     * This method runs an applicant's info through all three
     * Workflow Steps.
     * 
     * @return boolean
     */
    public boolean validApplicant() {

        // first is Data Entry
        DataEntry d1 = new DataEntry();

        // just for testing, can be user input from data entry
        // or something at some point
        email = "test@email.com";
        formID = 1;

        d1.setEmail(email);
        d1.setID(formID);

        // next is Review
        Review r1 = new Review(email, formID);

        // object is created for approval
        Approve a1 = new Approve(email, formID);
        
        // last is Approval
        if (r1.validateEmail() == true && r1.validateFormID() == true) {
            
            // further implementation is needed
            
            return a1.approve();
        }
        else {
            // assume the applicant is not valid if they don't pass validation
            return a1.reject();
        }
    }
}