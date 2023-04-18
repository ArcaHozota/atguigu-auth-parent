package jp.co.atguigu.model.entity;

import java.io.Serializable;
import java.util.Date;

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
	private Long id;

	/**
	 * 作成時間
	 */
	private Date creationTime;

	/**
	 * 更新時間
	 */
	private Date updatingTime;

	/**
	 * 論理削除フラグ
	 */
	private String logicDeleteFlg;
}
