package jp.co.atguigu.authsystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import jp.co.atguigu.model.entity.Role;

/**
 * ロール授権のマッパーインターフェス
 *
 * @author Administrator
 */
@Mapper
public interface RoleMapper {

	/**
	 * すべてのデータを吹き出します
	 *
	 * @return List<Role>
	 */
	List<Role> findAll();

	/**
	 * データを保存する
	 *
	 * @param role ロールエンティティ
	 */
	void saveById(Role role);

	/**
	 * データを削除する(論理削除)
	 *
	 * @param id ロールID
	 */
	void removeById(Long id);
}
