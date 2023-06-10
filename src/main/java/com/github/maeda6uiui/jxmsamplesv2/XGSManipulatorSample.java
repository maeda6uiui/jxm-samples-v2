package com.github.maeda6uiui.jxmsamplesv2;

import com.github.dabasan.jxm.properties.weapon.Weapon;
import com.github.dabasan.jxm.properties.weapon.xgs.XGSManipulator;

import java.io.IOException;
import java.util.Arrays;

/**
 * XGSManipulatorを使用するサンプルコード
 *
 * @author maeda6uiui
 */
public class XGSManipulatorSample {
    public static void main(String[] args) {
        // XGSファイルを読み込む
        XGSManipulator manipulator;
        try {
            manipulator = new XGSManipulator("./Data/weapons.xgs");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // 武器情報を取得する
        Weapon[] weapons = manipulator.getWeapons();
        Arrays.asList(weapons).forEach(w -> System.out.println(w));

        // 武器名を変更する
        for (int i = 0; i < weapons.length; i++) {
            weapons[i].name = String.valueOf(i);
        }

        // 武器情報を設定する
        manipulator.setWeapons(weapons);

        try {
            // XGSファイルを保存する
            manipulator.saveAsXGS("./Data/weapons_2.xgs");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
