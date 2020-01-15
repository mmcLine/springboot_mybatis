package com.mmc;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @description:
 * @author: mmc
 * @create: 2020-01-15 16:52
 **/
@SpringBootApplication
@MapperScan("com.mmc.mapper")
public class WorkSpringBootApplication {
}
