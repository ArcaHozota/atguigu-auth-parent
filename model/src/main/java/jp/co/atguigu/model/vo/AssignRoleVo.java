package jp.co.atguigu.model.vo;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "分配角色")
@Data
public class AssignRoleVo {

	@ApiModelProperty(value = "用戶ID")
	private String userId;

	@ApiModelProperty(value = "角色ID列表")
	private List<String> roleIdList;
}
