package com.sbank.config

import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder

import org.springframework.security.config.annotation.web.builders.HttpSecurity

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
class SpringSecurityConfig : WebSecurityConfigurerAdapter() {

    val ACCOUNT = "/api/account/"

    @Throws(Exception::class)
    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}password").roles("USER")
                .and()
                .withUser("admin").password("{noop}password").roles("USER", "ADMIN")
    }

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "$ACCOUNT**").hasRole("USER")
                .antMatchers(HttpMethod.POST, ACCOUNT).hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "$ACCOUNT**").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin().disable()
    }

}