package jp.co.atguigu.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 役員のクエリVO
 *
 * @author Administrator
 */
@ApiModel(description = "職位信息查詢")
@Data
public class PostQueryVo {

	@ApiModelProperty(value = "職位編碼")
	private String postCode;

	@ApiModelProperty(value = "職位名稱")
	private String name;

	@ApiModelProperty(value = "狀態碼(1:正常，0:停用)")
	private Boolean status;
}
