package com.github.maeda6uiui.jxmsamplesv2;

import com.github.dabasan.jxm.properties.config.Config;
import com.github.dabasan.jxm.properties.config.ConfigManipulator;
import com.github.dabasan.jxm.properties.config.KeyCode;

import java.io.IOException;

/**
 * ConfigManipulatorを使用するサンプルコード
 *
 * @author maeda6uiui
 */
public class ConfigManipulatorSample {
    public static void main(String[] args) {
        // config.datを読み込む
        ConfigManipulator manipulator;
        try {
            manipulator = new ConfigManipulator("./Data/config.dat");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // configを取得する
        Config config = manipulator.getConfig();
        System.out.println(config);

        // ZOOMのキーを変更する
        config.zoom = KeyCode.KEY_MOUSE_R;
        // プレイヤー名を変更する
        config.name = "TestPlayer";

        // configを設定する
        manipulator.setConfig(config);

        try {
            // configを保存する
            manipulator.saveAsDAT("./Data/config_2.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
