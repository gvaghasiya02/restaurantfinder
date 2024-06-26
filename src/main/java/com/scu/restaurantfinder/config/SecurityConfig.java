package com.scu.restaurantfinder.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorize -> authorize
                        .requestMatchers(
                                "/",
                                "/index.html",
                                "/create-account.html",
                                "/user-login.html",
                                "/admin-login.html",
                                "/admin-create-account.html",
                                "/admin-dashboard.html",
                                "/application.html",
                                "/user-profile.html",
                                "/auth/**",
                                "/css/**",
                                "/js/**",
                                "/images/**",
                                "/*.html",
                                "/restaurants/**"
                        ).permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(formLogin -> formLogin
                        .loginPage("/user-login.html")
                        .defaultSuccessUrl("/index.html", true)
                        .permitAll()
                )
                .formLogin(formLogin -> formLogin
                        .loginPage("/admin-login.html")
                        .defaultSuccessUrl("/admin-dashboard.html", true)
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/auth/logout")
                        .permitAll()
                )
                .csrf(csrf -> csrf.disable());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
