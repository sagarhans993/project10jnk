package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.DoctorDTO;

@Repository
public class DoctorDAOImpl extends BaseDAOImpl<DoctorDTO> implements DoctorDAOInt{

	
	@Override
	protected List<Predicate> getWhereClause(DoctorDTO dto, CriteriaBuilder builder, Root<DoctorDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<>();

		if (dto.getId() != null && dto.getId() > 0) {
			whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
		}

		if (dto.getName() != null && !dto.getName().isEmpty()) {
			whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
		}
		
		
		  if (dto.getDateofbirth() != null) {
	            whereCondition.add(builder.equal(qRoot.get("dateofbirth"), dto.getDateofbirth()));
	        }
		if (dto.getExpertise() != null && !dto.getExpertise().isEmpty()) {
			whereCondition.add(builder.like(qRoot.get("expertise"), dto.getExpertise() + "%"));
		}

		

		if (!isZeroNumber(dto.getMobile())) {
			whereCondition.add(builder.equal(qRoot.get("mobile"), dto.getMobile()));
		}

		

		return whereCondition;

		// return null;
	}

	@Override
	public Class<DoctorDTO> getDTOClass() {
		return DoctorDTO.class;
	}


}
