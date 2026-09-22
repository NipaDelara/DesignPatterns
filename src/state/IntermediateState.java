package state;

public class IntermediateState implements CharacterState {
    @Override
    public void train(GameCharacter character) {
        System.out.println("Training....");
        character.addExperience(20);

        checkLevelUp(character);
    }
    @Override
    public void meditate(GameCharacter character) {
        System.out.println("Meditate...");
        character.addHealth(10);
    }
    @Override
    public void fight(GameCharacter character){
        System.out.println("You can't fight at Intermediate level");
    }

    private void checkLevelUp(GameCharacter character) {

        if (character.getExperience() >= 100) {
            System.out.println(
                    "Level up! Intermediate -> Expert"
            );

            character.setState(new ExpertState());
        }
    }
    @Override
    public String getLevelName() {
        return "Intermediate";
    }
}
