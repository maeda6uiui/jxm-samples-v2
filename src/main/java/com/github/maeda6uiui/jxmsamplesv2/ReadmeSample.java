package com.github.maeda6uiui.jxmsamplesv2;

import com.github.dabasan.jxm.bd1.BD1Manipulator;

import java.io.IOException;

/**
 * JXMのReadmeに掲載するサンプルコード
 *
 * @author maeda6uiui
 */
public class ReadmeSample {
    public static void main(String[] args) {
        // BD1ファイルを読み込む
        BD1Manipulator manipulator;
        try {
            manipulator = new BD1Manipulator("./Data/map.bd1");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // ブロックの数を取得する
        int numBlocks = manipulator.getNumBlocks();
        System.out.println(numBlocks);

        // テクスチャのファイル名をすべて取得する
        manipulator.getTextureFilenames().forEach((k, v) -> System.out.printf("%d: %s\n", k, v));

        // テクスチャのファイル名を変更する
        manipulator.setTextureFilename(0, "test.bmp");
        manipulator.setTextureFilename(1, "test_2.bmp");

        // マップを操作する
        // ここでは、移動→Y軸回りの回転→スケールの変更
        manipulator
                .translate(0.0f, 100.0f, 0.0f)
                .rotY((float) Math.toRadians(45))
                .rescale(1.0f, 2.0f, 1.0f);

        // Z軸反転(鏡像マップの作成)
        manipulator.invertZ();

        try {
            // BD1形式で保存する
            manipulator.saveAsBD1("./Data/map2.bd1");

            // OBJ形式で保存する
            manipulator.saveAsOBJ(
                    "./Data/map2.obj",
                    "./Data/map2.mtl",
                    "map2.mtl",
                    true);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
