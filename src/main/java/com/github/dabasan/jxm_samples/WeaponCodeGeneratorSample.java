package com.github.dabasan.jxm_samples;

import java.io.IOException;
import java.util.Arrays;

import com.github.dabasan.jxm.properties.weapon.Weapon;
import com.github.dabasan.jxm.properties.weapon.openxops.WeaponCodeGenerator;
import com.github.dabasan.jxm.properties.xops.EXEManipulator;

/**
 * 武器情報をOpenXOPSのソースコード形式で出力するサンプルコード<br>
 * XOPSの実行ファイルから読み込んだ武器情報をOpenXOPSのソースコード形式で出力する。
 * 
 * @author Daba
 *
 */
public class WeaponCodeGeneratorSample {
	public static void main(String[] args) {
		// XOPSの実行ファイルから武器情報を読み込む
		EXEManipulator manipulator;
		try {
			manipulator = new EXEManipulator("./Data/xops0975t.exe");
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		Weapon[] weapons = manipulator.getWeapons();

		// OpenXOPSのソースコードを出力する
		var generator = new WeaponCodeGenerator();
		String code = generator.generate(Arrays.asList(weapons));
		System.out.println(code);
	}
}
