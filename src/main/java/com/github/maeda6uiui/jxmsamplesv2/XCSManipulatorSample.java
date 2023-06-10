package com.github.maeda6uiui.jxmsamplesv2;

import com.github.dabasan.jxm.properties.character.Character;
import com.github.dabasan.jxm.properties.character.xcs.XCSManipulator;

import java.io.IOException;
import java.util.Arrays;

/**
 * XCSManipulatorを使用するサンプルコード
 *
 * @author maeda6uiui
 */
public class XCSManipulatorSample {
    public static void main(String[] args) {
        // XCSファイルを読み込む
        XCSManipulator manipulator;
        try {
            manipulator = new XCSManipulator("./Data/characters.xcs");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // キャラクター情報を取得する
        Character[] characters = manipulator.getCharacters();
        Arrays.asList(characters).forEach(c -> System.out.println(c));

        // キャラクターの体力をすべて500にする
        for (var character : characters) {
            character.hp = 500;
        }

        // キャラクター情報を設定する
        manipulator.setCharacters(characters);

        try {
            // XCSファイルを保存する
            manipulator.saveAsXCS("./Data/characters_2.xcs");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
