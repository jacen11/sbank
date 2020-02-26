package com.sbank.config

import com.sbank.model.Role
import com.sbank.service.UserServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
class SpringSecurityConfig : WebSecurityConfigurerAdapter() {

    @Autowired
    private val userService: UserServiceImpl? = null

    @Autowired
    private val passwordEncoder: PasswordEncoder? = null

    val REQ_ACCOUNT = "/api/account"

    @Throws(Exception::class)
    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(userService)
                .passwordEncoder(passwordEncoder)


//        auth.inMemoryAuthentication()
//                .withUser("user").password(passwordEncoder?.encode("password")).roles(Role.USER.name)
//                .and()
//               // .withUser("admin").password("{noop}password").roles("USER", "ADMIN")
//                .withUser("admin").password(passwordEncoder?.encode("password")).roles("USER", "ADMIN")
    }

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers( "$REQ_ACCOUNT**").hasRole("USER")
                .and()
                .csrf().disable()
                .formLogin().disable()
    }

}