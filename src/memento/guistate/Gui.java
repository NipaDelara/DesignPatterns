
package memento.guistate;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ListCell;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Gui extends Application {

    // Original GUI components
    private Controller controller;
    private ColorBox colorBox1;
    private ColorBox colorBox2;
    private ColorBox colorBox3;
    private CheckBox checkBox;

    @Override
    public void start(Stage stage) {

        // Create Controller
        controller = new Controller(this);

        // Set spacing
        Insets insets = new Insets(10);

        // Create three colored boxes
        colorBox1 = new ColorBox(1, controller);
        colorBox2 = new ColorBox(2, controller);
        colorBox3 = new ColorBox(3, controller);

        // Create checkbox
        checkBox = new CheckBox("Click me!");
        checkBox.setPadding(insets);

        // Arrange colored boxes horizontally
        HBox hBox = new HBox(
                colorBox1.getRectangle(),
                colorBox2.getRectangle(),
                colorBox3.getRectangle()
        );

        hBox.setSpacing(20);
        hBox.setPadding(insets);

        // Instructions for Undo and Redo
        Label label = new Label(
                "Press Ctrl-Z to undo the last change.\n" +
                        "Press Ctrl-Y to redo the last undone change."
        );

        label.setPadding(insets);

        // Task 2: Create History button
        Button historyButton = new Button("Show History");

        // Open History window when clicked
        historyButton.setOnAction(event -> showHistory());

        // Main layout
        VBox vBox = new VBox(
                hBox,
                checkBox,
                label,
                historyButton
        );

        vBox.setSpacing(10);
        vBox.setPadding(new Insets(10));

        // Save checkbox changes in Model
        checkBox.setOnAction(event -> {
            controller.setIsSelected(checkBox.isSelected());
        });

        // Create Scene
        Scene scene = getScene(vBox);

        stage.setScene(scene);
        stage.setTitle("Memento Pattern Example");
        stage.show();
    }

    // Task 1: Keyboard shortcuts for Undo and Redo
    private Scene getScene(VBox vBox) {

        Scene scene = new Scene(vBox);

        scene.setOnKeyPressed(event -> {

            // Undo: Ctrl + Z
            if (event.isControlDown()
                    && event.getCode() == KeyCode.Z) {

                System.out.println("Undo key combination pressed");
                controller.undo();
            }

            // Redo: Ctrl + Y
            if (event.isControlDown()
                    && event.getCode() == KeyCode.Y) {

                System.out.println("Redo key combination pressed");
                controller.redo();
            }
        });

        return scene;
    }

    // Update GUI after restoring saved state
    public void updateGui() {

        colorBox1.setColor(controller.getOption(1));
        colorBox2.setColor(controller.getOption(2));
        colorBox3.setColor(controller.getOption(3));

        checkBox.setSelected(controller.getIsSelected());
    }

    // Task 2: Open History window
    private void showHistory() {

        // Create new window
        Stage historyStage = new Stage();
        historyStage.setTitle("Memento History");

        // Create ListView to display saved states
        ListView<IMemento> historyList = new ListView<>();

        // Show readable state information
        historyList.setCellFactory(list -> new ListCell<>() {

            @Override
            protected void updateItem(IMemento item, boolean empty) {

                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getDescription());
                }
            }
        });

        // Load saved states from Controller
        historyList.setItems(
                FXCollections.observableArrayList(
                        controller.getHistory()
                )
        );

        // Restore state when selected
        historyList.setOnMouseClicked(event -> {

            int index = historyList.getSelectionModel()
                    .getSelectedIndex();

            if (index >= 0) {

                // Restore selected history state
                controller.restoreFromHistory(index);

                System.out.println("Selected history state restored");

                // Close History window
                historyStage.close();
            }
        });

        // History window layout
        Label title = new Label("Select a saved state to restore:");

        VBox layout = new VBox(
                10,
                title,
                historyList
        );

        layout.setPadding(new Insets(15));

        // Create History Scene
        Scene historyScene = new Scene(layout, 750, 350);

        historyStage.setScene(historyScene);
        historyStage.show();
    }
}
