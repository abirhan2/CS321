package com.project;
//import com.WorkflowTableItem;

import java.io.File;

public class ApprovalItem extends WorkflowTableItem{
    boolean approved;
    public ApprovalItem(File form){
        approved = false; 
        super.form = form;
    }
    //for when item is approved
    public void approve(){

    }
    //for when item is denied
    public void decline(){

    }
    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }

    
}
