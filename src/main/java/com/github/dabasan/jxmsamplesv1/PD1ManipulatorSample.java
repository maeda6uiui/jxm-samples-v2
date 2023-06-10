package com.github.dabasan.jxmsamplesv1;

import com.github.dabasan.jxm.pd1.PD1Manipulator;
import com.github.dabasan.jxm.pd1.PD1Point;
import org.joml.Matrix4f;

import java.io.IOException;
import java.util.List;

/**
 * PD1Manipulatorを使用するサンプルコード
 *
 * @author Daba
 */
public class PD1ManipulatorSample {
    public static void main(String[] args) {
        // PD1ファイルを読み込む
        PD1Manipulator manipulator;
        try {
            manipulator = new PD1Manipulator("./Data/points.pd1");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // ポイントの数を取得する
        int numPoints = manipulator.getNumPoints();
        System.out.println(numPoints);

        // 人の数(第1パラメータが1か6のポイントの数)を取得する
        int numCharacters = manipulator.getNumPoints(0, 1) + manipulator.getNumPoints(0, 6);
        System.out.println(numCharacters);

        // ポイントを操作する
        // ここでは、移動→Y軸回りの回転→スケールの変更
        manipulator.translate(0.0f, 100.0f, 0.0f).rotY((float) Math.toRadians(45)).rescale(1.0f,
                2.0f, 1.0f);

        // ポイントの向きを回転させる
        manipulator.rotateDirection((float) Math.toRadians(45));

        // Z軸反転(鏡像ミッションの作成)
        manipulator.invertZ();

        // 行列を使用してポイントを変形する
        // ここでは、Z軸回りの回転→X軸回りの回転
        var mat = new Matrix4f().rotateZ((float) Math.toRadians(45))
                .rotateX((float) Math.toRadians(45));
        manipulator.transform(mat);

        // 各ポイントを直接操作する
        List<PD1Point> points = manipulator.getPoints();
        for (var point : points) {
            // 武器のポイントだけ45度回転させる
            if (point.parameters[0] == 2) {
                float rotAngle = point.rotation;
                rotAngle += (float) Math.toRadians(45);
                point.rotation = rotAngle;
            }
        }

        // PD1形式で保存する
        manipulator.saveAsPD1("./Data/points_2.pd1");
    }
}
