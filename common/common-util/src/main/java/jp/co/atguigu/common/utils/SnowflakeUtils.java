package jp.co.atguigu.common.utils;

import java.util.Random;

/**
 * 雪花算法ID生成工具類
 *
 * @author Administrator
 */
public final class SnowflakeUtils {

	/**
	 * 空參構造器
	 */
	private SnowflakeUtils() {
	}

	/**
	 * 獲取下一位雪花ID
	 *
	 * @return long ID
	 */
	public static long nextId() {
		final Random rd = new Random();
		final int nextInt1 = rd.nextInt(31);
		final int nextInt2 = rd.nextInt(31);
		return new SnowflakeIdGenerator(nextInt1, nextInt2).nextId();
	}
}
