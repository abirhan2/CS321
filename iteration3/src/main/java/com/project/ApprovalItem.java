package com.project;
//import com.WorkflowTableItem;

import java.io.File;

/**
 * object for each approval item that is pending. 
 * @author  Logan Ericksen
 * @version 1.0
 */
public class ApprovalItem extends WorkflowTableItem implements Comparable<ApprovalItem>{
    boolean approved;
    /**
     * constructor that takes in an ID and the file that is associated with the applicant who is waiting for their request to be fullfilled.
     */
    public ApprovalItem(File form, int uid){
        approved = false; 
        super.form = form;
        super.ID = uid;
    }
    /**
     * 
     * @param a is the item that is being compared to
     * @return integer value for comparison to allow sorting 
     */
    @Override
    public int compareTo(ApprovalItem a) {
        // TODO Auto-generated method stub
        if(a.returned && this.returned){
            return ID - a.getID();
        }
        if(a.returned == true){
             System.out.println("IDK");
            return 1;
        }
        if(this.returned){
            return -1;
        }
        return ID - a.getID();
    }
        
    
    

    
}
