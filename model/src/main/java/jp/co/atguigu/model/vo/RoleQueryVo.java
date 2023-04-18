//
//
package jp.co.atguigu.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * ロールのクエリVO
 *
 * @author Administrator
 */
@ApiModel(description = "角色信息查詢")
@Data
public class RoleQueryVo {

	@ApiModelProperty(value = "角色名稱")
	private String roleName;
}
