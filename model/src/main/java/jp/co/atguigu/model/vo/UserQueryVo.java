package jp.co.atguigu.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * ユーザのクエリVO
 *
 * @author Administrator
 */
@ApiModel(description = "用戶信息查詢")
@Data
public class UserQueryVo {

	@ApiModelProperty(value = "檢索文")
	private String keyword;

	@ApiModelProperty(value = "創建時間·始")
	private String createTimeBegin;

	@ApiModelProperty(value = "創建時間·終")
	private String createTimeEnd;

	@ApiModelProperty(value = "角色名稱")
	private Long roleId;

	@ApiModelProperty(value = "角色名稱")
	private Long postId;

	@ApiModelProperty(value = "角色名稱")
	private Long deptId;
}
