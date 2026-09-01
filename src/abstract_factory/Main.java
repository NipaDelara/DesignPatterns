package abstract_factory;

public class Main {
    public static void main(String[] args) {

        // Choose Style A
        UIFactory factory = new AFactory();

        Button button = factory.createButton("Login");
        TextField textField = factory.createTextField("Enter username");
        Checkbox checkbox = factory.createCheckbox("Remember me");

        System.out.println("STYLE A");
        System.out.println();

        button.display();
        textField.display();
        checkbox.display();

        System.out.println();
        System.out.println("After changing text:");
        System.out.println();

    }
}