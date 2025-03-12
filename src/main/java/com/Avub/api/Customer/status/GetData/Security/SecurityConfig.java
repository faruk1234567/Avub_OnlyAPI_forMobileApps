package com.Avub.api.Customer.status.GetData.Security;


/*import com.Avub.api.Customer.status.GetData.model.JwtFilter;*/
import com.Avub.api.Customer.status.GetData.Servise.LoginUserDetailService;
import com.Avub.api.Customer.status.GetData.model.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {





    /*private final BCryptPasswordEncoder passwordEncoder;

    public SecurityConfig(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }*/


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       // JwtFilter jwtFilter = new JwtFilter(jwtUtil, userDetailsService, authenticationManager(http));

        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/api/admin/set-password").permitAll()
                                //.requestMatchers("/api/login").permitAll()
                                .requestMatchers("/user").permitAll()
                                .requestMatchers("/login").permitAll()
                                .requestMatchers("/api/log/update-password").permitAll()
                                //.requestMatchers("/api/log/login").permitAll()
                                .requestMatchers("/employee-data").permitAll()
                                .requestMatchers("/employee_depositData").permitAll()
                                .requestMatchers("/employee-LoanData").permitAll()

                                .anyRequest().permitAll()


                               // .requestMatchers("/api/auth/**").authenticated()
                               // .requestMatchers("/error").permitAll()
                               // .anyRequest().authenticated()
                               // .and()
                              //  .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                )
                .httpBasic(withDefaults());

        return http.build();
    }

   /* @Bean

    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationConfiguration.class).getAuthenticationManager();
    }
*/
    @Bean

    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}







