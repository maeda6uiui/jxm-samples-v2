package com.github.maeda6uiui.jxmsamplesv2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.dabasan.jxm.properties.weapon.Weapon;
import com.github.dabasan.jxm.properties.weapon.xgs.XGSManipulator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 武器情報をJSON形式で出力するサンプル
 *
 * @author maeda6uiui
 */
public class OutputWeaponDataAsJSON {
    public static void main(String[] args) {
        XGSManipulator manipulator;
        try {
            manipulator = new XGSManipulator("./Data/weapons.xgs");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Weapon[] weapons = manipulator.getWeapons();

        try {
            //JSON形式で出力する
            var mapper = new ObjectMapper();
            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(weapons);
            Files.writeString(Paths.get("./Data/weapons.json"), json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
