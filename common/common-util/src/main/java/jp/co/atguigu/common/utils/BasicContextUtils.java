package jp.co.atguigu.common.utils;

import java.time.LocalDateTime;

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
	 * 通用保存處理
	 *
	 * @param aEntity 實體類
	 */
	public static void fillWithInsert(final BasicEntity aEntity) {
		aEntity.setId(SnowflakeUtils.nextId());
		aEntity.setCreationTime(LocalDateTime.now());
		aEntity.setUpdatingTime(LocalDateTime.now());
		aEntity.setLogicDeleteFlg(Constants.LOGIC_DELETE_FLGINITIAL);
	}

	/**
	 * 通用更新處理
	 *
	 * @param aEntity 實體類
	 */
	public static void fillWithUpdate(final BasicEntity aEntity) {
		aEntity.setUpdatingTime(LocalDateTime.now());
	}
}
