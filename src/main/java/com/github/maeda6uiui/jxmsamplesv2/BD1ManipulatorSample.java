package com.github.maeda6uiui.jxmsamplesv2;

import com.github.dabasan.jxm.bd1.BD1Manipulator;
import org.joml.Matrix4f;

import java.io.IOException;
import java.util.Random;

/**
 * Code sample for BD1Manipulator
 *
 * @author maeda6uiui
 */
public class BD1ManipulatorSample {
    public static void main(String[] args) {
        //Load BD1 file
        BD1Manipulator manipulator;
        try {
            manipulator = new BD1Manipulator("./Data/map.bd1");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        //Get the number of blocks
        int numBlocks = manipulator.getNumBlocks();
        System.out.println(numBlocks);

        //Get all filenames of the textures
        manipulator.getTextureFilenames().forEach((k, v) -> System.out.printf("%d: %s\n", k, v));

        //Change texture filenames
        manipulator.setTextureFilename(0, "test.bmp");
        manipulator.setTextureFilename(1, "test_2.bmp");

        //Transform the map
        //The operation order is
        //rescaling -> rotation around the y-axis -> translation
        manipulator
                .translate(0.0f, 100.0f, 0.0f)
                .rotY((float) Math.toRadians(45))
                .rescale(1.0f, 2.0f, 1.0f)
                .applyTransformation();

        //Invert z-axis (create mirrored map)
        manipulator.invertZ();

        //Transform the map with a matrix
        //The operation order is
        //rotation around the x-axis -> rotation around the z-axis
        var mat = new Matrix4f()
                .rotateZ((float) Math.toRadians(45))
                .rotateX((float) Math.toRadians(45));
        manipulator.transform(mat).applyTransformation();

        //Example of direct manipulation of blocks
        var random = new Random();
        manipulator.getBlocks().forEach(block -> {
            //Change texture ID of each face with a random number
            int[] rands = new int[6];
            for (int i = 0; i < 6; i++) {
                rands[i] = random.nextInt(10);
            }

            block.setTextureIDs(rands);
        });

        try {
            //Save as BD1
            manipulator.saveAsBD1("./Data/map_2.bd1");

            //Save as OBJ
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
