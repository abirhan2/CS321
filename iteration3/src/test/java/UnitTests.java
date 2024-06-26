
// add some import statements here for the Workflow/Step classes
import com.project.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

/**
 * This class contains unit tests for the WorkflowObject 
 * and corresponding Workflow Step Classes.
 * 
 * @author Buckley O'Day, Logan Ericksen, Arron Birhanu
 */
@TestInstance(Lifecycle.PER_CLASS)
public class UnitTests {
    
    // objects for testing
    DataEntry d1;

    Review r1;
    Review r2;
    Review r3;

    Approve a1;
    Approve a2;
    Approve a3;

    // Workflow Object which 
    WorkflowObject wfo;

    //workflowtable
    WorkflowTable wft;

    // the objects for testing
    @BeforeAll
    public void setup() {
        wfo = new WorkflowObject();

        d1 = new DataEntry();

        r1 = new Review("test@email.com", 1);
        r2 = new Review("Invalid Email", -1);
        r3 = new Review(null, 999);

        a1 = new Approve("test@email.com", 1);
        a2 = new Approve("Invalid Email", -1);
        a3 = new Approve(null, 999);
    }
    @BeforeEach
    public void perTest() {
        wft = new WorkflowTable();
    }

    /*** DATA ENTRY TESTS ***/

    // this tests that Data Entry sets the applicant's email correctly
    @Test
    public void dataEntrySetEmailTest() {
        d1.setEmail("test@email.com");
        Assertions.assertEquals("test@email.com", d1.email);
    }

    // this tests that Data Entry sets the applicant's 
    // requested form ID correctly
    @Test
    public void dataEntrySetFormIDTest() {
        d1.setID(1);
        Assertions.assertEquals(1, d1.formID);
    }

    /*** REVIEWER TESTS ***/
    

    // this tests that the email is valid
    @Test
    public void reviewerValidateEmailTest() {
        Assertions.assertEquals(true, r1.validateEmail());
        Assertions.assertEquals(false, r2.validateEmail());
        Assertions.assertEquals(false, r3.validateEmail());
    }

    // this tests that the form ID is valid
    @Test
    public void reviewerValidateFormIDTest() {
        Assertions.assertEquals(true, r1.validateFormID());
        Assertions.assertEquals(false, r2.validateFormID());
        Assertions.assertEquals(false, r3.validateFormID());
    }

    /*** APPROVER TESTS ***/

    // this tests that the data is approved
    @Test
    public void approverApproveTest() {
        assertEquals(true, a1.approve());
        
    }

    // this tests that the data is rejected
    @Test
    public void approverRejectTest() {
        assertEquals(false, a2.reject());
        assertEquals(false, a3.reject());
    }

    //test to ensure that the queue is working in order of ids, not of insertion
    @Test
    public void approvalListTest1(){
        ApprovalItem ai3 = new ApprovalItem(null, 1);
        ApprovalItem ai1 = new ApprovalItem(null, 2);
        ApprovalItem ai2 = new ApprovalItem(null, 3);

        wft.addApprovalItem(ai1);
        wft.addApprovalItem(ai2);
        wft.addApprovalItem(ai3);
        
        Assertions.assertEquals(wft.getNextApprovalItem().getID(), ai3.getID());
        Assertions.assertEquals(wft.getNextApprovalItem().getID(), ai1.getID());
        Assertions.assertEquals(wft.getNextApprovalItem().getID(), ai2.getID());
    }

    //test to ensure that returned items get first priority
    @Test
    public void approvalListTest2(){
        ApprovalItem ai3 = new ApprovalItem(null, 1);
        ApprovalItem ai1 = new ApprovalItem(null, 2);
        ApprovalItem ai2 = new ApprovalItem(null, 3);
        ai3.returned = true;

        wft.addApprovalItem(ai1);
        wft.addApprovalItem(ai2);
        wft.addApprovalItem(ai3);
        
        
        Assertions.assertEquals(wft.getNextReviewItem().getID(), ai3.getID());
        Assertions.assertEquals(wft.getNextReviewItem().getID(), ai1.getID());
        Assertions.assertEquals(wft.getNextReviewItem().getID(), ai2.getID());
    }
}