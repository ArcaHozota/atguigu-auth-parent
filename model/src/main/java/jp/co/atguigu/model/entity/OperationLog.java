package jp.co.atguigu.model.entity;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jp.co.atguigu.model.common.BasicEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 操作ログのエンティティクラス
 *
 * @author Administrator
 */
@ApiModel(description = "操作日志")
@Data
@EqualsAndHashCode(callSuper = false)
public class OperationLog extends BasicEntity {

	private static final long serialVersionUID = -1259606394324810374L;

	@ApiModelProperty(value = "模塊標題")
	private String title;

	@ApiModelProperty(value = "業務類型(0:其它，1:新增，2:修改，3:刪除)")
	private String businessType;

	@ApiModelProperty(value = "方法名")
	private String method;

	@ApiModelProperty(value = "請求方式")
	private String requestMethod;

	@ApiModelProperty(value = "操作類別(0:其它，1:桌面端用戶，2:移動端用戶)")
	private String operationType;

	@ApiModelProperty(value = "操作人員")
	private String operator;

	@ApiModelProperty(value = "部門名稱")
	private String deptName;

	@ApiModelProperty(value = "請求URL")
	private String operationUrl;

	@ApiModelProperty(value = "主機地址")
	private String operatorIp;

	@ApiModelProperty(value = "請求值")
	private String operationParam;

	@ApiModelProperty(value = "返回值")
	private String jsonResult;

	@ApiModelProperty(value = "操作狀態(0:正常，1:異常)")
	private Integer status;

	@ApiModelProperty(value = "錯誤信息")
	private String errorMessage;

	@ApiModelProperty(value = "最近操作時間")
	private Date latestOperationTime;
}