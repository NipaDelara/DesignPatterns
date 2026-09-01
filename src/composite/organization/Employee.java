package composite.organization;

public class Employee implements OrganizationComponent{
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public void printXML(String indent) {
        System.out.println(
                indent + "<employee name=\"" + name +
                        "\" salary=\"" + salary + "\"/>"
        );
    }
}
