package abstract_factory;

public abstract class Checkbox extends UIElement {

    public Checkbox(String text) {
        super(text);
    }
    @Override
    public abstract void display();
}
