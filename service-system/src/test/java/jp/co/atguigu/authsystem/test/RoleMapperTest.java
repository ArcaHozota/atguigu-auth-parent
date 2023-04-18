package jp.co.atguigu.authsystem.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jp.co.atguigu.authsystem.mapper.RoleMapper;
import jp.co.atguigu.model.entity.Role;

@SpringBootTest
public class RoleMapperTest {

	@Autowired
	private RoleMapper roleMapper;

	@Test
	public void findAll() {
		final List<Role> findAll = this.roleMapper.findAll();
		findAll.forEach(System.out::println);
	}
}
