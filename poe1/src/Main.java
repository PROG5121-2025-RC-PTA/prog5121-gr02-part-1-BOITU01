
import javaapplication2.Login;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author boitu
 */
public class Main {
    
    public static void main(String[] args) {
        Login login = new Login();
        String loginUsername = JOptionPane.showInputDialog(null, "Enter username:");
        String loginPassword = JOptionPane.showInputDialog(null, "Enter password:");
        Object password = null;
        Object username = null;
            
            if (loginUsername.equals(username) && loginPassword.equals(password)) {
            String firstName = null;
            String lastname = null;
                JOptionPane.showMessageDialog(null, 
                    "Welcome " + firstName + " " + lastname + "! It is great to see you again.");
      try {
        QuickChatApp chatApp = new QuickChatApp();
        
      } catch (Exception e) {
        JOptionPane.showMessageDialog(null,
            "Failed to launch chat application: " + e.getMessage(),
            "Error", JOptionPane.ERROR_MESSAGE);
    }
    } 
              
          
     else {
                JOptionPane.showMessageDialog(null, 
                    "Login failed, wrong username or password", 
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
       Message message = new Message();
        int option = JOptionPane.showOptionDialog(
            null,
            "Select an option:",
            "Title",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.PLAIN_MESSAGE,
            null,
            new Object[] { "Option 1", "Option 2", "Option 3" },
            "Option 1"
        );

        switch (option) {
            case 0:
                JOptionPane.showMessageDialog(null, "Option 1 selected.");
                
                break;
            case 1:
                JOptionPane.showMessageDialog(null, "Coming Soon.");
                break;
            case 2:
                int totalMessages = 0; 
                JOptionPane.showMessageDialog(null, "Total Message Sent: " + totalMessages + "\nExiting QuickChat.");
                System.exit(0);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid option. Please choose 1, 2, or 3.");
        }
        
        if (login()) {
            JOptionPane.showMessageDialog(null, "Login successful!");
            QuickChatApp quickchatapp = new QuickChatApp();
        } else {
            JOptionPane.showMessageDialog(null, "Login failed!");
        }
    }

    private static boolean login() {
        String username = JOptionPane.showInputDialog("Enter username:");
        String password = JOptionPane.showInputDialog("Enter password:");
        
        return username != null && password != null && username.equals("Boi_t") && password.equals("Boitu@Mahlak12");
        
    }
    
}


    
