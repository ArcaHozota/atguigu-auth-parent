package jp.co.atguigu.model.vo;

import lombok.Data;

/**
 * 登录对象
 */
@Data
public class LoginVo {

	/**
	 * 手機號碼
	 */
	private String username;

	/**
	 * 密碼
	 */
	private String password;
}
