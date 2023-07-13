package jp.co.atguigu.authsystem.service;

import java.util.List;

import jp.co.atguigu.common.utils.Pagination;
import jp.co.atguigu.model.entity.Role;
import jp.co.atguigu.model.vo.RoleQueryVo;

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
	 * ロール情報を保存する
	 *
	 * @param role エンティティ
	 * @return true:成功, false:保存失敗
	 */
	boolean save(Role role);

	/**
	 * ロール情報を更新する
	 *
	 * @param role エンティティ
	 * @return true:成功, false:更新失敗
	 */
	boolean update(Role role);

	/**
	 * ロール情報を削除する
	 *
	 * @param id ロールID
	 * @return true:成功, false:削除失敗
	 */
	boolean remove(Long id);

	/**
	 * ページング検索
	 *
	 * @param pageNum  ページナンバー
	 * @param pageSize ページサイズ
	 * @param queryVo  クエリVO
	 * @return Pagination<Role>
	 */
	Pagination<Role> pagination(Integer pageNum, Integer pageSize, RoleQueryVo queryVo);

	/**
	 * IDによってロール情報を検索する
	 *
	 * @param id ロールID
	 * @return Role
	 */
    Role getById(Long id);
}
