package com.bach.Commerce.dao;

import com.bach.Commerce.entity.Coupon;

public interface CounponDAO {

	public Coupon findCouponByCode(String code);
	
}
