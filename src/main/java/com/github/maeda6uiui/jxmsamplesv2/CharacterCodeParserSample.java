package com.github.maeda6uiui.jxmsamplesv2;

import com.github.dabasan.jxm.properties.character.Character;
import com.github.dabasan.jxm.properties.character.openxops.CharacterCodeParser;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

/**
 * OpenXOPSのソースコードからキャラクター情報を取得するサンプルコード
 *
 * @author maeda6uiui
 */
public class CharacterCodeParserSample {
    public static void main(String[] args) {
        // テキストファイルからOpenXOPSのソースコードを読み込む
        List<String> code;
        try {
            code = Files.readAllLines(Paths.get("./Data/character_code.txt"),
                    StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // OpenXOPSのソースコードからキャラクター情報を取得する
        var parser = new CharacterCodeParser();
        Map<Integer, Character> characters = parser.parse(code);
        characters.forEach((k, v) -> System.out.printf("%d: %s\n", k, v));
    }
}
