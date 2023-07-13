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
	 * ページング検索
	 *
	 * @param page  ページナンバー
	 * @param limit ページサイズ
	 */
	@ApiOperation("ページング")
	@GetMapping("/{page}/{limit}")
	public Result<Pagination<Role>> getRolePages(@PathVariable final Long page, @PathVariable final Long limit,
			final RoleQueryVo roleQueryVo) {
		// ページングオブジェクト
		final Pagination<Role> pages = this.roleService.pagination(page, limit, roleQueryVo);
		// ページングオブジェクトを返却する
		return Result.ok(pages);
	}

	/**
	 * ロール保存
	 *
	 * @param role エンティティ
	 */
	@ApiOperation("ページング")
	@PostMapping("/save")
	public Result<Pagination<Role>> getRolePages(@RequestBody final Role role) {
		this.roleService.save(role);
		return Result.ok();
	}
}
