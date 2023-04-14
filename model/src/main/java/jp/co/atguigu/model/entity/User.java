package jp.co.atguigu.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jp.co.atguigu.model.common.BasicEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ユーザのエンティティクラス
 *
 * @author Administrator
 */
@ApiModel(description = "用戶表")
@Data
@EqualsAndHashCode(callSuper = false)
public class User extends BasicEntity {

	private static final long serialVersionUID = 5512459853537684259L;

	@ApiModelProperty(value = "用戶名稱")
	private String username;

	@ApiModelProperty(value = "密碼")
	private String password;

	@ApiModelProperty(value = "姓名")
	private String name;

	@ApiModelProperty(value = "電話號碼")
	private String phone;

	@ApiModelProperty(value = "頭像地址")
	private String headUrl;

	@ApiModelProperty(value = "部門ID")
	private Long deptId;

	@ApiModelProperty(value = "職位ID")
	private Long postId;

	@ApiModelProperty(value = "描述")
	private String description;

	@ApiModelProperty(value = "狀態碼(1:正常，0:停用)")
	private Integer status;
}
