package jp.co.atguigu.model.vo;

import lombok.Data;

/**
 * 顯示路由信息
 */
@Data
public class MetaVo {

	/**
	 * 設置該路由在側邊欄和面包屑中展示的名字
	 */
	private String title;

	/**
	 * 設置該路由的圖標，路徑src/assets/icons/svg
	 */
	private String icon;
}
