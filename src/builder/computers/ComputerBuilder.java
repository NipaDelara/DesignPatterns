package builder.computers;

// Builder interface: defines construction steps
public interface ComputerBuilder {

    void buildProcessor();

    void buildRAM();

    void buildHardDrive();

    void buildGraphicsCard();

    void buildOperatingSystem();

    // Return the finished computer
    Computer getComputer();
}