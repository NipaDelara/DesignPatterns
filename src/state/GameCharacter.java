package state;

public class GameCharacter {

    private String name;
    private int experience;
    private int health;
    private CharacterState state;

    public GameCharacter(String name) {
        this.name = name;
        this.experience = 0;
        this.health = 100;
        this.state = new NoviceState();
    }
    public void train() {
        state.train(this);
    }
    public void meditate() {
        state.meditate(this);
    }
    public void fight() {
        state.fight(this);
    }

    public void addExperience(int amount) {
        experience += amount;
    }
    public void addHealth(int amount) {
        health += amount;
    }
    public void reduceHealth(int amount) {
        health -= amount;
        if(health < 0) {
            health = 0;
        }
    }
    public  void setState(CharacterState state) {
        this.state = state;
    }
    public CharacterState getState() {
        return state;
    }
    public int getExperience() {
        return experience;
    }
    public int getHealth() {
        return health;
    }
    public String getName() {
        return name;
    }
    public void displayStatus() {
        System.out.println("Name: " + name);
        System.out.println("Level: " + state.getLevelName());
        System.out.println("Experience: " + experience);
        System.out.println("Health: " + health);


    }
}
