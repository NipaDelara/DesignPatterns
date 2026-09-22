package state;

public class NoviceState implements CharacterState{
    @Override
    public void train(GameCharacter character) {
        System.out.println("Training .....");

        character.addExperience(20);

        if (character.getExperience() >= 40) {
            System.out.println("Level up! Novice -> Intermediate");
            character.setState(new IntermediateState());

        }
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("You cannot meditate at Novice level");
    }
    @Override
    public void fight(GameCharacter character){
        System.out.println("You cannot fight at Novice level.");
    }
    @Override
    public String getLevelName() {
        return "Novice";
    }
}
