package abstract_factory;

public abstract class Button extends UIElement {

    public Button(String text) {
        super(text);
    }
    @Override
    public abstract void display();
}
