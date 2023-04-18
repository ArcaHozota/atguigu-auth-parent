package jp.co.atguigu.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ユーザとロールの関係エンティティクラス
 *
 * @author Administrator
 */
@ApiModel(description = "用戶角色表")
@Data
@EqualsAndHashCode(callSuper = false)
public class UserRole extends BasicEntity {

	private static final long serialVersionUID = 1522160321056129746L;

	@ApiModelProperty(value = "角色ID")
	private String roleId;

	@ApiModelProperty(value = "用戶ID")
	private String userId;
}
