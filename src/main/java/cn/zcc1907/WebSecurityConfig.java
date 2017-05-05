package cn.zcc1907;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import cn.zcc1907.service.impl.UserServiceImpl;

/**
 * 配置spring security
 * @author Administrator
 *
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
    UserDetailsService customUserService() {
        return new UserServiceImpl();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService());
    }
    //配置过滤规则
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/resources/**", "/stylesheets/**",
                		"/images/**","/javascripts/**","/lib/**","/login"
                		,"/logout"
                		).permitAll()//配置不需要进行权限管理的目录
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login")
                .defaultSuccessUrl("/index")
                .failureUrl("/login?error").permitAll()
                .and().logout().logoutUrl("/index").permitAll();
    }
	
}
