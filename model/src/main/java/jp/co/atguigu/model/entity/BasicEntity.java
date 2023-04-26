package jp.co.atguigu.model.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 共通エンティティクラス
 *
 * @author Administrator
 */
@Data
public class BasicEntity implements Serializable {

	private static final long serialVersionUID = 5540383366177705903L;

	/**
	 * ID
	 */
	@ApiModelProperty(value = "ID")
	private Long id;

	/**
	 * 作成時間
	 */
	@ApiModelProperty(value = "創建時間")
	private Timestamp creationTime;

	/**
	 * 更新時間
	 */
	@ApiModelProperty(value = "更新時間")
	private Timestamp updatingTime;

	/**
	 * 論理削除フラグ
	 */
	@ApiModelProperty(value = "邏輯刪除標志")
	private String logicDeleteFlg;
}
