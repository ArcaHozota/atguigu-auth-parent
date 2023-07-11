package jp.co.atguigu.common.constants;

/**
 * プロジェクトのコンスタント定義クラス
 *
 * @author Administrator
 */
public final class Constants {

	private Constants() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * 論理削除初期値
	 */
	public static final String LOGIC_DELETE_INITIAL = "visible";

	/**
	 * 論理削除フラグ
	 */
	public static final String LOGIC_DELETE_FLG = "removed";
}
