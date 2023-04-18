package jp.co.atguigu.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * メニューのエンティティクラス
 *
 * @author Administrator
 */
@ApiModel(description = "菜單表")
@Data
@EqualsAndHashCode(callSuper = false)
public class Menu extends BasicEntity {

	private static final long serialVersionUID = 4213114070542293563L;

	@ApiModelProperty(value = "所属上級")
	private Long parentId;

	@ApiModelProperty(value = "名稱")
	private String name;

	@ApiModelProperty(value = "類型(0:目錄，1:菜單，2:按鈕)")
	private Integer type;

	@ApiModelProperty(value = "路由地址")
	private String path;

	@ApiModelProperty(value = "組件路徑")
	private String component;

	@ApiModelProperty(value = "權限標志")
	private String perms;

	@ApiModelProperty(value = "圖標")
	private String icon;

	@ApiModelProperty(value = "排序")
	private Integer sort;

	@ApiModelProperty(value = "狀態(1:正常，0:停用)")
	private Integer status;
}
