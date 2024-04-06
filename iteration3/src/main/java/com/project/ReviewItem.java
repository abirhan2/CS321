package com.project;
//import com.WorkflowTableItem;

import java.io.File;

public class ReviewItem extends WorkflowTableItem {
    //true when the item has been returned from approval item because it was denied and needs to be approved again.
    //this is to set a higher priority over other ones
    
    public ReviewItem(File form){

    }
    //idk if this will be needed in the final implimentation, dont worry about it. 
    public void editForm(){

    }
    //when the item is finished with review it will make an approvalitem of the same information
    public ApprovalItem genApprovalItem(){
        return null;
    }
    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }
}

