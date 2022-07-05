package com.lty.threadpool.sys.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Tianyu
 * @date 2022/6/2 15:07
 */
@Configuration
public class DirectRabbitConfig {

    public static final String BINGD_KEY = "TestDirectRouting";

    // durable:是否持久化,默认是false,持久化队列：会被存储在磁盘上，当消息代理重启时仍然存在，暂存队列：当前连接有效
    // exclusive:默认也是false，只能被当前创建的连接使用，而且当连接关闭后队列即被删除。此参考优先级高于durable
    // autoDelete:是否自动删除，当没有生产者或者消费者使用此队列，该队列会自动删除。
    //   return new Queue("TestDirectQueue",true,true,false);

    //一般设置一下队列的持久化就好,其余两个就是默认false
    //队列
    @Bean
    public Queue TestDirectQueue(){
        return new Queue("TestDirectQueue",true);
    }

    //交换机
    @Bean
    DirectExchange TestDirectExchange(){
        return new DirectExchange("TestDirectExchange",true,false);
    }

    @Bean
    Binding bindingDirect(){
        return BindingBuilder.bind(TestDirectQueue()).to(TestDirectExchange()).with(BINGD_KEY);
    }

    //交换机
    @Bean
    DirectExchange TestDirectExchange2(){
        return new DirectExchange("TestDirectExchange2",true,false);
    }




}
