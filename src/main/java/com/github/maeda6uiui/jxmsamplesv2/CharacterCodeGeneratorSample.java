package com.github.maeda6uiui.jxmsamplesv2;

import com.github.dabasan.jxm.properties.character.Character;
import com.github.dabasan.jxm.properties.character.openxops.CharacterCodeGenerator;
import com.github.dabasan.jxm.properties.xops.EXEManipulator;

import java.io.IOException;
import java.util.Arrays;

/**
 * Outputs character data in the format of OpenXOPS source code
 *
 * @author maeda6uiui
 */
public class CharacterCodeGeneratorSample {
    public static void main(String[] args) {
        //Load character data from XOPS binary
        EXEManipulator manipulator;
        try {
            manipulator = new EXEManipulator("./Data/xops0975t.exe");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Character[] characters = manipulator.getCharacters();

        //Output character data in the format of OpenXOPS source code
        var generator = new CharacterCodeGenerator();
        String code = generator.generate(Arrays.asList(characters));
        System.out.println(code);
    }
}
