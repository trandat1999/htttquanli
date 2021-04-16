package com.tranhuudat.htttquanli.security;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private AccountDetailsService accountDetailsService;

    public ApplicationSecurityConfig(AccountDetailsService accountDetailsService) {
        this.accountDetailsService = accountDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/home/**", "/login/**", "/login/css/**", "/customer/**", "/customer/item/**", "/signup",
                        "/bootstrap/**", "/**")
                .permitAll().antMatchers("/admin/**").hasAnyAuthority("ADMIN").anyRequest().authenticated().and()
                .formLogin().loginPage("/login").permitAll().usernameParameter("username").passwordParameter("password")
                .defaultSuccessUrl("/home")
                .failureUrl("/login?error").and().rememberMe()
                .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(14)).key("security")
                .userDetailsService(accountDetailsService).and().logout().logoutUrl("/logout")
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET")).clearAuthentication(true)
                .invalidateHttpSession(true).deleteCookies("JSESSIONID").logoutSuccessUrl("/home").permitAll();

    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(accountDetailsService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }
}
