package jp.co.atguigu.service.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * スワーガーのセッティングファイル
 *
 * @author Administrator
 */
@Configuration
@EnableSwagger2WebMvc
public class SwaggerConfiguration {

	@Bean
	protected Docket adminApiConfig() {
		final List<Parameter> pars = new ArrayList<>();
		final ParameterBuilder tokenPar = new ParameterBuilder();
		tokenPar.name("token").description("用户token").defaultValue("").modelRef(new ModelRef("string"))
				.parameterType("header").required(false).build();
		pars.add(tokenPar.build());
		// ヘーダ引数を配する
		return new Docket(DocumentationType.SWAGGER_2).groupName("adminApi").apiInfo(this.adminApiInfo()).select()
				// パスadminのみ表示されます
				.apis(RequestHandlerSelectors.basePackage("com.atguigu")).paths(PathSelectors.regex("/admin/.*"))
				.build().globalOperationParameters(pars);
	}

	private ApiInfo adminApiInfo() {
		return new ApiInfoBuilder().title("バックエンド管理システム").description("バックエンド管理システムの定義ファイル").version("1.0")
				.contact(new Contact("atguigu", "http://atguigu.co.jp", "toshiba@guigu.com")).build();
	}
}
