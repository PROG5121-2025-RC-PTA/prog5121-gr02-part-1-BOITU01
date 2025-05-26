/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author boitu
 */
public class MessageTest {
    
    public MessageTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of checkMessageId method, of class Message.
     */
    @Test
    public void testCheckMessageId() {
        System.out.println("checkMessageId");
        Message instance = new Message();
        boolean expResult = false;
        boolean result = instance.checkMessageId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkRecipientCell method, of class Message.
     */
    @Test
    public void testCheckRecipientCell() {
        System.out.println("checkRecipientCell");
        Message instance = new Message();
        boolean expResult = false;
        boolean result = instance.checkRecipientCell();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createMessageHash method, of class Message.
     */
    @Test
    public void testCreateMessageHash() {
        System.out.println("createMessageHash");
        Message instance = new Message();
        String expResult = "";
        String result = instance.createMessageHash();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sendMessage method, of class Message.
     */
    @Test
    public void testSendMessage() {
        System.out.println("sendMessage");
        String action = "";
        Message instance = new Message();
        String expResult = "";
        String result = instance.sendMessage(action);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printMessageDetails method, of class Message.
     */
    @Test
    public void testPrintMessageDetails() {
        System.out.println("printMessageDetails");
        Message instance = new Message();
        String expResult = "";
        String result = instance.printMessageDetails();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMessageId method, of class Message.
     */
    @Test
    public void testGetMessageId() {
        System.out.println("getMessageId");
        Message instance = new Message();
        String expResult = "";
        String result = instance.getMessageId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMessageNumber method, of class Message.
     */
    @Test
    public void testGetMessageNumber() {
        System.out.println("getMessageNumber");
        Message instance = new Message();
        int expResult = 0;
        int result = instance.getMessageNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRecipient method, of class Message.
     */
    @Test
    public void testGetRecipient() {
        System.out.println("getRecipient");
        Message instance = new Message();
        String expResult = "";
        String result = instance.getRecipient();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMessageText method, of class Message.
     */
    @Test
    public void testGetMessageText() {
        System.out.println("getMessageText");
        Message instance = new Message();
        String expResult = "";
        String result = instance.getMessageText();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMessageHash method, of class Message.
     */
    @Test
    public void testGetMessageHash() {
        System.out.println("getMessageHash");
        Message instance = new Message();
        String expResult = "";
        String result = instance.getMessageHash();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMessageCount method, of class Message.
     */
    @Test
    public void testGetMessageCount() {
        System.out.println("getMessageCount");
        int expResult = 0;
        int result = Message.getMessageCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
