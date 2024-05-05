package com.github.maeda6uiui.jxmsamplesv2;

import com.github.dabasan.jxm.properties.weapon.Weapon;
import com.github.dabasan.jxm.properties.weapon.openxops.WeaponCodeParser;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

/**
 * Parses weapon data from OpenXOPS source code
 *
 * @author maeda6uiui
 */
public class WeaponCodeParserSample {
    public static void main(String[] args) {
        //Load OpenXOPS source code from text file
        List<String> code;
        try {
            code = Files.readAllLines(Paths.get("./Data/weapon_code.txt"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        
        //Parse OpenXOPS source code and get weapon data
        var parser = new WeaponCodeParser();
        Map<Integer, Weapon> weapons = parser.parse(code);
        weapons.forEach((k, v) -> System.out.printf("%d: %s\n", k, v));
    }
}
