package com.rays.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.CartDTO;
import com.rays.dto.DoctorDTO;

public class DoctorForm  extends BaseForm{
	
	@NotEmpty(message = "Please enter name")
 	private String name;

	@NotEmpty(message = "Please enter expertise")
	private String expertise;
	
	@NotNull(message = "Please enter mobile")
	private Long mobile;
	
	
	  @NotNull(message = "Please enter dateofbirth")
	private Date dateofbirth;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getExpertise() {
		return expertise;
	}


	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}


	public Long getMobile() {
		return mobile;
	}


	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}


	public Date getDateofbirth() {
		return dateofbirth;
	}


	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}


	@Override
	public BaseDTO getDto() {
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		DoctorDTO dto = initDTO(new DoctorDTO());
		 dto.setName(name);
		 
	 
		dto.setDateofbirth(dateofbirth);
		
		dto.setMobile(mobile);
		
		dto.setExpertise(expertise);
		
	

		return dto;
	}
}
