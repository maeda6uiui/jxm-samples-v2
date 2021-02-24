package com.github.dabasan.jxm_samples;

import com.github.dabasan.jxm.properties.weapon.Weapon;
import com.github.dabasan.jxm.properties.weapon.ids.IDSManipulator;

import java.io.IOException;

/**
 * IDSManipulatorを使用するサンプルコード
 *
 * @author Daba
 */
public class IDSManipulatorSample {
    public static void main(String[] args) {
        // IDSファイルを読み込む
        IDSManipulator manipulator;
        try {
            manipulator = new IDSManipulator("./Data/mp5.ids");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // 武器情報を取得する
        Weapon weapon = manipulator.getWeapon();
        System.out.println(weapon);

        // 武器名を変更する
        weapon.name = "Test";
        // 攻撃力を変更する
        weapon.attacks = 100;

        // 武器情報を設定する
        manipulator.setWeapon(weapon);

        // IDSファイルを保存する
        manipulator.saveAsIDS("./Data/test.ids");
    }
}
