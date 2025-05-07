package com.unihubcrew.unihub.dto;

import com.unihubcrew.unihub.model.Coupon;

import java.util.List;

public class CouponListData {
    private int total_count;
    private List<Coupon> coupons;

    public CouponListData(int total_count, List<Coupon> coupons) {
        this.total_count = total_count;
        this.coupons = coupons;
    }

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public List<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(List<Coupon> coupons) {
        this.coupons = coupons;
    }

    @Override
    public String toString() {
        return "CouponListData{" +
                "total_count=" + total_count +
                ", coupons=" + coupons +
                '}';
    }
}
