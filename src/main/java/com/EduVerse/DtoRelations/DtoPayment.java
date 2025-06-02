package com.EduVerse.DtoRelations;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DtoPayment {
    private Integer paymentId;
    private Integer paymentAmount;
    private String paymentNo;

    public DtoPayment() {
    }

    @JsonCreator
    public DtoPayment(
            @JsonProperty("paymentId") Integer paymentId,
            @JsonProperty("paymentAmount") Integer paymentAmount,
            @JsonProperty("paymentNo") String paymentNo) {
        this.paymentId = paymentId;
        this.paymentAmount = paymentAmount;
        this.paymentNo = paymentNo;
    }


    private DtoPayment(Builder builder) {
        this.paymentId = builder.paymentId;
        this.paymentAmount = builder.paymentAmount;
        this.paymentNo = builder.paymentNo;
    }

    public static class Builder {
        private Integer paymentId;
        private Integer paymentAmount;
        private String paymentNo;

        public Builder setPaymentId(Integer paymentId) {
            this.paymentId = paymentId;
            return this;
        }

        public Builder setPaymentAmount(Integer paymentAmount) {
            this.paymentAmount = paymentAmount;
            return this;
        }

        public Builder setPaymentNo(String paymentNo) {
            this.paymentNo = paymentNo;
            return this;
        }

        public DtoPayment build() {
            return new DtoPayment(this);
        }
    }


    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Integer getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Integer paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentNo() {
        return paymentNo;
    }

    public void setPaymentNo(String paymentNo) {
        this.paymentNo = paymentNo;
    }
}
