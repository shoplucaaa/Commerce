package com.bach.Commerce.dao.impl;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bach.Commerce.dao.CounponDAO;
import com.bach.Commerce.entity.Coupon;

@Transactional
@Repository
public class CouponDaoImpl implements CounponDAO {
	
	@Autowired
	EntityManager EntityManager;

	@Override
	public Coupon findCouponByCode(String code) {
		String jql = "SELECT c FROM Coupon c WHERE c.code = :code";
		return EntityManager.createQuery(jql, Coupon.class).setParameter("code", code).getSingleResult();
	}

}
