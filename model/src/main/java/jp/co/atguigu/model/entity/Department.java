package jp.co.atguigu.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jp.co.atguigu.model.common.BasicEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * デパートメントのエンティティクラス
 *
 * @author Administrator
 */
@ApiModel(description = "部門表")
@Data
@EqualsAndHashCode(callSuper = false)
public class Department extends BasicEntity {

	private static final long serialVersionUID = 6534138851895742971L;

	@ApiModelProperty(value = "部門名稱")
	private String name;

	@ApiModelProperty(value = "上級部門ID")
	private Long parentId;

	@ApiModelProperty(value = "樹結構")
	private String treePath;

	@ApiModelProperty(value = "排序")
	private Integer sort;

	@ApiModelProperty(value = "責任人")
	private String leader;

	@ApiModelProperty(value = "電話號碼")
	private String phoneNo;

	@ApiModelProperty(value = "狀態(1:正常，0:停用)")
	private Integer status;
}
