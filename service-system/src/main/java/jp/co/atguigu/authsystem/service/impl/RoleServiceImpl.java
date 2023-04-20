package jp.co.atguigu.authsystem.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import jp.co.atguigu.authsystem.mapper.RoleMapper;
import jp.co.atguigu.authsystem.service.RoleService;
import jp.co.atguigu.model.entity.Role;

/**
 * ロール情報の実装クラス
 *
 * @author Administrator
 */
@Service
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
}
