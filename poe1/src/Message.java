
import javax.swing.JOptionPane;
import org.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONException;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author boitu
 */
 



public class Message {
    private String messageId;
    private static int messageCount = 0;
    private int messageNumber;
    private String recipient;
    private String messageText;
    private String messageHash;
    private MessageStorage storage;

    public Message(String recipient, String messageText) {
        this.messageId = generateMessageId();
        this.recipient = recipient;
        this.messageText = messageText;
        this.messageNumber = ++messageCount;
        this.messageHash = createMessageHash();
        this.storage = new MessageStorage();
    }
QuickChatApp quickchatapp = new QuickChatApp();
    public Message() {
        this("", ""); // Default constructor with empty values
    }

    private String generateMessageId() {
        long number = (long) (Math.random() * 1_000_000_000L);
        return String.format("%010d", number);
    }

    public boolean checkMessageId() {
        return messageId != null && messageId.length() == 10 && messageId.matches("\\d+");
    }

    public boolean checkRecipientCell() {
        return recipient != null && recipient.matches("\\d{10,13}");
    }
    Main main = new Main();

    public String createMessageHash() {
        if (messageText == null || messageText.trim().isEmpty()) {
            return "";
        }
        
        String[] words = messageText.trim().split("\\s+");
        if (words.length == 0) return "";
        
        String first = words[0].toUpperCase();
        String last = words[words.length - 1].toUpperCase();
        return first + last;
    }

    public String sendMessage(String action) {
        switch (action.toLowerCase()) {
            case "send":
                return "Message successfully sent to " + recipient;
            case "discard":
                return "Message discarded";
            case "store":
                storage.storeMessageToJson(messageId, messageHash, recipient, messageText);
                return "Message successfully stored.";
            default:
                return "Invalid action.";
        }
    }

    public String printMessageDetails() {
        return "Message Details:\n" +
               "ID: " + messageId + "\n" +
               "Number: " + messageNumber + "\n" +
               "Recipient: " + recipient + "\n" +
               "Text: " + messageText + "\n" +
               "Hash: " + messageHash;
    }

    // Getters
    public String getMessageId() { return messageId; }
    public int getMessageNumber() { return messageNumber; }
    public String getRecipient() { return recipient; }
    public String getMessageText() { return messageText; }
    public String getMessageHash() { return messageHash; }
    public static int getMessageCount() { return messageCount; }
}

class MessageStorage {
    public void storeMessageToJson(String messageId, String messageHash, String recipient, String messageText) {
        try {
            JSONObject obj = new JSONObject();
            obj.put("messageId", messageId);
            obj.put("messageHash", messageHash);
            obj.put("recipient", recipient);
            obj.put("messageText", messageText);

            FileWriter file = new FileWriter("storedMessages.json", true);
            file.write(obj.toString() + System.lineSeparator());
            file.close();
        } catch (IOException e) {
            System.out.println("Error saving message to JSON: " + e.getMessage());
        }
    }

    public static int returnTotalMessages() {
        return Message.getMessageCount();
    }
}