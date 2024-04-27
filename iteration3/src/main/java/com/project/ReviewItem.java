package com.project;
//import com.WorkflowTableItem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.Normalizer.Form;

public class ReviewItem extends WorkflowTableItem implements Comparable<ReviewItem>{
    //true when the item has been returned from approval item because it was denied and needs to be approved again.
    //this is to set a higher priority over other ones
    boolean approved = false;
    PrintWriter pw = null;

    /**
     * constructor that takes in an ID and the file that is associated with the applicant who is waiting for their request to be fullfilled.
     */
    public ReviewItem(File form, int uid){
        super.form = form;
        super.ID = uid;
    }

    //idk if this will be needed in the final implimentation, dont worry about it. 
    public void editForm(Form form){
        try {
            FileWriter fw = new FileWriter("test.txt", true);
            pw = new PrintWriter(fw);
            // just testing that it writes to a file 
            fw.write("Testing that I can edit a review form\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (pw != null) {
                pw.close();
            }
        }
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

