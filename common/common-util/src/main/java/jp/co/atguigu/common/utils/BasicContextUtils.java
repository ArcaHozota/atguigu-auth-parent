package jp.co.atguigu.common.utils;

import java.sql.Timestamp;

import jp.co.atguigu.common.constants.Constants;
import jp.co.atguigu.model.entity.BasicEntity;
import org.springframework.lang.NonNull;

/**
 * 共通更新及び保存処理クラス
 *
 * @author Administrator
 * @since 2022-11-18
 */
public class BasicContextUtils {

	/**
	 * 今の時間
	 */
	private static final Timestamp CURRENT_TIME = new Timestamp(System.currentTimeMillis());

	private BasicContextUtils() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * 共通の保存処理ロジック
	 *
	 * @param aEntity 共通エンティティ
	 */
	public static void fillWithInsert(@NonNull final BasicEntity aEntity) {
		aEntity.setId(SnowflakeUtils.nextId());
		aEntity.setCreationTime(CURRENT_TIME);
		aEntity.setUpdatingTime(CURRENT_TIME);
		aEntity.setLogicDeleteFlg(Constants.LOGIC_DELETE_INITIAL);
	}

	/**
	 * 共通の更新処理ロジック
	 *
	 * @param aEntity 共通エンティティ
	 */
	public static void fillWithUpdate(@NonNull final BasicEntity aEntity) {
		aEntity.setUpdatingTime(CURRENT_TIME);
	}
}
