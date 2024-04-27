package com.project;

/**
 * A basic implementation of the Review step for the Original Document
 * Return Request Functional Area
 * 
 * @author Buckley O'Day
 * @version 1.0
 */
public class Review {

    public String email;
    public int formID;

    /**
     * This is a constructor for an item that has gone through Data Entry.
     * 
     * @param email
     * @param formID
     */
    public Review(String email, int formID) {
        this.email = email;
        this.formID = formID;
    }

    /**
     * This method checks that an email is valid.
     * 
     * @return boolean
     */
    public boolean validateEmail() {
        if (this.email != null && this.email.contains("@")) {
            return true;
        }
        else {
            // imagine that the reviewer can modify data here
            return false;
        }
     }
            
    /**
     * This method checks that the form ID is valid.
     * 
     * @return boolean
     */
    public boolean validateFormID() {
        // for now, assume that only IDs 0-100 are valid
        if (this.formID < 0 || this.formID > 100) {
            return false;
        }
        else {
            return true;
        }
    }

    /**
     * This method sets the email.
     * 
     * @param email The new email.
     */
    public void setEmail(String email) {
        this.email = email;
    }
}