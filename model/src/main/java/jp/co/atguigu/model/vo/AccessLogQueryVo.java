package jp.co.atguigu.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * アクセスログのクエリVO
 *
 * @author Administrator
 */
@ApiModel(description = "系統訪問日志查詢")
@Data
public class AccessLogQueryVo {

	@ApiModelProperty(value = "用戶賬號")
	private String username;

	@ApiModelProperty(value = "創建時間·始")
	private String createTimeBegin;

	@ApiModelProperty(value = "創建時間·終")
	private String createTimeEnd;
}
