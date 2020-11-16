package com.dragon.hei.wsth.business.mapper.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Description:
 * @Author: lilong
 **/
@Data
@Accessors(chain = true)
public class TmpUser {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String name;

    private Integer age;
}
