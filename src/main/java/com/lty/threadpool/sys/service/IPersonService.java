package com.lty.threadpool.sys.service;

import com.lty.threadpool.sys.entity.Person;
import com.baomidou.mybatisplus.extension.service.IService;

import java.sql.SQLException;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Tianyu
 * @since 2022-05-19
 */
public interface IPersonService extends IService<Person> {

    int insertPerson(Person person);

    void inserPersonBatch(List<Person> list) throws SQLException;

}
