package com.system.demo.dto.specific;

public class EnrollmentProgramDto {
	
	private long id;
	
	private int index;
	
	private boolean discount;
	
	private double descount_enrollment;
	
	private double pay_enrollment;
	
	private double pay_pension;
	
	private String name;
	
	private String image;
	
	private Long requisitionId;

	public EnrollmentProgramDto(long id, int index, boolean discount, double descount_enrollment, double pay_enrollment,
			double pay_pension, String name, String image, Long requisitionId) {
		super();
		this.id = id;
		this.index = index;
		this.discount = discount;
		this.descount_enrollment = descount_enrollment;
		this.pay_enrollment = pay_enrollment;
		this.pay_pension = pay_pension;
		this.name = name;
		this.image = image;
		this.requisitionId = requisitionId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public boolean isDiscount() {
		return discount;
	}

	public void setDiscount(boolean discount) {
		this.discount = discount;
	}

	public double getDescount_enrollment() {
		return descount_enrollment;
	}

	public void setDescount_enrollment(double descount_enrollment) {
		this.descount_enrollment = descount_enrollment;
	}

	public double getPay_enrollment() {
		return pay_enrollment;
	}

	public void setPay_enrollment(double pay_enrollment) {
		this.pay_enrollment = pay_enrollment;
	}

	public double getPay_pension() {
		return pay_pension;
	}

	public void setPay_pension(double pay_pension) {
		this.pay_pension = pay_pension;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Long getRequisitionId() {
		return requisitionId;
	}

	public void setRequisitionId(Long requisitionId) {
		this.requisitionId = requisitionId;
	}

}
