package composite.organization;

public class Main {
    public static void main(String[] args) {
        // Create employees
        Employee employee1 =
                new Employee("Alex", 4000);
        Employee employee2 =
                new Employee("John", 5000);
        Employee employee3 =
                new Employee("Laura", 6000);
        Employee employee4 =
                new Employee("Jane", 6000);
        Employee employee5 =
                new Employee("Jack", 6000);

        //create departments
        Department company =
                new Department("My Company");
        Department itDepartment =
                new Department("IT");

        Department developmentDepartment =
                new Department("Development");

        Department hrDepartment =
                new Department("HR");

        // add employees to Development department
        developmentDepartment.add(employee3);
        developmentDepartment.add(employee4);

        // add employees and department to IT
        itDepartment.add(employee1);
        itDepartment.add(employee2);
        itDepartment.add(developmentDepartment);

        // add employee to HR
        hrDepartment.add(employee5);

        // add departments to company
        company.add(itDepartment);
        company.add(hrDepartment);

        // print total salary
        System.out.println("Total salary: "
                + company.getSalary());


        System.out.println();

        System.out.println("Organization in XML format:");

        // print whole organization
        company.printXML("");
    }
}
