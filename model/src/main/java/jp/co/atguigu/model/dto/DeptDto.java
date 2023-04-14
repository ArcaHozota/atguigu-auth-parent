package jp.co.atguigu.model.dto;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import jp.co.atguigu.model.entity.Department;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * デパートメントのデータ転送クラス
 *
 * @author Administrator
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DeptDto extends Department {

	private static final long serialVersionUID = 6692981838430743791L;

	@ApiModelProperty(value = "下級部門")
	private List<Department> children;
}
