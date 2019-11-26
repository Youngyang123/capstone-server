package cn.yg.capstoneserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("cn.yg.capstoneserver.mapper")
public class CapstoneServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CapstoneServerApplication.class, args);
    }

}
