package jp.co.atguigu.authsystem.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.atguigu.authsystem.mapper.RoleMapper;
import jp.co.atguigu.authsystem.service.RoleService;
import jp.co.atguigu.model.entity.Role;
import oracle.jdbc.driver.OracleSQLException;

/**
 * ロール情報の実装クラス
 *
 * @author Administrator
 */
@Service
@Transactional(rollbackFor = OracleSQLException.class)
public class RoleServiceImpl implements RoleService {

	/**
	 * ロールマッパー
	 */
	@Resource
	private RoleMapper roleMapper;

	/**
	 * すべてのロール情報を抽出する
	 *
	 * @return List<Role>
	 */
	@Override
	public List<Role> getAll() {
		return this.roleMapper.findAll();
	}

	/**
	 * ロール情報を削除する
	 *
	 * @param id ロールID
	 */
	@Override
	public void remove(final Long id) {
		this.roleMapper.removeById(id);
	}
}
