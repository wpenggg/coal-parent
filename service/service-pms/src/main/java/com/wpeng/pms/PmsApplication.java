package com.wpeng.pms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author wpeng
 * @version 1.0
 * @date 2020/12/14 12:00
 *
 * 【管理-主程序类】
 */
@SpringBootApplication
@EnableJpaAuditing
@ComponentScan(basePackages = {"com.wpeng"})
public class PmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PmsApplication.class, args);
    }
}
