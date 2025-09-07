/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication2;

/**
 *
 * @author boitu
 */
import javax.swing.JOptionPane;
public class QuickchatApp {
    
   public boolean checkUserName(String username) {

      boolean isValid;
      if (username.contains("_") && username.length() <= 5 ){
        isValid =  true;
      }else{
         isValid =  false;
      }
      return isValid;
    } /*checkUsername*/ 
   
   public boolean checkPasswordComplexity(String password){
     
     boolean isValid;
     if (password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*\\d.*") && password.matches(".*[^a-zA-Z0-9].*")){
        isValid = true;
     }
     else{
        isValid = false;
     }
     return isValid;
   } /*checkPasswordComplexity*/
   
   public boolean checkCellPhoneNumber(String cellphoneNumber) {
      /*check if the cell number starts with +.....*/
      boolean isValid;
      if (cellphoneNumber.length() == 12 && cellphoneNumber.matches("^\\+\\d.*")){
        isValid = true;
      }
      else{
        isValid = false;
      }
      return isValid;
   } /*checkCellPhoneNumber*/   
   
   public void registerUser(String username, String password, String cellNumber){
     
     boolean isValidUsername =  checkUserName(username);
     boolean isValidPassword =  checkPasswordComplexity(password);
     boolean isValidCellNo   =  checkCellPhoneNumber(cellNumber);
     
     if (isValidUsername){
         
       JOptionPane.showMessageDialog(null, "Username Successfully Captured.");
     }
     else{
      JOptionPane.showMessageDialog(null, "The username is incorrectly formatted,please ensure that your username contains an underscore and is no more than five characters in length");
      return;
     }
     
     if (isValidPassword){
       JOptionPane.showMessageDialog(null, "Password Successfully Captured.");
     }
     else{
       JOptionPane.showMessageDialog(null, "Password is not correctly formatted,please ensure that the password contains atleast eight characters,a capital letter,a number,and a special character");
       return;
     }
     
     if (isValidCellNo){
       JOptionPane.showMessageDialog(null, "Cellphone Number Successfully Captured.");  
     }
     else{
       JOptionPane.showMessageDialog(null, "Cellphone Capture failed.");
       return;
     }
     
     JOptionPane.showMessageDialog(null, "Registration successful."); 
   } /*Register user*/
   
   public boolean loginUser(String username,String password){
     String user = "Boi_t";
     String pass = "Boitu@Mahlak12";
     boolean isLoggedIn;
     
     if(username == user && password == pass) {
       isLoggedIn = true;  
     }
     else{
       isLoggedIn = false;
     }
     return isLoggedIn;
   } /*loginUser*/
   
   public String returnLoginStatus(String username, String Password){
     boolean isLoggedIn = loginUser(username, Password);
     String loginStatus;
       
     if (isLoggedIn) {
       loginStatus = "A successful login";  
     }
     else {
       loginStatus = "A failed login";
     }      
     return loginStatus;
   } /*returnLoginStatus*/


public static void main(String[] args){
  Login obj = new Login();
  
  String username = JOptionPane.showInputDialog("Enter username");
 String password = JOptionPane.showInputDialog("Enter password");
  String cellPhoneNumber = JOptionPane.showInputDialog(" Enter cellPhoneNumber  ");
  
  obj.registerUser(username, password,cellPhoneNumber );

  }   
} /*END OF CLASS*/

public class QuickChatApp {
    private static String storedUsername = "";
    private static String storedPassword = "";
    private static String storedPhone = "";
    private static boolean isLoggedIn = false;
    private static int messageCount = 0;

    public static void main(String[] args) {
        while (true) {
            String[] options = {"Register", "Login", "Send Message", "Exit"};
            int choice = JOptionPane.showOptionDialog(null, "QuickChat Menu", "Main Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                    null, options, options[0]);

            switch (choice) {
                case 0: register(); break;
                case 1: login(); break;
                case 2: if (isLoggedIn) sendMessage(); else JOptionPane.showMessageDialog(null, "Please login first"); break;
                case 3: System.exit(0);
                default: break;
            }
        }
    }

    private static void register() {
        String username = JOptionPane.showInputDialog("Enter username (must contain _ and be ≤5 chars):");
        if (!username.contains("_") || username.length() > 5) {
            JOptionPane.showMessageDialog(null, "Username must contain _ and be ≤5 characters");
            return;
        }

        String password = JOptionPane.showInputDialog("Enter password (≥8 chars, with capital, number, special char):");
        if (!isValidPassword(password)) {
            JOptionPane.showMessageDialog(null, "Password must be ≥8 chars with capital, number, and special char");
            return;
        }

        String phone = JOptionPane.showInputDialog("Enter SA phone (+27XXXXXXXXX):");
        if (!phone.startsWith("+27") || phone.length() != 11) {
            JOptionPane.showMessageDialog(null, "Phone must start with +27 and be 11 digits");
            return;
        }

        storedUsername = username;
        storedPassword = password;
        storedPhone = phone;
        JOptionPane.showMessageDialog(null, "Registration successful!");
    }

    private static boolean isValidPassword(String password) {
        if (password.length() < 8) return false;
        boolean hasUpper = !password.equals(password.toLowerCase());
        boolean hasDigit = password.matches(".\\d.");
        boolean hasSpecial = !password.matches("[A-Za-z0-9]*");
        return hasUpper && hasDigit && hasSpecial;
    }

    private static void login() {
        String username = JOptionPane.showInputDialog("Enter username:");
        String password = JOptionPane.showInputDialog("Enter password:");

        if (username.equals(storedUsername) && password.equals(storedPassword)) {
            isLoggedIn = true;
            String name = JOptionPane.showInputDialog("Enter your first name:");
            JOptionPane.showMessageDialog(null, "Welcome " + name + ", great to see you!");
        } else {
            JOptionPane.showMessageDialog(null, "Invalid credentials");
        }
    }

    private static void sendMessage() {
        String recipient = JOptionPane.showInputDialog("Enter recipient phone (+27XXXXXXXXX):");
        if (!recipient.startsWith("+27") || recipient.length() != 11) {
            JOptionPane.showMessageDialog(null, "Invalid phone format");
            return;
        }

        String message = JOptionPane.showInputDialog("Enter message (max 250 chars):");
        if (message.length() > 250) {
            JOptionPane.showMessageDialog(null, "Message too long (max 250 chars)");
            return;
        }

        String messageId = String.format("%010d", new Random().nextInt(1000000000));
        String[] words = message.split(" ");
        String firstWord = words.length > 0 ? words[0] : "";
        String lastWord = words.length > 1 ? words[words.length-1] : firstWord;
        String messageHash = (messageId.substring(0,2) + ":" + (++messageCount) + ":" + firstWord + lastWord).toUpperCase();

        String[] options = {"Send", "Discard", "Save for later"};
        int action = JOptionPane.showOptionDialog(null, "Message options", "Choose action",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, options, options[0]);

        if (action == 0) { // Send
            JOptionPane.showMessageDialog(null, 
                "Message sent!\nID: " + messageId + 
                "\nHash: " + messageHash + 
                "\nTo: " + recipient + 
                "\nMessage: " + message);
        } else if (action == 1) { // Discard
            JOptionPane.showMessageDialog(null, "Message discarded");
        } else { // Save
            JOptionPane.showMessageDialog(null, "Message saved for later");
        }
    }
}
