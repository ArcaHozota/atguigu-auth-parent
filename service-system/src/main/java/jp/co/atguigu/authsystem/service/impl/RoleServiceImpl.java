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

	/**
	 * ロール情報を削除する
	 *
	 * @param id ロールID
	 * @return true:成功, false:削除失敗
	 */
	@Override
	public boolean remove(final Long id) {
		final Integer removeById = this.roleMapper.removeById(id);
		if (removeById > 0) {
			return true;
		}
		return false;
	}

	@Override
	public Pagination<Role> pagination(final Long pageNum, final Long pageSize, final RoleQueryVo queryVo) {
		final long pageMin = (pageNum - 1) * pageSize;
		final long pageMax = pageNum * pageSize;
		final Integer pagesCnt = this.roleMapper.findRolePagesCnt(queryVo);
		return null;
	}
}
