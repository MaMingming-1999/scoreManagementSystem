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
@ApiModel(value="Teacher对象", description="")
public class Teacher extends Model<Teacher> {

    private static final long serialVersionUID = 1L;

    private String tid;

    private String aid;

    private String tname;

    private String temail;

    private String tphone;

    private String tpassword;

    private String tcollege;

    private String remark;


    @Override
    protected Serializable pkVal() {
        return this.tid;
    }

    public void setPassword(String newPasswd) {
    }

    public void setTPassword(String newPasswd) {
    }
}
