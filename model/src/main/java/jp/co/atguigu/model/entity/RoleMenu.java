package jp.co.atguigu.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jp.co.atguigu.model.common.BasicEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ロールとメニューの関係エンティティクラス
 *
 * @author Administrator
 */
@ApiModel(description = "角色菜單表")
@Data
@EqualsAndHashCode(callSuper = false)
public class RoleMenu extends BasicEntity {

	private static final long serialVersionUID = -8563489868018023532L;

	@ApiModelProperty(value = "角色ID")
	private String roleId;

	@ApiModelProperty(value = "菜單ID")
	private String menuId;
}
