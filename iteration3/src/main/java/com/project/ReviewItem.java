package com.project;
//import com.WorkflowTableItem;

import java.io.File;

public class ReviewItem extends WorkflowTableItem implements Comparable<ReviewItem>{
    //true when the item has been returned from approval item because it was denied and needs to be approved again.
    //this is to set a higher priority over other ones
    
    public ReviewItem(File form){

    }
    //idk if this will be needed in the final implimentation, dont worry about it. 
    public void editForm(){

    }
    /**
     * method to generate a new approvalitem to be inserted back into the workflowtable
     * @return an approval item with the same ID and form associated with the application
     */
    public ApprovalItem genApprovalItem(){
        return null;
    }
    @Override
    public int compareTo(ReviewItem r) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
}

