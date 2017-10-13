package com.fastaccount.model;

import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.enums.AssignType;

/**
 * Created by xus on 2017/10/12.
 * //生活分类
 */
@Table("tb_left_type")
public class LeftType {
    @PrimaryKey(AssignType.BY_MYSELF)
    private String id;
    private String name;
    private int type;//1默认不可删除 0添加；

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
