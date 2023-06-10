package com.github.maeda6uiui.jxmsamplesv2;

import com.github.dabasan.jxm.bd1.BD1Block;
import com.github.dabasan.jxm.bd1.BD1Manipulator;
import org.joml.Matrix4f;

import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 * BD1Manipulatorを使用するサンプルコード
 *
 * @author maeda6uiui
 */
public class BD1ManipulatorSample {
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

        // Z軸反転 (鏡像マップの作成)
        manipulator.invertZ();

        // 行列を使用してマップを変形する
        // ここでは、Z軸回りの回転→X軸回りの回転
        var mat = new Matrix4f().rotateZ((float) Math.toRadians(45))
                .rotateX((float) Math.toRadians(45));
        manipulator.transform(mat);

        // マップに含まれる各ブロックを直接操作する
        var random = new Random();
        List<BD1Block> blocks = manipulator.getBlocks();
        for (var block : blocks) {
            // 各面のテクスチャIDを乱数で変更する
            int[] rands = new int[6];
            for (int i = 0; i < 6; i++) {
                rands[i] = random.nextInt(10);
            }

            block.textureIDs = rands;
        }

        try {
            // BD1形式で保存する
            manipulator.saveAsBD1("./Data/map_2.bd1");

            // OBJ形式で保存する
            manipulator.saveAsOBJ(
                    "./Data/map_2.obj",
                    "./Data/map_2.mtl",
                    "map_2.mtl",
                    true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
