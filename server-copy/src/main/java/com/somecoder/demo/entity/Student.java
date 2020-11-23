package com.somecoder.demo.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author lrq
 * @since 2020-11-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Student对象", description="")
public class Student extends Model<Student> {

    private static final long serialVersionUID = 1L;

    private String sid;

    private String aid;

    private String name;

    private String scollege;

    private String smajor;

    private String semail;

    private String sphone;

    private String spassword;

    private String syear;

    private String remark;


    @Override
    protected Serializable pkVal() {
        return this.sid;
    }

    public void setSPassword(String newPasswd) {
    }
}
