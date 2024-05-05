package com.github.maeda6uiui.jxmsamplesv2;

import com.github.dabasan.jxm.properties.character.Character;
import com.github.dabasan.jxm.properties.weapon.Weapon;
import com.github.dabasan.jxm.properties.xops.EXEManipulator;

import java.io.IOException;
import java.util.Arrays;

/**
 * Loads weapon and character data from XOPS binary
 *
 * @author maeda6uiui
 */
public class EXEManipulatorSample {
    public static void main(String[] args) {
        //Open XOPS binary
        EXEManipulator manipulator;
        try {
            manipulator = new EXEManipulator("./Data/xops0975t.exe");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        //Print weapon data
        Weapon[] weapons = manipulator.getWeapons();
        Arrays.asList(weapons).forEach(System.out::println);

        //Print character data
        Character[] characters = manipulator.getCharacters();
        Arrays.asList(characters).forEach(System.out::println);

        try {
            //Save weapon and character data to XOPS binary
            //Backup file will be created if you pass non-null value to the second argument
            manipulator.write("./Data/xops0975t.exe", "./Data/xops0975t_backup.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
