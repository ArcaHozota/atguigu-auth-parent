package jp.co.atguigu.common.utils;

import java.sql.Timestamp;

import jp.co.atguigu.common.constants.Constants;
import jp.co.atguigu.model.entity.BasicEntity;

/**
 * 通用插入更新自動填充類
 *
 * @author Administrator
 * @date 2022-11-18
 */
public class BasicContextUtils {

	/**
	 * 記錄當前時間
	 */
	private static final Timestamp TIMESTAMP = new Timestamp(System.currentTimeMillis());

	/**
	 * 通用保存處理
	 *
	 * @param aEntity 實體類
	 */
	public static void fillWithInsert(final BasicEntity aEntity) {
		aEntity.setId(SnowflakeUtils.nextId());
		aEntity.setCreationTime(TIMESTAMP);
		aEntity.setUpdatingTime(TIMESTAMP);
		aEntity.setLogicDeleteFlg(Constants.LOGIC_DELETE_FLGINITIAL);
	}

	/**
	 * 通用更新處理
	 *
	 * @param aEntity 實體類
	 */
	public static void fillWithUpdate(final BasicEntity aEntity) {
		aEntity.setUpdatingTime(TIMESTAMP);
	}
}
