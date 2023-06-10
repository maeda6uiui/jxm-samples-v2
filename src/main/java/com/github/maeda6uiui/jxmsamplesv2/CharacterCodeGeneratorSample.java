package com.github.maeda6uiui.jxmsamplesv2;

import com.github.dabasan.jxm.properties.character.Character;
import com.github.dabasan.jxm.properties.character.openxops.CharacterCodeGenerator;
import com.github.dabasan.jxm.properties.xops.EXEManipulator;

import java.io.IOException;
import java.util.Arrays;

/**
 * キャラクター情報をOpenXOPSのソースコード形式で出力するサンプルコード<br>
 * XOPSの実行ファイルから読み込んだキャラクター情報をOpenXOPSのソースコード形式で出力する。
 *
 * @author maeda6uiui
 */
public class CharacterCodeGeneratorSample {
    public static void main(String[] args) {
        // XOPSの実行ファイルからキャラクター情報を読み込む
        EXEManipulator manipulator;
        try {
            manipulator = new EXEManipulator("./Data/xops0975t.exe");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Character[] characters = manipulator.getCharacters();

        // OpenXOPSのソースコードを出力する
        var generator = new CharacterCodeGenerator();
        String code = generator.generate(Arrays.asList(characters));
        System.out.println(code);
    }
}
