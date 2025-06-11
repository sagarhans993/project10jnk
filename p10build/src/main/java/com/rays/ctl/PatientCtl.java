package com.rays.ctl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.CustomerDTO;
import com.rays.dto.PatientDTO;
import com.rays.form.PatientForm;
import com.rays.service.PatientServiceInt;

@RestController
@RequestMapping(value = "Patient")

public class PatientCtl extends BaseCtl<PatientForm, PatientDTO, PatientServiceInt> {
	
	@GetMapping("/preload")
	public ORSResponse preload() {
		System.out.println("Inside preload");
		ORSResponse res = new ORSResponse(true);
		PatientDTO dto = new PatientDTO();
		List list = new ArrayList<>();
		list.add("Dengue");
		list.add("Cencer");
		list.add("HartDecease");
		res.addResult("Patientlist", list);

		/*
		 * List list1 = new ArrayList<>(); list1.add("2020-01-01");
		 * list1.add("2015-03-09"); list1.add("2010-10-09");
		 * res.addResult("Customerlist2", list1);
		 */

		return res;
	}


}
