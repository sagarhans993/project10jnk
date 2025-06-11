package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.CartDTO;
import com.rays.dto.PatientDTO;

@Repository
public class PatientDAOImpl extends BaseDAOImpl<PatientDTO> implements PatientDAOInt{

	
	@Override
	protected List<Predicate> getWhereClause(PatientDTO dto, CriteriaBuilder builder, Root<PatientDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<>();

		if (dto.getId() != null && dto.getId() > 0) {
			whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
		}

		if (dto.getName() != null && !dto.getName().isEmpty()) {
			whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
		}
		
		
		  if (dto.getVisitedate() != null) {
	            whereCondition.add(builder.equal(qRoot.get("visitedate"), dto.getVisitedate()));
	        }
		if (dto.getDecease() != null && !dto.getDecease().isEmpty()) {
			whereCondition.add(builder.like(qRoot.get("decease"), dto.getDecease() + "%"));
		}

		

		if (!isZeroNumber(dto.getMobile())) {
			whereCondition.add(builder.equal(qRoot.get("mobile"), dto.getMobile()));
		}

		

		return whereCondition;

		// return null;
	}
	@Override
	public Class<PatientDTO> getDTOClass() {
		return PatientDTO.class;
	}

}
