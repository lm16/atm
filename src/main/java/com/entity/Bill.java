package com.entity;

import java.math.BigDecimal;

public class Bill {
    private int billId;
    private int selfId;
    private String time;
    private String cardId;
    private byte type;
    private BigDecimal changee;
    private BigDecimal balanceChange;

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public int getSelfId() {
        return selfId;
    }

    public void setSelfId(int selfId) {
        this.selfId = selfId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public BigDecimal getChangee() {
        return changee;
    }

    public void setChangee(BigDecimal changee) {
        this.changee = changee;
    }

    public BigDecimal getBalanceChange() {
        return balanceChange;
    }

    public void setBalanceChange(BigDecimal balanceChange) {
        this.balanceChange = balanceChange;
    }
}
