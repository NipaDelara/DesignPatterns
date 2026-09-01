package composite.organization;

import  java.util.ArrayList;
import  java.util.List;

public class Department implements OrganizationComponent{
        private  String name;
        private List<OrganizationComponent> members;
        public Department(String name) {
            this.name = name;
            members = new ArrayList<>();
        }
        public void add(OrganizationComponent component) {
            members.add(component);
        }
        public void remove(OrganizationComponent component) {
            members.remove(component);
        }

    @Override
    public double getSalary() {
        double totalSalary = 0;
        for (OrganizationComponent component : members) {
            totalSalary += component.getSalary();
        }
        return totalSalary;
    }

    @Override
    public void printXML(String indent) {

        System.out.println(indent + "<department name=\"" + name + "\">");
        for (OrganizationComponent component : members) {
            component.printXML(indent + "  ");
        }
        System.out.println(indent + "</Department>");

    }
}
