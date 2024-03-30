package com.project;
/**
 * A basic implementation of the Data Entry step for the Original Document
 * Return Request Functional Area
 */
public class DataEntry {

    // attributes that the applicant will input during this step
    String email;
    int formID;

    /**
     * This method sets the email that they are using.
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method sets the ID of the form that the user is requesting.
     * @param formID
     */
    public void setID(int formID) {
        this.formID = formID;
    }
}