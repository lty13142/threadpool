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
 * @since 2022-05-20
 */
@TableName("t_school")
@ApiModel(value = "School对象", description = "")
public class School implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String schoolName;

    private String addr;

    private Integer status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "School{" +
        "id=" + id +
        ", schoolName=" + schoolName +
        ", addr=" + addr +
        ", status=" + status +
        "}";
    }
}
