package jp.co.atguigu.common.utils;

import java.util.Random;

/**
 * 雪花のアルゴリズムID生成ツール
 *
 * @author Administrator
 */
public final class SnowflakeUtils {

	/**
	 * コンストラクタ
	 */
	private SnowflakeUtils() {
	}

	/**
	 * 次の雪花アルゴリズムIDを取得
	 *
	 * @return long ID
	 */
	protected static long nextId() {
		final Random rd = new Random();
		final int nextInt1 = rd.nextInt(31);
		final int nextInt2 = rd.nextInt(31);
		return new SnowflakeIdGenerator(nextInt1, nextInt2).nextId();
	}
}
