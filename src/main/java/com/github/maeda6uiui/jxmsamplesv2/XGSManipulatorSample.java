package com.github.maeda6uiui.jxmsamplesv2;

import com.github.dabasan.jxm.properties.weapon.Weapon;
import com.github.dabasan.jxm.properties.weapon.xgs.XGSManipulator;

import java.io.IOException;
import java.util.Arrays;

/**
 * Code sample for XGSManipulator
 *
 * @author maeda6uiui
 */
public class XGSManipulatorSample {
    public static void main(String[] args) {
        //Load XGS file
        XGSManipulator manipulator;
        try {
            manipulator = new XGSManipulator("./Data/weapons.xgs");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        //Print weapon data
        Weapon[] weapons = manipulator.getWeapons();
        Arrays.asList(weapons).forEach(System.out::println);

        //Change weapon names
        for (int i = 0; i < weapons.length; i++) {
            weapons[i].name = String.valueOf(i);
        }

        //Set weapon data
        manipulator.setWeapons(weapons);

        try {
            //Save as XGS
            manipulator.saveAsXGS("./Data/weapons_2.xgs");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
