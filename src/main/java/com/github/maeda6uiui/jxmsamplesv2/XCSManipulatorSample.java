package com.github.maeda6uiui.jxmsamplesv2;

import com.github.dabasan.jxm.properties.character.Character;
import com.github.dabasan.jxm.properties.character.xcs.XCSManipulator;

import java.io.IOException;
import java.util.Arrays;

/**
 * Code sample for XCSManipulator
 *
 * @author maeda6uiui
 */
public class XCSManipulatorSample {
    public static void main(String[] args) {
        //Load XCS file
        XCSManipulator manipulator;
        try {
            manipulator = new XCSManipulator("./Data/characters.xcs");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        //Print character data
        Character[] characters = manipulator.getCharacters();
        Arrays.asList(characters).forEach(System.out::println);

        //Change HP of every character to 500
        for (var character : characters) {
            character.hp = 500;
        }

        //Set character data
        manipulator.setCharacters(characters);

        try {
            //Save as XCS
            manipulator.saveAsXCS("./Data/characters_2.xcs");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
