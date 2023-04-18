package jp.co.atguigu.model.vo;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(description = "分配菜單")
@Data
public class AssignMenuVo {

	@ApiModelProperty(value = "角色ID")
	private String roleId;

	@ApiModelProperty(value = "菜單ID列表")
	private List<String> menuIdList;
}
