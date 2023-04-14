package jp.co.atguigu.model.dto;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import jp.co.atguigu.model.entity.Role;
import jp.co.atguigu.model.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ユーザのデータ転送クラス
 *
 * @author Administrator
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserDto extends User {

	private static final long serialVersionUID = 1558209198689461556L;

	@ApiModelProperty(value = "角色列表")
	private List<Role> roleList;

	@ApiModelProperty(value = "部門名稱")
	private String deptName;

	@ApiModelProperty(value = "職位名稱")
	private String postName;
}
