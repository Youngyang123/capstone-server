package cn.yg.capstoneserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("cn.yg.capstoneserver.mapper")
@EnableAsync
public class CapstoneServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CapstoneServerApplication.class, args);
    }

}
