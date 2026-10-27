package memento.guistate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Memento implements IMemento {
    private final int[] options;
    private final boolean isSelected;
    private final LocalDateTime savedAt;

    public Memento(int[] options, boolean isSelected) {
        this.options = options.clone(); // Copy options array
        this.isSelected = isSelected;

        // Task 2: Save date and time
        this.savedAt = LocalDateTime.now();
        System.out.println("Memento created");
        System.out.println("Memento created");
    }

    public int[] getOptions() {

        return options.clone();
    }

    public boolean isSelected() {

        return isSelected;
    }

    // Task 2: Describe saved state

    @Override
    public String getDescription() {

        String time = savedAt.format(
                DateTimeFormatter.ofPattern("HH:mm:ss")
        );

        String[] colors = {"Red", "Blue", "Yellow"};

        return "Saved: " + time
                + " | Colors: "
                + colors[options[0]] + ", "
                + colors[options[1]] + ", "
                + colors[options[2]]
                + "\nCheckbox: " + isSelected;
    }
}
