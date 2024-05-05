package com.github.maeda6uiui.jxmsamplesv2;

import com.github.dabasan.jxm.properties.weapon.Weapon;
import com.github.dabasan.jxm.properties.weapon.ids.IDSManipulator;

import java.io.IOException;

/**
 * Code sample for IDSManipulator
 *
 * @author maeda6uiui
 */
public class IDSManipulatorSample {
    public static void main(String[] args) {
        //Load IDS file
        IDSManipulator manipulator;
        try {
            manipulator = new IDSManipulator("./Data/mp5.ids");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        //Print weapon data
        Weapon weapon = manipulator.getWeapon();
        System.out.println(weapon);

        //Change weapon name
        weapon.name = "Test";
        //Change attack power
        weapon.attacks = 100;

        //Set weapon data
        manipulator.setWeapon(weapon);

        try {
            //Save as IDS
            manipulator.saveAsIDS("./Data/test.ids");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
