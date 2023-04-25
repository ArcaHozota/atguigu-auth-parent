package jp.co.atguigu.authsystem.service;

import java.util.List;

import jp.co.atguigu.model.entity.Role;

/**
 * ロール情報のサービスインターフェス
 *
 * @author Administrator
 */
public interface RoleService {

	/**
	 * すべてのロール情報を抽出する
	 *
	 * @return List<Role>
	 */
	List<Role> getAll();

	/**
	 * ロール情報を削除する
	 *
	 * @param id ロールID
	 */
	void remove(Long id);
}
