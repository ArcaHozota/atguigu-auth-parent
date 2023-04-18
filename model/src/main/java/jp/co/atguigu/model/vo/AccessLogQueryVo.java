package jp.co.atguigu.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * アクセスログのクエリVO
 *
 * @author Administrator
 */
@Data
public class AccessLogQueryVo {

	@ApiModelProperty(value = "用戶賬號")
	private String username;

	/**
	 * 創建時間(開始)
	 */
	private String createTimeBegin;

	/**
	 * 創建時間(結束)
	 */
	private String createTimeEnd;
}
