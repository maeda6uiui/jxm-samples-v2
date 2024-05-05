package com.github.maeda6uiui.jxmsamplesv2;

import com.github.dabasan.jxm.properties.weapon.Weapon;
import com.github.dabasan.jxm.properties.weapon.openxops.WeaponCodeGenerator;
import com.github.dabasan.jxm.properties.xops.EXEManipulator;

import java.io.IOException;
import java.util.Arrays;

/**
 * Outputs weapon data in the format of OpenXOPS source code
 *
 * @author maeda6uiui
 */
public class WeaponCodeGeneratorSample {
    public static void main(String[] args) {
        //Load weapon data from XOPS binary
        EXEManipulator manipulator;
        try {
            manipulator = new EXEManipulator("./Data/xops0975t.exe");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Weapon[] weapons = manipulator.getWeapons();

        //Output OpenXOPS source code
        var generator = new WeaponCodeGenerator();
        String code = generator.generate(Arrays.asList(weapons));
        System.out.println(code);
    }
}
