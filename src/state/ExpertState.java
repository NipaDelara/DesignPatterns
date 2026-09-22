package state;

public class ExpertState implements CharacterState {
    @Override
    public void train(GameCharacter character) {
        System.out.println("Training...");
        character.addExperience(20);

        checkLevelUp(character);
    }
    @Override
    public void meditate(GameCharacter character) {
        System.out.println("Meditate...");
        character.addHealth(10);
    }
    @Override
    public void fight(GameCharacter character) {
        System.out.println("Fight...");
        character.addExperience(30);
        character.addHealth(10);

        checkLevelUp(character);
    }

    private void checkLevelUp(GameCharacter character) {
        if (character.getExperience() >= 200) {
            System.out.println(
                    "Level up!Expert -> Master"
            );
            character.setState(new MasterState());
        }
    }
    @Override
    public String getLevelName() {
        return "Expert State";
    }
}
