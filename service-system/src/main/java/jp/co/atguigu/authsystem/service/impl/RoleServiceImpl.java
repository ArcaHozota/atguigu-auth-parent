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

	@Override
	public List<Role> getAll() {
		return this.roleMapper.findAll();
	}

	@Override
	public boolean save(final Role role) {
		return this.roleMapper.saveById(role) > 0;
	}

	@Override
	public boolean update(final Role role) {
		return this.roleMapper.updateById(role) > 0;
	}

	@Override
	public boolean remove(final Long id) {
		return this.roleMapper.removeById(id) > 0;
	}

	@Override
	public Pagination<Role> pagination(final Integer pageNum, final Integer pageSize, final RoleQueryVo queryVo) {
		final Integer offset = (pageNum - 1) * pageSize;
		final Integer pagesCnt = this.roleMapper.findRolePagesCnt(queryVo);
		final List<Role> rolePages = this.roleMapper.findRolePages(offset, pageSize, queryVo);
		return Pagination.of(rolePages, pagesCnt, pageNum, pageSize);
	}

	@Override
	public Role getById(final Long id) {
		return this.roleMapper.getById(id);
	}
}
