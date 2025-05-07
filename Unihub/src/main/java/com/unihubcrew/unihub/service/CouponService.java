package com.unihubcrew.unihub.service;

import com.unihubcrew.unihub.mapper.CouponMapper;
import com.unihubcrew.unihub.model.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponService {
    @Autowired
    private CouponMapper couponMapper;

    public Coupon getCouponById(Long id) {
        return couponMapper.getCouponById(id);
    }

    public List<Coupon> getAllCoupons(String account,String title, String tag) {
        return couponMapper.getAllCoupons(account,title,tag);
    }

    public Long addCoupon(Coupon coupon) {
        couponMapper.addCoupon(coupon);
        return coupon.getCouponId();
    }

    public void updateCoupon(Coupon coupon) {
        couponMapper.updateCoupon(coupon);
    }

    public void deleteCoupon(Long id) {
        couponMapper.deleteCoupon(id);
    }
}
