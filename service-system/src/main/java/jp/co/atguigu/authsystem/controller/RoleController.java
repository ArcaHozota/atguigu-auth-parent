package jp.co.atguigu.authsystem.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.co.atguigu.authsystem.service.RoleService;
import jp.co.atguigu.model.entity.Role;

/**
 * ロールコントローラー
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/admin/system/sysRole")
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
