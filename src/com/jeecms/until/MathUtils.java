package com.jeecms.until;

public class MathUtils {

	/*
	 * 方法1 (数据类型)(最小值+Math.random()*(最大值-最小值+1))
	 */
	public static int getRandom(int max, int min) {

		return (int) (min + Math.random() * (max - min + 1));

	}
	public static void main(String[] args) {
		int temp = getRandom(10000, 99999);
		System.out.println(temp);
	}
}
