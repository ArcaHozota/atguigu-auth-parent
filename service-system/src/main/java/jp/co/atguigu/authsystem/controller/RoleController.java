package jp.co.atguigu.authsystem.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jp.co.atguigu.authsystem.service.RoleService;
import jp.co.atguigu.common.utils.Pagination;
import jp.co.atguigu.common.utils.Result;
import jp.co.atguigu.model.entity.Role;
import jp.co.atguigu.model.vo.RoleQueryVo;

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
	public Result<List<Role>> getAllRoles() {
		final List<Role> roles = this.roleService.getAll();
		return Result.ok(roles);
	}

	/**
	 * ページング検索
	 *
	 * @param page  ページナンバー
	 * @param limit ページサイズ
	 */
	@ApiOperation("ページング検索")
	@GetMapping("/{page}/{limit}")
	public Result<Pagination<Role>> getRolePages(@PathVariable final Integer page, @PathVariable final Integer limit,
			final RoleQueryVo roleQueryVo) {
		// ページングオブジェクト
		final Pagination<Role> pages = this.roleService.pagination(page, limit, roleQueryVo);
		// ページングオブジェクトを返却する
		return Result.ok(pages);
	}

	/**
	 * ロール情報を削除する
	 *
	 * @param id ロールID
	 */
	@ApiOperation("論理削除")
	@DeleteMapping("/remove/{id}")
	public Result<?> removeRole(@PathVariable final Long id) {
		final boolean successOrNot = this.roleService.remove(id);
		if (successOrNot) {
			return Result.ok();
		}
		return Result.fail();
	}

	/**
	 * ロール情報を保存する
	 *
	 * @param role エンティティ
	 */
	@ApiOperation("保存")
	@PostMapping("/save")
	public Result<?> save(@RequestBody final Role role) {
		final boolean successOrNot = this.roleService.save(role);
		if (successOrNot) {
			return Result.ok();
		}
		return Result.fail();
	}

	/**
	 * ロール情報を更新する
	 *
	 * @param role エンティティ
	 */
	@ApiOperation("更新")
	@PostMapping("/update")
	public Result<?> update(@RequestBody final Role role) {
		final boolean successOrNot = this.roleService.update(role);
		if (successOrNot) {
			return Result.ok();
		}
		return Result.fail();
	}

	/**
	 * IDによってロール情報を検索する
	 *
	 * @param id ロールID
	 */
	@ApiOperation("条件検索")
	@GetMapping("/findRoleById/{id}")
	public Result<Role> getRoleById(@PathVariable final Long id) {
		final Role role = this.roleService.getById(id);
		return Result.ok(role);
	}
}
