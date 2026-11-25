
package mediator;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

// GUI class
public class ChatWindow {

    private final TextArea chatArea = new TextArea();
    private final TextField messageField = new TextField();
    private final ComboBox<String> recipientBox =
            new ComboBox<>();

    private final ChatController controller;

    // Constructor
    public ChatWindow(ChatController controller,
                      List<String> usernames,
                      double x,
                      double y) {

        this.controller = controller;

        // Create a new window
        Stage stage = new Stage();

        // Display username in the window title
        stage.setTitle("Chat - " + controller.getUsername());

        // Display sent and received messages
        chatArea.setEditable(false);
        chatArea.setWrapText(true);
        chatArea.setPrefHeight(220);

        // Message input field
        messageField.setPromptText("Type your message");

        // Add recipients except the current user
        for (String username : usernames) {

            if (!username.equals(controller.getUsername())) {
                recipientBox.getItems().add(username);
            }
        }

        // Select the first recipient by default
        recipientBox.getSelectionModel().selectFirst();

        // Create send button
        Button sendButton = new Button("Send");

        // Handle send button click
        sendButton.setOnAction(event -> sendMessage());

        // Send message by pressing Enter
        messageField.setOnAction(event -> sendMessage());

        // Arrange GUI components vertically
        VBox root = new VBox(
                10,
                new Label("Chat History"),
                chatArea,
                new Label("Select Recipient"),
                recipientBox,
                messageField,
                sendButton
        );

        root.setPadding(new Insets(15));

        // Create scene
        Scene scene = new Scene(root, 330, 400);

        stage.setScene(scene);

        // Set window position
        stage.setX(x);
        stage.setY(y);

        // Display the window
        stage.show();
    }

    // Read user input and send it to the controller
    private void sendMessage() {

        String recipient = recipientBox.getValue();
        String message = messageField.getText();

        if (recipient != null && !message.isBlank()) {

            controller.sendMessage(recipient, message);

            // Clear the input field after sending
            messageField.clear();
        }
    }

    // Display a message in the chat history
    public void displayMessage(String message) {

        chatArea.appendText(message + "\n");
    }
}
