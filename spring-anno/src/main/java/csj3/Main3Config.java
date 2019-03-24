package csj3;

import com.csj.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * 懒加载
 */
@Configuration
public class Main3Config {


    @Bean //默认是单实例非懒加载(不加lazy注解的前提)，多实例默认是懒加载
    @Lazy(value = false) // 默认是懒加载，value = true,主要针对的是单实例bean。容器启动的时候不创建bean，仅在第一次使用的时候创建。
    public Person person() {

        return new Person(100,"csj");
    }
}
