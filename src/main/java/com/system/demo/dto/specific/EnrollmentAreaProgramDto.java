package com.system.demo.dto.specific;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentAreaProgramDto {
	
	private String area;
	
	private List<EnrollmentProgramDto> programs;

	public EnrollmentAreaProgramDto(String area) {
		super();
		this.area = area;
		this.programs = new ArrayList<>();
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public List<EnrollmentProgramDto> getPrograms() {
		return programs;
	}

	public void setPrograms(List<EnrollmentProgramDto> programs) {
		this.programs = programs;
	}
	
	public void setProgram(EnrollmentProgramDto program) {
		this.programs.add(program);
	}

}
