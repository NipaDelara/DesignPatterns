package builder.computers;

// Product class: stores the final computer configuration
public class Computer {

    private String processor;
    private int ram;
    private String hardDrive;
    private String graphicsCard;
    private String operatingSystem;

    // Set the processor
    public void setProcessor(String processor) {
        this.processor = processor;
    }

    // Set RAM size in GB
    public void setRam(int ram) {
        this.ram = ram;
    }

    // Set hard drive
    public void setHardDrive(String hardDrive) {
        this.hardDrive = hardDrive;
    }

    // Set graphics card
    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    // Set operating system
    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    // Display the complete computer configuration
    @Override
    public String toString() {
        return "Processor: " + processor
                + "\nRAM: " + ram + " GB"
                + "\nHard Drive: " + hardDrive
                + "\nGraphics Card: " + graphicsCard
                + "\nOperating System: " + operatingSystem;
    }
}
