package mediator;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Create one shared mediator
        Mediator mediator = new ChatMediator();

        // Create usernames
        List<String> usernames =
                List.of("Alice", "Bob", "Charlie");

        // Create three independent controllers
        ChatController alice =
                new ChatController("Alice", mediator);

        ChatController bob =
                new ChatController("Bob", mediator);

        ChatController charlie =
                new ChatController("Charlie", mediator);

        // Register all clients with the mediator
        mediator.registerClient(alice);
        mediator.registerClient(bob);
        mediator.registerClient(charlie);

        // Create three separate chat windows
        ChatWindow aliceWindow =
                new ChatWindow(alice, usernames, 20, 100);

        ChatWindow bobWindow =
                new ChatWindow(bob, usernames, 370, 100);

        ChatWindow charlieWindow =
                new ChatWindow(charlie, usernames, 720, 100);

        // Connect each controller to its own GUI
        alice.setView(aliceWindow);
        bob.setView(bobWindow);
        charlie.setView(charlieWindow);
    }

    public static void main(String[] args) {

        // Start JavaFX application
        launch(args);
    }
}
