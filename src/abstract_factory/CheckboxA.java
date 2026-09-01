package abstract_factory;

import javax.swing.*;

public class CheckboxA extends Checkbox {
    public CheckboxA(String text) {
        super(text);
    }

    @Override
    public void display(){
        System.out.println("[ ] " + text);
    }
}
