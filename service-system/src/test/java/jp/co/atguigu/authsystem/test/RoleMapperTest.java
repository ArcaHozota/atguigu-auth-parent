package jp.co.atguigu.authsystem.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jp.co.atguigu.authsystem.mapper.RoleMapper;
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
	 * マッパーテスト
	 */
	@Test
	public void findAll() {
		final List<Role> findAll = this.roleMapper.findAll();
		findAll.forEach(System.out::println);
	}
}
