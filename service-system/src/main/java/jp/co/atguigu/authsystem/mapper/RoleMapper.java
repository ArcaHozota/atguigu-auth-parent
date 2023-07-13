package jp.co.atguigu.authsystem.mapper;

import java.util.List;

import oracle.jdbc.driver.OracleSQLException;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import jp.co.atguigu.model.entity.Role;
import jp.co.atguigu.model.vo.RoleQueryVo;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional(rollbackFor = OracleSQLException.class)
	Integer saveById(Role role);

	/**
	 * データを削除する(論理削除)
	 *
	 * @param id ロールID
	 */
	@Transactional(rollbackFor = OracleSQLException.class)
	Integer removeById(Long id);

	/**
	 * すべてコード数の検索
	 *
	 * @param queryVo クエリVO
	 * @return Integer
	 */
	Integer findRolePagesCnt(@Param("vo") RoleQueryVo queryVo);

	/**
	 * ページング検索
	 *
	 * @param queryVo クエリVO
	 * @return List<Role>
	 */
	List<Role> findRolePages(@Param("offset") Integer offset, @Param("pageSize") Integer pageSize,
			@Param("vo") RoleQueryVo queryVo);
}
