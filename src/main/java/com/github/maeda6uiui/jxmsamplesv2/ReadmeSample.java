package com.github.maeda6uiui.jxmsamplesv2;

import com.github.dabasan.jxm.bd1.BD1Manipulator;

import java.io.IOException;

/**
 * Readme code sample for the JXM repo
 *
 * @author maeda6uiui
 */
public class ReadmeSample {
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
        //The operation order here is:
        //Rescaling -> Rotation around the Y-axis -> Translation
        manipulator
                .translate(0.0f, 100.0f, 0.0f)
                .rotY((float) Math.toRadians(45))
                .rescale(1.0f, 2.0f, 1.0f)
                .applyTransformation();

        //Invert z-axis (create mirrored map)
        manipulator.invertZ();

        try {
            //Save as BD1
            manipulator.saveAsBD1("./Data/map2.bd1");

            //Save as OBJ
            manipulator.saveAsOBJ(
                    "./Data/map2.obj",
                    "./Data/map2.mtl",
                    "map2.mtl",
                    true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
