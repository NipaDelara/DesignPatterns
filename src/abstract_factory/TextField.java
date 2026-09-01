package abstract_factory;

public abstract class TextField extends UIElement {

    public TextField(String text) {
        super(text);
    }

    @Override
    public abstract void display();
}
