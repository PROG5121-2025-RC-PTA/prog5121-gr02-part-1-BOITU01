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
public class Login {
    
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
         JOptionPane.showInputDialog("Enter usename");
       JOptionPane.showMessageDialog(null, "Username Successfully Captured.");
     }
     else{
         JOptionPane.showInputDialog("Enter username");
      JOptionPane.showMessageDialog(null, "The username is incorrectly formatted,please ensure that your username contains an underscore and is no more than five characters in length");
      return;
     }
     
     if (isValidPassword){
         JOptionPane.showInputDialog("Enter password");
       JOptionPane.showMessageDialog(null, "Password Successfully Captured.");
     }
     else{
         JOptionPane.showInputDialog("Enter password");
       JOptionPane.showMessageDialog(null, "Password is not correctly formatted,please ensure that the password contains atleast eight characters,a capital letter,a number,and a special character");
       return;
     }
     
     if (isValidCellNo){
         JOptionPane.showInputDialog("Enter cellphone Number");
       JOptionPane.showMessageDialog(null, "Cellphone Number Successfully Captured.");  
     }
     else{
         JOptionPane.showInputDialog("Enter cellphone Number");
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
  obj.registerUser("Boi_t", "Boitu@Mahlak12", "+27838968976");
//JOptionPane.showMessageDialog(null, isValid ); 
  }   
} /*END OF CLASS*/

