package com.taguo.petpets.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


import lombok.RequiredArgsConstructor;


//若要自訂登入邏輯則要繼承 WebSecurityConfiguration
@Configuration
//@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	
	
	//密碼加密
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
//	@Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http. //省略其他配置
//                authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> {
//            authorizationManagerRequestMatcherRegistry
//                    .requestMatchers("/public/**").permitAll() // 允許公開訪問的路徑
//                    .requestMatchers("/private/**").hasRole("USER") // 需要 USER 角色
//                    .requestMatchers("/admin/**").hasRole("ADMIN"); // 需要 ADMIN 角色
//        })
//                .httpBasic(Customizer.withDefaults()).csrf(csrf -> csrf.disable()); // 使用 HTTP Basic 認證
//        return http.build();
//	}

}
