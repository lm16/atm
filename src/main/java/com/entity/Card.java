package com.entity;

import java.math.BigDecimal;

public class Card {
    private String cardId;
    private int pin;
    private BigDecimal balance;
    private long belong;
    private byte loss;

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public long getBelong() {
        return belong;
    }

    public void setBelong(long belong) {
        this.belong = belong;
    }

    public byte getLoss() {
        return loss;
    }

    public void setLoss(byte loss) {
        this.loss = loss;
    }
}
