package com.project;

import java.util.PriorityQueue;

public class WorkflowTable {
    private PriorityQueue<ReviewItem> reviewList;
    private PriorityQueue<ApprovalItem> approvalList;

    public WorkflowTable(){
        reviewList = new PriorityQueue<>();
        approvalList = new PriorityQueue<>();
    }
    public void addReviewItem(Object item){
        System.out.println("Test");
    }
    public void addApprovalItem(ApprovalItem ai){
        approvalList.add(ai);
        System.out.println("Test");
    }
    public ReviewItem getNextReviewItem(){
        return null;
    }
    public ApprovalItem getNextApprovalItem(){
        if (approvalList.size()==0){
            return null;
        }
        return approvalList.poll();
    }

    public int countWFItems() {
        return reviewList.size();
    }
}
