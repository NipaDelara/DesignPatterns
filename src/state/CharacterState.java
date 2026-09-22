package state;

public interface CharacterState {
    void train(GameCharacter character);
    void meditate(GameCharacter character);
    void flight(GameCharacter character);
    String getLevelName();

}
