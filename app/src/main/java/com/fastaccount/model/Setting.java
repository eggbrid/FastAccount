package com.fastaccount.model;


import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.enums.AssignType;

import java.math.BigDecimal;

/**
 * Created by xus on 2017/10/12.
 */
@Table("tb_setting")
public class Setting {
    @PrimaryKey(AssignType.BY_MYSELF)
    private String id="1";
    private BigDecimal warnMoney;
    private BigDecimal redMoney;

    public BigDecimal getWarnMoney() {
        return warnMoney;
    }

    public void setWarnMoney(BigDecimal warnMoney) {
        this.warnMoney = warnMoney;
    }

    public BigDecimal getRedMoney() {
        return redMoney;
    }

    public void setRedMoney(BigDecimal redMoney) {
        this.redMoney = redMoney;
    }
}
