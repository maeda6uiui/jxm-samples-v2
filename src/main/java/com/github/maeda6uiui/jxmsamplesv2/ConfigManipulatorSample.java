package com.github.maeda6uiui.jxmsamplesv2;

import com.github.dabasan.jxm.properties.config.Config;
import com.github.dabasan.jxm.properties.config.ConfigManipulator;
import com.github.dabasan.jxm.properties.config.KeyCode;

import java.io.IOException;

/**
 * Code sample for ConfigManipulator
 *
 * @author maeda6uiui
 */
public class ConfigManipulatorSample {
    public static void main(String[] args) {
        //Load config.dat
        ConfigManipulator manipulator;
        try {
            manipulator = new ConfigManipulator("./Data/config.dat");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        //Print config
        Config config = manipulator.getConfig();
        System.out.println(config);

        //Change key for ZOOM
        config.zoom = KeyCode.KEY_MOUSE_R;
        //Change player name
        config.name = "TestPlayer";

        //Set config
        manipulator.setConfig(config);

        try {
            //Save config
            manipulator.saveAsDAT("./Data/config_2.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
