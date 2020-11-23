package com.somecoder.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 关注问题类型表
 * </p>
 *
 * @author somecoder
 * @since 2020-03-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="CareType对象", description="关注问题类型表")
public class CareType extends Model<CareType> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "系统主键")
    private String careTypeId;

    @ApiModelProperty(value = "父级问题类型id,0是顶层,需递归")
    private String parentId;

    @ApiModelProperty(value = "问题类型名称")
    private String name;

    @ApiModelProperty(value = "备注、解释")
    private String note;

    @ApiModelProperty(value = "是否删除(0:未删除；1:已删除)")
    private String isDel;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createDate;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateDate;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
