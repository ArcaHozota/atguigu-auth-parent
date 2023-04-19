package jp.co.atguigu.authsystem.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jp.co.atguigu.authsystem.mapper.RoleMapper;
import jp.co.atguigu.common.utils.BasicContextUtils;
import jp.co.atguigu.model.entity.Role;

/**
 * ロール授権のマッパーインターフェステスト
 *
 * @author Administrator
 */
@SpringBootTest
public class RoleMapperTest {

	/**
	 * ロールマッパー
	 */
	@Autowired
	private RoleMapper roleMapper;

	/**
	 * マッパーテスト01
	 */
	@Test
	public void findAll() {
		final List<Role> findAll = this.roleMapper.findAll();
		findAll.forEach(System.out::println);
	}

	/**
	 * マッパーテスト02
	 */
	@Test
	public void insert() {
		final Role role = new Role();
		role.setRoleName("測試角色");
		role.setRoleCode("testManager");
		role.setDescription("測試角色");
		BasicContextUtils.fillWithInsert(role);
		this.roleMapper.saveById(role);
	}
}
