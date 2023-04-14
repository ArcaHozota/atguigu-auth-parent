package jp.co.atguigu.model.dto;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import jp.co.atguigu.model.entity.Menu;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * メニューのデータ転送クラス
 *
 * @author Administrator
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MenuDto extends Menu {

	private static final long serialVersionUID = 7421932204386651815L;

	@ApiModelProperty(value = "下級菜單")
	private List<Menu> children;

	@ApiModelProperty(value = "是否被勾選")
	private Boolean isSelected;
}
