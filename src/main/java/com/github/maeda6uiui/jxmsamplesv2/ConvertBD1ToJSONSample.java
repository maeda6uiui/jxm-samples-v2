package com.github.maeda6uiui.jxmsamplesv2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.dabasan.jxm.bd1.BD1Block;
import com.github.dabasan.jxm.bd1.BD1Manipulator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * BD1形式をJSON形式に変換するサンプル
 *
 * @author maeda6uiui
 */
public class ConvertBD1ToJSONSample {
    public static void main(String[] args) {
        BD1Manipulator manipulator;
        try {
            manipulator = new BD1Manipulator("./Data/map.bd1");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        List<BD1Block> blocks = manipulator.getBlocks();

        try {
            //JSON形式で出力する
            var mapper = new ObjectMapper();
            String json = mapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(blocks);
            Files.writeString(Paths.get("./Data/map.json"), json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
