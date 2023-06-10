package com.github.maeda6uiui.jxmsamplesv2;

import com.github.dabasan.jxm.properties.character.Character;
import com.github.dabasan.jxm.properties.weapon.Weapon;
import com.github.dabasan.jxm.properties.xops.EXEManipulator;

import java.io.IOException;
import java.util.Arrays;

/**
 * XOPSの実行ファイルから武器情報・キャラクター情報を取得するサンプルコード
 *
 * @author maeda6uiui
 */
public class EXEManipulatorSample {
    public static void main(String[] args) {
        // XOPSの実行ファイルを開く
        EXEManipulator manipulator;
        try {
            manipulator = new EXEManipulator("./Data/xops0975t.exe");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // 武器情報を取得する
        Weapon[] weapons = manipulator.getWeapons();
        Arrays.asList(weapons).forEach(w -> System.out.println(w));

        // キャラクター情報を取得する
        Character[] characters = manipulator.getCharacters();
        Arrays.asList(characters).forEach(c -> System.out.println(c));

        try {
            // 武器情報とキャラクター情報を実行ファイルに上書きする
            // 第2引数にnull以外の値を指定すると、上書きする前にバックアップを作成する
            manipulator.write("./Data/xops0975t.exe", "./Data/xops0975t_backup.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
