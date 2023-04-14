package jp.co.atguigu.model.entity;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jp.co.atguigu.model.common.BasicEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * アクセスログのエンティティクラス
 *
 * @author Administrator
 */
@ApiModel(description = "系統訪問日志")
@Data
@EqualsAndHashCode(callSuper = false)
public class AccessLog extends BasicEntity {

	private static final long serialVersionUID = -8186965263822353193L;

	@ApiModelProperty(value = "用戶賬號")
	private String username;

	@ApiModelProperty(value = "登錄IP")
	private String ipAddress;

	@ApiModelProperty(value = "登錄狀態")
	private Integer status;

	@ApiModelProperty(value = "提示信息")
	private String tips;

	@ApiModelProperty(value = "最近訪問時間")
	private Date latestAccessTime;
}