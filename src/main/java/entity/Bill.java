package entity;

import java.math.BigDecimal;

public class Bill {
    private int billId;
    private byte type;
    private Long cardId;
    private BigDecimal change;
    private BigDecimal balanceChange;
    private Long transferCarId;

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public BigDecimal getChange() {
        return change;
    }

    public void setChange(BigDecimal change) {
        this.change = change;
    }

    public BigDecimal getBalanceChange() {
        return balanceChange;
    }

    public void setBalanceChange(BigDecimal balanceChange) {
        this.balanceChange = balanceChange;
    }

    public Long getTransferCarId() {
        return transferCarId;
    }

    public void setTransferCarId(Long transferCarId) {
        this.transferCarId = transferCarId;
    }
}
