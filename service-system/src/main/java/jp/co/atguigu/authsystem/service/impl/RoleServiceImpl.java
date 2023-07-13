package jp.co.atguigu.authsystem.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.atguigu.authsystem.mapper.RoleMapper;
import jp.co.atguigu.authsystem.service.RoleService;
import jp.co.atguigu.common.utils.Pagination;
import jp.co.atguigu.model.entity.Role;
import jp.co.atguigu.model.vo.RoleQueryVo;
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

	@Override
	public void save(final Role role) {
		this.roleMapper.saveById(role);
	}

	@Override
	public boolean remove(final Long id) {
		final Long removeById = this.roleMapper.removeById(id);
		return removeById > 0;
	}

	@Override
	public Pagination<Role> pagination(final Long pageNum, final Long pageSize, final RoleQueryVo queryVo) {
		final Long offset = (pageNum - 1) * pageSize;
		final Long pagesCnt = this.roleMapper.findRolePagesCnt(queryVo);
		final List<Role> rolePages = this.roleMapper.findRolePages(offset, pageSize, queryVo);
		return Pagination.of(rolePages, Math.toIntExact(pagesCnt), Math.toIntExact(pageNum), Math.toIntExact(pageSize));
	}
}
