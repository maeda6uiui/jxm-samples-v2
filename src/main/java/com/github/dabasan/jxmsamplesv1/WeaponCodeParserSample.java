package com.github.dabasan.jxmsamplesv1;

import com.github.dabasan.jxm.properties.weapon.Weapon;
import com.github.dabasan.jxm.properties.weapon.openxops.WeaponCodeParser;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

/**
 * OpenXOPSのソースコードから武器情報を取得するサンプルコード
 *
 * @author Daba
 */
public class WeaponCodeParserSample {
    public static void main(String[] args) {
        // テキストファイルからOpenXOPSのソースコードを読み込む
        List<String> code;
        try {
            code = Files.readAllLines(Paths.get("./Data/weapon_code.txt"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // OpenXOPSのソースコードから武器情報を取得する
        var parser = new WeaponCodeParser();
        Map<Integer, Weapon> weapons = parser.parse(code);
        weapons.forEach((k, v) -> System.out.printf("%d: %s\n", k, v));
    }
}
