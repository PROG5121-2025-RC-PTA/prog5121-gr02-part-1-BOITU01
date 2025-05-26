/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author boitu
 */

import javaapplication2.Login;
import javax.swing.JOptionPane;



public class QuickChatApp {
    
    private static int totalMessagesSent = 0;
    
    public static void main(String[] args) {
        Login login = new Login();
        if (!login()) {
            JOptionPane.showMessageDialog(null, "Login failed. Exiting.");
            return;
        }
Message message = new Message();
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
            
            JOptionPane.showMessageDialog(null, "Message sent to " + recipient + ": " + message);
        }
    }

    private static void showStoredMessages() {
        
        JOptionPane.showMessageDialog(null, "Message storage feature coming soon...");
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



    







