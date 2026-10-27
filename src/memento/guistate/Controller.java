
package memento.guistate;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    // Model and GUI
    private final Model model;
    private final Gui gui;

    // Task 1: Store states for Undo and Redo
    private final List<IMemento> history;
    private final List<IMemento> redoHistory;

    // Constructor
    public Controller(Gui gui) {

        this.model = new Model();
        this.gui = gui;

        // Initialize history lists
        this.history = new ArrayList<>();
        this.redoHistory = new ArrayList<>();
    }

    // Change rectangle color
    public void setOption(int optionNumber, int choice) {

        // Save previous state before changing
        saveToHistory();

        model.setOption(optionNumber, choice);
    }

    // Get rectangle color
    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    // Change checkbox state
    public void setIsSelected(boolean isSelected) {

        // Save previous state before changing
        saveToHistory();

        model.setIsSelected(isSelected);
    }

    // Get checkbox state
    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    // Task 1: Undo with Ctrl + Z
    public void undo() {

        // Check if Undo history exists
        if (!history.isEmpty()) {

            // Save current state for Redo
            redoHistory.add(model.createMemento());

            // Get last saved state
            IMemento previousState =
                    history.remove(history.size() - 1);

            // Restore previous state
            model.restoreState(previousState);

            // Update GUI
            gui.updateGui();

            System.out.println("Undo completed");
        }
    }

    // Task 1: Redo with Ctrl + Y
    public void redo() {

        // Check if Redo history exists
        if (!redoHistory.isEmpty()) {

            // Save current state for Undo
            history.add(model.createMemento());

            // Get last undone state
            IMemento nextState =
                    redoHistory.remove(redoHistory.size() - 1);

            // Restore undone state
            model.restoreState(nextState);

            // Update GUI
            gui.updateGui();

            System.out.println("Redo completed");
        }
    }

    // Save current state before a new change
    private void saveToHistory() {

        // Create a snapshot of current Model
        IMemento currentState = model.createMemento();

        // Add snapshot to Undo history
        history.add(currentState);

        // New changes clear Redo history
        redoHistory.clear();
    }

    // Task 2: Return saved states to History window
    public List<IMemento> getHistory() {

        // Return a copy of the history list
        return new ArrayList<>(history);
    }

    // Task 2: Restore a selected history state
    public void restoreFromHistory(int index) {

        // Check that selected index is valid
        if (index < 0 || index >= history.size()) {
            return;
        }

        // Save current state
        IMemento currentState = model.createMemento();

        // Get selected state
        IMemento selectedState = history.get(index);

        // Collect states after the selected state
        List<IMemento> newerStates = new ArrayList<>(
                history.subList(index + 1, history.size())
        );

        // Remove selected and newer states from Undo history
        history.subList(index, history.size()).clear();

        // Clear old Redo history
        redoHistory.clear();

        // Save current state first for Redo
        redoHistory.add(currentState);

        // Save newer states in reverse order
        for (int i = newerStates.size() - 1; i >= 0; i--) {
            redoHistory.add(newerStates.get(i));
        }

        // Restore selected state
        model.restoreState(selectedState);

        // Update GUI
        gui.updateGui();

        System.out.println("History state restored");
    }
}
