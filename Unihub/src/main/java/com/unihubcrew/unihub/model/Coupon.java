package com.unihubcrew.unihub.model;

import java.time.LocalDateTime;

public class Coupon {
    private Long couponId;
    private String account;
    private LocalDateTime validFrom;
    private LocalDateTime validUntil;
    private String applicableScope;
    private String description;

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public LocalDateTime getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDateTime validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDateTime getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(LocalDateTime validUntil) {
        this.validUntil = validUntil;
    }

    public String getApplicableScope() {
        return applicableScope;
    }

    public void setApplicableScope(String applicableScope) {
        this.applicableScope = applicableScope;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "id=" + couponId +
                ", account='" + account + '\'' +
                ", valid_from=" + validFrom +
                ", valid_until=" + validUntil +
                ", applicable_scope='" + applicableScope + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
