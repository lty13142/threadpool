package com.lty.threadpool.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author Tianyu
 * @since 2022-05-19
 */
@TableName("t_person")
@ApiModel(value = "Person对象", description = "")
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private Integer age;

    private String addr;

    private String classes;

    private Integer schoolId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    @Override
    public String toString() {
        return "Person{" +
        "id=" + id +
        ", name=" + name +
        ", age=" + age +
        ", addr=" + addr +
        ", classes=" + classes +
        ", schoolId=" + schoolId +
        "}";
    }
}
