package com.unihubcrew.unihub.controller;

import com.unihubcrew.unihub.dto.ApiResponse;
import com.unihubcrew.unihub.dto.CouponListData;
import com.unihubcrew.unihub.model.Coupon;
import com.unihubcrew.unihub.model.Post;
import com.unihubcrew.unihub.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/coupon")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @GetMapping("/id")
    public ApiResponse<Coupon> getCouponById(@RequestParam Long id) {
        try{
            Coupon coupon = couponService.getCouponById(id);
            return ApiResponse.success("获取优惠劵详情成功", coupon);
        } catch (Exception e) {
            return ApiResponse.failed("获取优惠劵详情失败："+e.getMessage());
        }
    }

    @GetMapping("/all")
    public ApiResponse<CouponListData> getAllCoupons(
            @RequestParam(value = "account", required = false) String account,
            @RequestParam(value = "applicableScope", required = false) String applicableScope,
            @RequestParam(value = "description", required = false) String description
    ) {
        try{
            List<Coupon> coupons = couponService.getAllCoupons(account, applicableScope, description);
            CouponListData couponListData=new CouponListData(coupons.size(),coupons);

            return ApiResponse.success("获取优惠券列表成功",couponListData);
        } catch (Exception e) {
            return ApiResponse.failed("获取优惠券列表失败："+e.getMessage());
        }
    }

    @PostMapping("/add")
    public ApiResponse<Map<String,Long>> addCoupon(@RequestBody Coupon coupon) {
        try{
            Long id = couponService.addCoupon(coupon);
            Map<String,Long> map = new HashMap<>();
            map.put("coupon_id", id);
            return ApiResponse.success("新增优惠券成功",map);
        } catch (Exception e) {
            return ApiResponse.failed("新增优惠券失败："+e.getMessage());
        }
    }

    @PostMapping("/update")
    public void updateCoupon(@RequestBody Coupon coupon) {
        couponService.updateCoupon(coupon);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCoupon(@PathVariable Long id) {
        couponService.deleteCoupon(id);
    }
}
