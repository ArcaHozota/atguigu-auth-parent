package jp.co.atguigu.model.vo;

import lombok.Data;

/**
 * 操作ログのクエリVO
 *
 * @author Administrator
 */
@Data
public class OperationLogQueryVo {

	/**
	 * 標題
	 */
	private String title;

	/**
	 * 操作名稱
	 */
	private String operationName;

	/**
	 * 創建時間(開始)
	 */
	private String createTimeBegin;

	/**
	 * 創建時間(結束)
	 */
	private String createTimeEnd;
}
