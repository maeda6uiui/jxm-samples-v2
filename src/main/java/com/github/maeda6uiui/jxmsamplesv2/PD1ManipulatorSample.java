package com.github.maeda6uiui.jxmsamplesv2;

import com.github.dabasan.jxm.pd1.PD1Manipulator;
import org.joml.Matrix4f;

import java.io.IOException;

/**
 * Code sample for PD1Manipulator
 *
 * @author maeda6uiui
 */
public class PD1ManipulatorSample {
    public static void main(String[] args) {
        //Load PD1 file
        PD1Manipulator manipulator;
        try {
            manipulator = new PD1Manipulator("./Data/points.pd1");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        //Get the number of points
        int numPoints = manipulator.getNumPoints();
        System.out.println(numPoints);

        //Get the number of characters (the number of points whose first parameter is 6)
        int numCharacters = manipulator.getNumPoints(0, 1) + manipulator.getNumPoints(0, 6);
        System.out.println(numCharacters);

        //Transform the points
        //The operation order is
        //rescaling -> rotation around the y-axis -> translation
        manipulator
                .translate(0.0f, 100.0f, 0.0f)
                .rotY((float) Math.toRadians(45))
                .rescale(1.0f, 2.0f, 1.0f)
                .applyTransformation();

        //Rotate the direction of points
        manipulator.rotateDirection((float) Math.toRadians(45));

        //Invert z-axis (create mirrored mission)
        manipulator.invertZ();

        //Transform the points with a matrix
        //The operation order is
        //rotation around the x-axis -> rotation around the z-axis
        var mat = new Matrix4f()
                .rotateZ((float) Math.toRadians(45))
                .rotateX((float) Math.toRadians(45));
        manipulator.transform(mat).applyTransformation();

        //Example of direct manipulation of points
        manipulator.getPoints().forEach(point -> {
            //Rotate weapon points by 45 degrees
            if (point.parameters[0] == 2) {
                float rotAngle = point.rotation;
                rotAngle += (float) Math.toRadians(45);
                point.rotation = rotAngle;
            }
        });

        try {
            //Save as PD1
            manipulator.saveAsPD1("./Data/points_2.pd1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
