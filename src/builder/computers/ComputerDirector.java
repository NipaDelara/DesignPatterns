package builder.computers;

// Director: controls the computer building process
public class ComputerDirector {

    private ComputerBuilder builder;

    // Receive the selected builder
    public ComputerDirector(ComputerBuilder builder) {
        this.builder = builder;
    }

    // Build the computer step by step
    public void constructComputer() {

        builder.buildProcessor();
        builder.buildRAM();
        builder.buildHardDrive();
        builder.buildGraphicsCard();
        builder.buildOperatingSystem();
    }
}