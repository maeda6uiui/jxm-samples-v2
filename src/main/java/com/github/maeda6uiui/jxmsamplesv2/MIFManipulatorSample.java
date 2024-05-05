package com.github.maeda6uiui.jxmsamplesv2;

import com.github.dabasan.jxm.mif.MIFManipulator;
import com.github.dabasan.jxm.mif.MissionInfo;

import java.io.IOException;

/**
 * MIFManipulatorを使用するサンプルコード
 *
 * @author maeda6uiui
 */
public class MIFManipulatorSample {
    public static void main(String[] args) {
        //MIFファイルを読み込む
        MIFManipulator manipulator;
        try {
            manipulator = new MIFManipulator("./Data/test.mif", "Shift-JIS");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        //ミッション情報を取得する
        MissionInfo missionInfo = manipulator.getMissionInfo();
        System.out.println(missionInfo);

        //ミッションのタイトルを変更する
        missionInfo.missionTitle = "Mission Title";
        //マップのファイルパスを変更する
        missionInfo.pathnameOfBlock = "./addon/test/map.bd1";

        //ミッション情報を設定する
        manipulator.setMissionInfo(missionInfo);

        try {
            //MIFファイルを保存する
            manipulator.saveAsMIF("./Data/test_2.mif", "Shift-JIS");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
