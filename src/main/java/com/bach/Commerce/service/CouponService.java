package com.bach.Commerce.service;

import com.bach.Commerce.model.CouponDTO;

public interface CouponService {
	
	public CouponDTO findCouponByCode(String code);
	
}
