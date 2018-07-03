package ua.mk.Ryndin.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  @Autowired
  private DataSource dataSource;
  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;


  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.jdbcAuthentication().dataSource(dataSource)
            .usersByUsernameQuery("SELECT e_mail, password, 'true' as enabled FROM user_client where e_mail=?")
            .authoritiesByUsernameQuery("select u.e_mail, r.role_name from user_client u inner join user_role ur on(u.user_id=ur.user_id) " +
                    "inner join role r on(ur.role_id=r.role_id) where u.e_mail=?")
            .passwordEncoder(bCryptPasswordEncoder);


  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
            .authorizeRequests()
              .antMatchers("/index", "/", "/user/create").permitAll()
              .antMatchers("/signin").permitAll()
              .antMatchers("/admin").hasAuthority("USER")
            . anyRequest().authenticated()
              .and()
            .httpBasic()
              .and()
            .formLogin()
              .loginPage("/login")
              .defaultSuccessUrl("/index")
              .permitAll()
              .and()
            .logout()
              .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
              .logoutSuccessUrl("/");

  }
}
