package com.example.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity
public class SecurityConfig {
@Bean
public UserDetailsService userDetailsService() {
	MyUserDetailsService service = new MyUserDetailsService();
    return service;
}
	
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
      http.formLogin(login -> login
              .loginProcessingUrl("/login")
              .loginPage("/")
              .defaultSuccessUrl("/user/list")
              .failureUrl("/login?error")
              .permitAll()
      ).logout(logout -> logout
              .logoutSuccessUrl("/")
      ).authorizeHttpRequests(authz -> authz
              .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
              .mvcMatchers("/").permitAll()
//              .mvcMatchers("/general").hasRole("GENERAL")
//              .mvcMatchers("/admin").hasRole("ADMIN")
              .anyRequest().authenticated()
      );
      return http.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
  }
}





//@Bean
//public UserDetailsManager users() {
////  UserDetails user = User.withDefaultPasswordEncoder()
////      .username("user")
////      .password("password")
////      .roles("USER")
////      .build();
//  JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
//  users.userExists(null)
//  users.createUser(user);
//  return users;
//}


//@Bean
//public InMemoryUserDetailsManager userDetailsService() {
//  UserDetails user = User.withDefaultPasswordEncoder()
//      .username("user")
//      .password("password")
//      .roles("USER")
//      .build();
//  return new InMemoryUserDetailsManager(user);
//}

////@Bean
////public UserDetailsService userDetailsService(BCryptPasswordEncoder bCryptPasswordEncoder) {
////    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
////    manager.createUser(User.withUsername("user")
////      .password(bCryptPasswordEncoder.encode("userPass"))
////      .build());
////    return manager;
////}
//
////@Bean
////public DataSource dataSource() {
////  return new EmbeddedDatabaseBuilder()
////      .setType(EmbeddedDatabaseType.H2)
////      .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
////      .build();
////}
//
//@Autowired
//private DataSource dataSource;
//
//@Bean
//public UserDetailsManager authenticateUsers() {
//
//UserDetails user = User.withUsername("username")
// .password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("password")).build();
//JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
//users.setAuthoritiesByUsernameQuery("select user_name,user_pwd,user_enabled from user where user_name=?");
//users.setUsersByUsernameQuery("select user_name,user_role from user where user_name=?");
//users.createUser(user);
//return users;
//}


//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        //????????????????????????????????????????????????????????????
//        auth.inMemoryAuthentication()
//                .withUser("javaboy").roles("admin").password("$2a$10$OR3VSksVAmCzc.7WeaRPR.t0wyCsIj24k0Bne8iKWV1o.V9wsP8Xe")
//                .and()
//                .withUser("lisi").roles("user").password("$2a$10$p1H8iWa8I4.CA.7Z8bwLjes91ZpY.rYREGHQEInNtAp4NzL6PLKxi");
//    }
//    @Bean
//    PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}