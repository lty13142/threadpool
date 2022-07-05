package com.lty.threadpool.unit;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.sql.SQLException;
import java.util.Collections;

/**
 * @author Tianyu
 * @date 2022/5/19 14:53
 */
public class CodeGenerator {

    /**
     * 执行 run
     */
    public static void main(String[] args) throws SQLException {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/test?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&autoReconnect=true&failOverReadOnly=false&pinGlobalTxToPhysicalConnection=true", "root", "root")
                .globalConfig(builder -> {
                    builder.author("Tianyu") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("F:\\workspace\\threadpool\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.lty.threadpool") // 设置父包名
                            .moduleName("sys") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "F:\\workspace\\threadpool\\src\\main\\resources\\mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("t_school") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
//                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

}
