package com.unihubcrew.unihub.mapper;

import com.unihubcrew.unihub.model.Coupon;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CouponMapper {
    @Select("SELECT * FROM coupons WHERE coupon_id= #{id} ")
    Coupon getCouponById(Long id);

    List<Coupon> getAllCoupons(@Param("account") String account,@Param("applicableScope") String applicableScope, @Param("description") String description);

    @Insert("INSERT INTO coupons(coupon_id, account, valid_from,valid_until,applicable_scope,description)"+
            "VALUES(#{id},#{account},#{validFrom},#{validUntil},#{applicableScope},#{description})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void addCoupon(Coupon coupon);

    @Insert("UPDATE coupons SET account=#{account},valid_from=#{validFrom},valid_until=#{validUntil},"+
            "applicable_scope=#{applicableScope},description=#{description} "+
            "WHERE coupon_id=#{id}")
    void updateCoupon(Coupon coupon);

    @Delete("DELETE FROM coupons WHERE coupon_id=#{id}")
    void deleteCoupon(Long id);
}
