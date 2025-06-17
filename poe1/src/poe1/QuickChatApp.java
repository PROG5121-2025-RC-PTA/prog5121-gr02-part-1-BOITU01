/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author boitu
 */

import javaapplication2.Login;
import poe1.Message;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;



public class QuickChatApp {
      
    private static int totalMessagesSent = 0;
    private static List<poe1.Message> sentMessages = new ArrayList<>();
    
    public static void main(String[] args) {
       
        Login login = new Login();
        if (!login()) {
            JOptionPane.showMessageDialog(null, "Login failed. Exiting.");
            return;
        }
       
        JOptionPane.showMessageDialog(null, "Welcome to QuickChat.");

        int messageLimit = getMessageLimit();
        int sentCount = 0;

        while (true) {
            int option = getMenuOption();
            if (option == 0) {
                JOptionPane.showMessageDialog(null, "Total messages sent: " + totalMessagesSent + "\nExiting QuickChat");
                System.exit(0);
            }

            switch (option) {
                case 1:
                    if (sentCount < messageLimit) {
                         JOptionPane.showMessageDialog(null, "Hello there!");
                        sendMessage();
                        sentCount++;
                        totalMessagesSent++;
                    } else {
                        JOptionPane.showMessageDialog(null, "Message limit reached.");
                    }
                    break;
                case 2:
                    showStoredMessages();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option.");
            }
            //
        }
    }
Main main = new Main();
    private static boolean login() {
        String username = JOptionPane.showInputDialog("Please enter username:");
        String password = JOptionPane.showInputDialog("Please enter password:");
        return username != null && password != null && 
               username.equals("Boi_t") && password.equals("Boitu@Mahlak12");
    }

    private static int getMessageLimit() {
        String input = JOptionPane.showInputDialog("How many messages would you like to enter?");
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
            return getMessageLimit(); 
        }
    }

    private static int getMenuOption() {
        String input = JOptionPane.showInputDialog(
                "Choose an option:\n" +
                "1) Send Message\n" +
                "2) Show recently sent messages\n" + 
                "0) Quit"
        );
        if (input == null) return 0; 
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
            return getMenuOption(); 
        }
    }

    private static void sendMessage() {
        
    
        
        String recipient = JOptionPane.showInputDialog("Enter recipient number (numbers only)");
        if (recipient == null) return; 
        
        
        if (!recipient.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Invalid recipient. Please enter numbers only.");
            return;
        }

        String message = JOptionPane.showInputDialog("Enter message (max 250 characters):");
        if (message == null) return; 

        if (message.length() > 250) {
            JOptionPane.showMessageDialog(null,
                    "Message exceeded character limit by " + (message.length() - 250) + 
                    " characters. Please reduce size.");
        } else {
            poe1.Message messageInstance = new poe1.Message(recipient, message);
            String sentMessage = messageInstance.sendMessage("store");
            sentMessages.add(messageInstance);
            JOptionPane.showMessageDialog(null, "Message sent to " + recipient + ": " + message);
        }
        
    }

    private static void showStoredMessages() {
    String[] options = {
        "a) Show sender & recipient",
        "b) Show longest message",
        "c) Search by Message ID",
        "d) Search by Recipient",
        "e) Delete by Hash",
        "f) Full Report"
    };
    String choice = (String) JOptionPane.showInputDialog(null, "Select an option:", "Message Viewer",
            JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

    if (choice == null) return;

    switch (choice.charAt(0)) {
        case 'a':
            showSendersAndRecipients();
            break;
        case 'b':
            showLongestMessage();
            break;
        case 'c':
            searchByMessageId();
            break;
        case 'd':
            searchByRecipient();
            break;
        case 'e':
            deleteByHash();
            break;
        case 'f':
            showFullReport();
            break;
        default:
            JOptionPane.showMessageDialog(null, "Invalid option selected.");
    }
}
    
private static void showSendersAndRecipients() {
    StringBuilder sb = new StringBuilder("Senders and Recipients:\n");
    for (poe1.Message msg : sentMessages) {
        sb.append("Sender: You, Recipient: ").append(msg.getRecipient()).append("\n");
    }
    JOptionPane.showMessageDialog(null, sb.toString());
}

private static void showLongestMessage() {
    if (sentMessages.isEmpty()) {
        JOptionPane.showMessageDialog(null, "No messages sent yet.");
        return;
    }

    poe1.Message longest = sentMessages.get(0);
    for (poe1.Message msg : sentMessages) {
        if (msg.getMessageText().length() > longest.getMessageText().length()) {
            longest = msg;
        }
    }
    JOptionPane.showMessageDialog(null, "Longest message:\n" + longest.getMessageText());
}

private static void searchByMessageId() {
    String id = JOptionPane.showInputDialog("Enter the message ID:");
    for (poe1.Message msg : sentMessages) {
        if (msg.getMessageId().equals(id)) {
            JOptionPane.showMessageDialog(null, "Recipient: " + msg.getRecipient() + "\nMessage: " + msg.getMessageText());
            return;
        }
    }
    JOptionPane.showMessageDialog(null, "Message ID not found.");
}

private static void searchByRecipient() {
    String recipient = JOptionPane.showInputDialog("Enter the recipient number:");
    StringBuilder sb = new StringBuilder("Messages sent to " + recipient + ":\n");
    boolean found = false;
    for (poe1.Message msg : sentMessages) {
        if (msg.getRecipient().equals(recipient)) {
            sb.append("- ").append(msg.getMessageText()).append("\n");
            found = true;
        }
    }
    if (found) {
        JOptionPane.showMessageDialog(null, sb.toString());
    } else {
        JOptionPane.showMessageDialog(null, "No messages sent to this recipient.");
    }
}

private static void deleteByHash() {
    String hash = JOptionPane.showInputDialog("Enter message hash to delete:");
    for (int i = 0; i < sentMessages.size(); i++) {
        if (sentMessages.get(i).getMessageHash().equals(hash)) {
            sentMessages.remove(i);
            JOptionPane.showMessageDialog(null, "Message deleted.");
            return;
        }
    }
    JOptionPane.showMessageDialog(null, "Message hash not found.");
}

private static void showFullReport() {
    StringBuilder sb = new StringBuilder("Full Message Report:\n");
    for (poe1.Message msg : sentMessages) {
        sb.append("ID: ").append(msg.getMessageId()).append("\n")
          .append("Recipient: ").append(msg.getRecipient()).append("\n")
          .append("Message: ").append(msg.getMessageText()).append("\n")
          .append("Hash: ").append(msg.getMessageHash()).append("\n\n");
    }
    JOptionPane.showMessageDialog(null, sb.toString());
}
  

    
    
    private static class Message {
        private String recipient;
        private String content;
        private String status;

        public Message(String recipient, String content, String status) {
            this.recipient = recipient;
            this.content = content;
            this.status = status;
        }

        private Message() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public String printMessageDetails() {
            return "Recipient: " + recipient + "\nMessage: " + content + "\nStatus: " + status;
        }
    }
}



    







