package builder.computers;

// Concrete Builder: creates an Office Computer
public class OfficeComputerBuilder implements ComputerBuilder {

    private Computer computer;

    // Create an empty computer
    public OfficeComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildProcessor() {
        computer.setProcessor("Intel Core i5");
    }

    @Override
    public void buildRAM() {
        computer.setRam(16);
    }

    @Override
    public void buildHardDrive() {
        computer.setHardDrive("512 GB SSD");
    }

    @Override
    public void buildGraphicsCard() {
        computer.setGraphicsCard("Intel Integrated Graphics");
    }

    @Override
    public void buildOperatingSystem() {
        computer.setOperatingSystem("Windows 11 Pro");
    }

    // Return the completed office computer
    @Override
    public Computer getComputer() {
        return computer;
    }
}
