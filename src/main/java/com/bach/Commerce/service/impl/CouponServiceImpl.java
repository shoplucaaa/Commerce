package com.bach.Commerce.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bach.Commerce.dao.CounponDAO;
import com.bach.Commerce.entity.Coupon;
import com.bach.Commerce.model.CouponDTO;
import com.bach.Commerce.service.CouponService;

@Repository
@Transactional
public class CouponServiceImpl implements CouponService {
	
	@Autowired
	CounponDAO couponDAO;

	@Override
	public CouponDTO findCouponByCode(String code) {
		
		Coupon couponEntity = couponDAO.findCouponByCode(code);
		
		CouponDTO couponDTO = new CouponDTO();
		
		couponDTO.setId(couponEntity.getId());
		couponDTO.setCode(couponEntity.getCode());
		couponDTO.setDiscount(couponEntity.getDiscount());
		
		return couponDTO;
	}

	
}
