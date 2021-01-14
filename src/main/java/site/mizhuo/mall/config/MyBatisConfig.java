package site.mizhuo.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Mizhuo
 * @time: 2021/1/10 9:05 下午
 * @description: MyBatis配置类
 */
@Configuration
@MapperScan({"site.mizhuo.mall.mapper","site.mizhuo.mall.dao"})
public class MyBatisConfig {
}
