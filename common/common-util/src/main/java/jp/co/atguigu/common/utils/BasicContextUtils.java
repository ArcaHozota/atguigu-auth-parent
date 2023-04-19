package jp.co.atguigu.common.utils;

import java.sql.Timestamp;

import jp.co.atguigu.common.constants.Constants;
import jp.co.atguigu.model.entity.BasicEntity;

/**
 * 共通更新及び保存処理クラス
 *
 * @author Administrator
 * @date 2022-11-18
 */
public class BasicContextUtils {

	/**
	 * 今の時間
	 */
	private static final Timestamp CURRENT_TIME = new Timestamp(System.currentTimeMillis());

	/**
	 * 共通の保存処理サービス
	 *
	 * @param aEntity 共通エンティティ
	 */
	public static void fillWithInsert(final BasicEntity aEntity) {
		aEntity.setId(SnowflakeUtils.nextId());
		aEntity.setCreationTime(CURRENT_TIME);
		aEntity.setUpdatingTime(CURRENT_TIME);
		aEntity.setLogicDeleteFlg(Constants.LOGIC_DELETE_FLGINITIAL);
	}

	/**
	 * 共通の更新処理サービス
	 *
	 * @param aEntity 共通エンティティ
	 */
	public static void fillWithUpdate(final BasicEntity aEntity) {
		aEntity.setUpdatingTime(CURRENT_TIME);
	}
}
