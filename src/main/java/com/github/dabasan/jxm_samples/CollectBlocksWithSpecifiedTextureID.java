package com.github.dabasan.jxm_samples;

import com.github.dabasan.jxm.bd1.BD1Block;
import com.github.dabasan.jxm.bd1.BD1Manipulator;

import java.io.IOException;
import java.util.ArrayList;

/**
 * 指定されたテクスチャIDの面を含むブロックのみを収集し、新たなBD1データとして保存します。
 *
 * @author Daba
 */
public class CollectBlocksWithSpecifiedTextureID {
    public static void main(String[] args) {
        //BD1ファイルを読み込む
        BD1Manipulator manipulator;
        try {
            manipulator = new BD1Manipulator("./Data/map.bd1");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        //特定のテクスチャIDの面を含むブロックのみを収集する
        final int COLLECT_TEXTURE_ID = 1;

        var blocks = new ArrayList<BD1Block>();
        manipulator.getBlocks().forEach(b -> {
            for (int textureID : b.textureIDs) {
                if (textureID == COLLECT_TEXTURE_ID) {
                    blocks.add(b);
                    break;
                }
            }
        });

        manipulator.setBlocks(blocks);

        //BD1形式で保存する
        manipulator.saveAsBD1("./Data/map_2.bd1");
    }
}
