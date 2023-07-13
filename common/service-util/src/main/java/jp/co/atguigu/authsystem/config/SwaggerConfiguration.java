package jp.co.atguigu.authsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * スワーガーのセッティングファイル
 *
 * @author Administrator
 */
@Configuration
@EnableOpenApi
public class SwaggerConfiguration {

	@Bean
	protected Docket adminApiConfig() {
		return new Docket(DocumentationType.OAS_30).apiInfo(this.apiInfo()).groupName("SwaggerGroupApi").select()
				// パスadminのみ表示されます
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
				.paths(PathSelectors.regex("/admin/.*")).build();
	}

	@Bean
	protected ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("バックエンド管理システム").description("バックエンド管理システムの定義ファイル")
				.contact(new Contact("atguigu", "https://atguigu.co.jp", "toshiba@guigu.com")).version("1.0").build();
	}
}
