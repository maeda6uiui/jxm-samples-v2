package com.github.maeda6uiui.jxmsamplesv2;

import com.github.dabasan.jxm.bd1.BD1Block;
import com.github.dabasan.jxm.bd1.BD1Manipulator;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Collects blocks that have specified texture ID and save it as BD1
 *
 * @author maeda6uiui
 */
public class CollectBlocksWithSpecifiedTextureID {
    public static void main(String[] args) {
        //Load BD1 file
        BD1Manipulator manipulator;
        try {
            manipulator = new BD1Manipulator("./Data/map.bd1");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        //Collect blocks that have specified texture ID
        final int COLLECTED_TEXTURE_ID = 1;

        var blocks = new ArrayList<BD1Block>();
        manipulator.getBlocks().forEach(b -> {
            for (int textureID : b.textureIDs) {
                if (textureID == COLLECTED_TEXTURE_ID) {
                    blocks.add(b);
                    break;
                }
            }
        });

        manipulator.setBlocks(blocks);

        try {
            //Save as BD1
            manipulator.saveAsBD1("./Data/map_2.bd1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
