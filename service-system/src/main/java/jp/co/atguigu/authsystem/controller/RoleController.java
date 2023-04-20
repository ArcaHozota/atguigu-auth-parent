package jp.co.atguigu.authsystem.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;

import jp.co.atguigu.authsystem.service.RoleService;
import jp.co.atguigu.model.entity.Role;

public class RoleController {

	/**
	 * ロールサービス
	 */
	@Resource
	private RoleService roleService;

	/**
	 * すべての情報を取得する
	 *
	 * @return List<Role>
	 */
	@GetMapping("/findAll")
	public List<Role> getAllRoles() {
		return this.roleService.getAll();
	}
}
