package com.lty.threadpool.sys.mapper;

import com.lty.threadpool.sys.entity.Person;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Tianyu
 * @since 2022-05-19
 */
public interface PersonMapper extends BaseMapper<Person> {

    int saveBatch(List<Person> list);



}
