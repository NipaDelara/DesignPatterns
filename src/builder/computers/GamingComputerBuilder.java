package builder.computers;

// Concrete Builder: creates a Gaming Computer
public class GamingComputerBuilder implements ComputerBuilder {

    private Computer computer;

    // Create an empty computer
    public GamingComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildProcessor() {
        computer.setProcessor("Intel Core i9");
    }

    @Override
    public void buildRAM() {
        computer.setRam(32);
    }

    @Override
    public void buildHardDrive() {
        computer.setHardDrive("1 TB SSD");
    }

    @Override
    public void buildGraphicsCard() {
        computer.setGraphicsCard("NVIDIA RTX 4080");
    }

    @Override
    public void buildOperatingSystem() {
        computer.setOperatingSystem("Windows 11");
    }

    // Return the completed gaming computer
    @Override
    public Computer getComputer() {
        return computer;
    }
}