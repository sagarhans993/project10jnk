package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.CartDTO;

@Repository
public class CartDAOImpl extends BaseDAOImpl<CartDTO> implements CartDAOInt{
	
	@Override
	protected List<Predicate> getWhereClause(CartDTO dto, CriteriaBuilder builder, Root<CartDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<>();

		if (dto.getId() != null && dto.getId() > 0) {
			whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
		}

		if (dto.getCustomerName() != null && !dto.getCustomerName().isEmpty()) {
			whereCondition.add(builder.like(qRoot.get("customerName"), dto.getCustomerName() + "%"));
		}
		
		
		  if (dto.getTransationDate() != null) {
	            whereCondition.add(builder.equal(qRoot.get("quantityOrdered"), dto.getTransationDate()));
	        }
		if (dto.getProduct() != null && !dto.getProduct().isEmpty()) {
			whereCondition.add(builder.like(qRoot.get("product"), dto.getProduct() + "%"));
		}

		

		if (!isZeroNumber(dto.getQuantityOrdered())) {
			whereCondition.add(builder.equal(qRoot.get("quantityOrdered"), dto.getQuantityOrdered()));
		}

		

		return whereCondition;

		// return null;
	}

	@Override
	public Class<CartDTO> getDTOClass() {
		return CartDTO.class;
	}


}
