package jp.co.atguigu.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ロール授権のエンティティクラス
 *
 * @author Administrator
 */
@ApiModel(description = "角色表")
@Data
@EqualsAndHashCode(callSuper = false)
public class Role extends BasicEntity {

	private static final long serialVersionUID = -4956508735622486839L;

	@ApiModelProperty(value = "角色名稱")
	private String roleName;

	@ApiModelProperty(value = "角色編碼")
	private String roleCd;

	@ApiModelProperty(value = "描述")
	private String description;
}
