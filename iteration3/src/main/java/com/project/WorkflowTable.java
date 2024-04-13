package com.project;

import java.util.Comparator;
import java.util.PriorityQueue;
/**
 * workflowtable data structure for the program
 * @author Arron Birhanu, Buckley O'Day, Logan Ericksen
 * @version 1.0
 */
public class WorkflowTable {
    /**
     * priority queue for storing all pending items to be reviewed in the workflow
     */
    private PriorityQueue<ReviewItem> reviewList;
    /**
     * Prioriy queue for storing all pending items to be approved in the workflow
     */
    private PriorityQueue<ApprovalItem> approvalList;
    /**
     * Field for keeping track of the ID for each of the items in each of the lists. Whenever an item is added, the number shuold be incremented.
     *  The ID should also maintain the order chronologically, since each item being added will increase it.
     */
    private int maxID;
    /**
     * constructor for making the workflow table in main. 
     */
    public WorkflowTable(){
        reviewList = new PriorityQueue<>();
        approvalList = new PriorityQueue<>();
        maxID =0;
    }
    /**
     * method to add a review item into the workflow. 
     * Will be inserted into the reviewList priorirty queue.
     * @param item is what is to be inserted
     */
    public void addReviewItem(ReviewItem item){
        reviewList.add(item);
        System.out.println("Test");
    }
    /**
     * method for inserting an item into the approvalList priority queue
     * @param ai, approvalitem, is what is to be inserted into the approvalList queue
     */
    public void addApprovalItem(ApprovalItem ai){
        approvalList.add(ai);
        System.out.println("Test");
    }
    /**
     * getter for getting the head of the priority queue reviewList. Just calls poll on the list
     * @return head of the reviewList priority queue, and dequeues it
     */
    public ReviewItem getNextReviewItem(){
        if (reviewList.size()==0){
            return null;
        }
        return reviewList.poll();
    }
    /**
     * getter for the head of the approvalItemList, returns head of the approvalItemList and dequeues it. 
     * @return head of the approvalList, and dequeues it
     */
    public ApprovalItem getNextApprovalItem(){
        if (approvalList.size()==0){
            return null;
        }
        return approvalList.poll();
    }
    /**
     * idk what this does yet - Logan
     * @return
     */
    public int countWFItems() {
        return reviewList.size();
    }
    /**
     * whenever an object is made to be put in the workflow table, use this method to set the ID when you make it.
     * @return maxID, the current integer that should be the ID for a new object  
     */
    public int getID(){
        return maxID++;
    }
    //debug, just removes everything from the approval list and prints it so. For manually checking order if needed
    public void removeAndPrint(){
        while(approvalList.peek()!=null){
            ApprovalItem a = approvalList.poll();
            System.out.println(a.getID());
        }
    }
}
