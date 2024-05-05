package com.github.maeda6uiui.jxmsamplesv2;

import com.github.dabasan.jxm.bd1.BD1Manipulator;
import com.github.dabasan.jxm.pd1.PD1Manipulator;

import java.io.IOException;

/**
 * Creates mirrored mission
 *
 * @author maeda6uiui
 */
public class CreateMirroredMission {
    public static void main(String[] args) {
        //Load BD1 and PD1 files
        BD1Manipulator bd1Manipulator;
        PD1Manipulator pd1Manipulator;
        try {
            bd1Manipulator = new BD1Manipulator("./Data/map.bd1");
            pd1Manipulator = new PD1Manipulator("./Data/points.pd1");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        //Invert z-axis
        bd1Manipulator.invertZ();
        pd1Manipulator.invertZ();

        try {
            //Save BD1 and PD1
            bd1Manipulator.saveAsBD1("./Data/mirrored_map.bd1");
            pd1Manipulator.saveAsPD1("./Data/mirrored_points.pd1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
