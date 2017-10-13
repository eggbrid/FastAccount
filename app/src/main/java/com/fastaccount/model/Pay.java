package com.fastaccount.model;


import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.enums.AssignType;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by xus on 2017/10/12.
 */
@Table("tb_pay")

public class Pay {
    @PrimaryKey(AssignType.AUTO_INCREMENT)
    private String id;
    private BigDecimal money;
    private PayType payType;
    private LeftType leftType;
    private Date date;
    private Date creatDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public PayType getPayType() {
        return payType;
    }

    public void setPayType(PayType payType) {
        this.payType = payType;
    }

    public LeftType getLeftType() {
        return leftType;
    }

    public void setLeftType(LeftType leftType) {
        this.leftType = leftType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }
}
