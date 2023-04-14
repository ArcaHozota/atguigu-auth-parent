package jp.co.atguigu.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jp.co.atguigu.model.common.BasicEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 役員のエンティティクラス
 *
 * @author Administrator
 */
@ApiModel(description = "職位信息表")
@Data
@EqualsAndHashCode(callSuper = false)
public class Position extends BasicEntity {

	private static final long serialVersionUID = 3341461822354253018L;

	@ApiModelProperty(value = "職位編碼")
	private String postCode;

	@ApiModelProperty(value = "職位名稱")
	private String name;

	@ApiModelProperty(value = "描述")
	private String description;

	@ApiModelProperty(value = "狀態碼(1:正常，0:停用)")
	private Integer status;
}