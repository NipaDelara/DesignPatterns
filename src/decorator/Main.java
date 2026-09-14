package decorator;

public class Main {
    public static void main(String[] args) {

        Printer printer =
                new XMLPrinter(
                new BasicPrinter()
        );
        printer.print("Hello World!");

    }
}
