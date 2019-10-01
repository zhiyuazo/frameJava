package trytest.thymeleaf.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.pagehelper.PageHelper;

@Configuration
public class PageHelperConfig {
	@Bean
	public PageHelper pageHelper() {
		Properties p = new Properties();
		p.setProperty("offsetAsPageNum", "true");
		p.setProperty("rowBoundsWithCount", "true");
		p.setProperty("reasonable", "true");
		p.setProperty("dialect","mysql");
		
		PageHelper pageHelper = new PageHelper();
		pageHelper.setProperties(p);
		return pageHelper;
	}
}
