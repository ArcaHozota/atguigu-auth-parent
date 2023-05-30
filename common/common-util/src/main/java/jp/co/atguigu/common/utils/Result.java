package jp.co.atguigu.common.utils;

import lombok.Data;

/**
 * データ返却クラス
 *
 * @author Administrator
 * @param <T> ジェネリック
 */
@Data
public class Result<T> {

	/**
	 * ステータスコード
	 */
	private Integer code;

	/**
	 * メッセージ
	 */
	private String message;

	/**
	 * データ
	 */
	private T data;

	/**
	 * データを返却する
	 *
	 * @param <T>  ジェネリック
	 * @param data データ
	 * @return Result<T>
	 */
	private static <T> Result<T> build(final T data) {
		final Result<T> result = new Result<>();
		if (data != null) {
			result.setData(data);
		}
		return result;
	}

	/**
	 * 結果を返却する
	 *
	 * @param <T>     ジェネリック
	 * @param body    データ
	 * @param code    ステータス
	 * @param message メッセージ
	 * @return Result<T>
	 */
	private static <T> Result<T> build(final T body, final Integer code, final String message) {
		final Result<T> result = build(body);
		result.setCode(code);
		result.setMessage(message);
		return result;
	}

	/**
	 * 結果を返却する
	 *
	 * @param <T>            ジェネリック
	 * @param body           データ
	 * @param resultCodeEnum 返却コード
	 * @return Result<T>
	 */
	private static <T> Result<T> build(final T body, final ResultCodeEnum resultCodeEnum) {
		final Result<T> result = build(body);
		result.setCode(resultCodeEnum.getCode());
		result.setMessage(resultCodeEnum.getMessage());
		return result;
	}

	/**
	 * 成功した結果を返却する
	 *
	 * @param <T> ジェネリック
	 * @return Result<T>
	 */
	public static <T> Result<T> ok() {
		return Result.ok(null);
	}

	/**
	 * 成功した結果を返却する
	 *
	 * @param <T>  ジェネリック
	 * @param data データ
	 * @return Result<T>
	 */
	public static <T> Result<T> ok(final T data) {
		return build(data, ResultCodeEnum.SUCCESS);
	}

	/**
	 * 失敗した結果を返却する
	 *
	 * @param <T> ジェネリック
	 * @return Result<T>
	 */
	public static <T> Result<T> fail() {
		return Result.fail(null);
	}

	/**
	 * 失敗した結果を返却する
	 *
	 * @param <T>  ジェネリック
	 * @param data データ
	 * @return Result<T>
	 */
	public static <T> Result<T> fail(final T data) {
		return build(data, ResultCodeEnum.FAILURE);
	}

	/**
	 * メッセージを設定する
	 *
	 * @param msg メッセージ
	 * @return Result<T>
	 */
	public Result<T> message(final String msg) {
		this.setMessage(msg);
		return this;
	}

	/**
	 * ステータスコードを設定する
	 *
	 * @param code ステータスコード
	 * @return Result<T>
	 */
	public Result<T> code(final Integer code) {
		this.setCode(code);
		return this;
	}
}
