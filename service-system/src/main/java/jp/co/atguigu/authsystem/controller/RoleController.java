package jp.co.atguigu.authsystem.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;

import jp.co.atguigu.authsystem.service.RoleService;
import jp.co.atguigu.model.entity.Role;

public class RoleController {

	@Resource
	private RoleService roleService;

	@GetMapping("/findAll")
	public List<Role> getAllRoles() {
		return this.roleService.getAll();
	}
}
