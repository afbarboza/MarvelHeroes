package Model;

import java.util.ArrayList;
import java.util.List;

import Utils.Constants;

public class CharacterCollection {
    private static ArrayList<Character> charactersList;

    public static void addNewCharacter(Character character) {
        if (character == null || character.getThumbnail().getPath() == Constants.IMAGE_CHARACTER_NOT_FOUND) {
            return;
        }
        initCollection();
        charactersList.add(character);
    }

    public static ArrayList<Character> getCharactersList() {
        return charactersList;
    }

    private static void initCollection() {
        if (charactersList == null) {
            charactersList = new ArrayList<>();
        }
    }
}
