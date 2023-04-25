package jp.co.atguigu.authsystem.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jp.co.atguigu.authsystem.service.RoleService;
import jp.co.atguigu.model.entity.Role;

/**
 * ロールコントローラー
 *
 * @author Administrator
 */
@Api(tags = "ロール授権処理API")
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
	@ApiOperation("全件検索")
	@GetMapping("/findAll")
	public List<Role> getAllRoles() {
		return this.roleService.getAll();
	}

	/**
	 * ロール情報を削除する
	 *
	 * @param id ロールID
	 */
	@ApiOperation("論理削除")
	@DeleteMapping("/remove/{id}")
	public void removeRole(@PathVariable final Long id) {
		this.roleService.remove(id);
	}
}
