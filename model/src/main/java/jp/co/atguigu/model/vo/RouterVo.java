package jp.co.atguigu.model.vo;

import java.util.List;

import lombok.Data;

/**
 * ローターの配置メッセージVO
 */
@Data
public class RouterVo {

	/**
	 * 路由地址
	 */
	private String path;

	/**
	 * 是否隱藏路由，當設置true的時候該路由不會出現在側邊欄
	 */
	private boolean hidden;

	/**
	 * 組件地址
	 */
	private String component;

	/**
	 * 當你一个路由下面的children聲明的路由大於1個時，自動會變成嵌套的模式——如同組件頁面
	 */
	private Boolean alwaysShow;

	/**
	 * 其它元素
	 */
	private MetaVo meta;

	/**
	 * 子路由
	 */
	private List<RouterVo> children;
}
