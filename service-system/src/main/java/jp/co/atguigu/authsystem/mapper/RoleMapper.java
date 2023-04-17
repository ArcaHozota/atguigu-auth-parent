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
}
