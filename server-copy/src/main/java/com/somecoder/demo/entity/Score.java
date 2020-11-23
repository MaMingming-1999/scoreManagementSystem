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
@ApiModel(value="Score对象", description="")
public class Score extends Model<Score> {

    private static final long serialVersionUID = 1L;

    private String cid;

    private String sid;

    private String aid;

    private String tid;

    private Integer susually;

    private Integer sfinally;

    private Integer spercent;

    private String srank;

    private String remark;


    @Override
    protected Serializable pkVal() {
        return this.cid;
    }

}
