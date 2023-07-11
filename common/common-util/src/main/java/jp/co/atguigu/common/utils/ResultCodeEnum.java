package jp.co.atguigu.common.utils;

import lombok.Getter;

/**
 * データ返却列挙型クラス
 *
 * @author Administrator
 */
@Getter
public enum ResultCodeEnum {

	/**
	 * 成功
	 */
	SUCCESS(200, "成功"),

	/**
	 * 失敗
	 */
	FAILURE(201, "失敗"),

	/**
	 * サービスエラー
	 */
	SERVICE_ERROR(2012, "サービスエラー"),

	/**
	 * データエラー
	 */
	DATA_ERROR(204, "データエラー"),

	/**
	 * 違法的なリクエスト
	 */
	ILLEGAL_REQUEST(205, "違法的なリクエスト"),

	/**
	 * 重複的な送信
	 */
	REPEAT_SUBMIT(206, "重複的な送信"),

	/**
	 * 引数の検証エラー
	 */
	ARGUMENT_VALID_ERROR(210, "引数の検証エラー"),

	/**
	 * 登録しません
	 */
	LOGIN_AUTH(208, "登録しません"),

	/**
	 * 権限はなし
	 */
	PERMISSION(209, "権限はなし"),

	/**
	 * アカウントエラー
	 */
	ACCOUNT_ERROR(214, "アカウントエラー"),

	/**
	 * パスワードエラー
	 */
	PASSWORD_ERROR(215, "パスワードエラー"),

	/**
	 * 登録できません
	 */
	LOGIN_MOBILE_ERROR(216, "登録できません"),

	/**
	 * アカウントは廃止された
	 */
	ACCOUNT_STOP(217, "アカウントは廃止されました"),

	/**
	 * ノードエラー
	 */
	NODE_ERROR(218, "ノードエラー");

	/**
	 * ステータスコード
	 */
	private final Integer code;

	/**
	 * メッセージ
	 */
	private final String message;

	/**
	 * コンストラクタ
	 *
	 * @param code    ステータスコード
	 * @param message メッセージ
	 */
	ResultCodeEnum(final Integer code, final String message) {
		this.code = code;
		this.message = message;
	}
}
