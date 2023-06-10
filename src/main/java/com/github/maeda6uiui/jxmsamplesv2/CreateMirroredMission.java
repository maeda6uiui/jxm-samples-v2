package com.github.maeda6uiui.jxmsamplesv2;

import com.github.dabasan.jxm.bd1.BD1Manipulator;
import com.github.dabasan.jxm.pd1.PD1Manipulator;

import java.io.IOException;

/**
 * 鏡像ミッションを作成するコード
 *
 * @author maeda6uiui
 */
public class CreateMirroredMission {
    public static void main(String[] args) {
        // BD1ファイルとPD1ファイルを読み込む
        BD1Manipulator bd1Manipulator;
        PD1Manipulator pd1Manipulator;
        try {
            bd1Manipulator = new BD1Manipulator("./Data/map.bd1");
            pd1Manipulator = new PD1Manipulator("./Data/points.pd1");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Z軸を反転する
        bd1Manipulator.invertZ();
        pd1Manipulator.invertZ();

        try {
            // BD1とPD1を保存する
            bd1Manipulator.saveAsBD1("./Data/mirrored_map.bd1");
            pd1Manipulator.saveAsPD1("./Data/mirrored_points.pd1");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
