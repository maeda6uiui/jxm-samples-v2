package com.github.maeda6uiui.jxmsamplesv2;

import com.github.dabasan.jxm.mif.MIFManipulator;
import com.github.dabasan.jxm.mif.MissionInfo;

import java.io.IOException;

/**
 * Code sample for MIFManipulator
 *
 * @author maeda6uiui
 */
public class MIFManipulatorSample {
    public static void main(String[] args) {
        //Load MIF file
        MIFManipulator manipulator;
        try {
            manipulator = new MIFManipulator("./Data/test.mif", "Shift-JIS");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        //Print mission info
        MissionInfo missionInfo = manipulator.getMissionInfo();
        System.out.println(missionInfo);

        //Change mission title
        missionInfo.missionTitle = "Mission Title";
        //Change filepath of map
        missionInfo.pathnameOfBlock = "./addon/test/map.bd1";

        //Set mission info
        manipulator.setMissionInfo(missionInfo);

        try {
            //Save as MIF
            manipulator.saveAsMIF("./Data/test_2.mif", "Shift-JIS");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
