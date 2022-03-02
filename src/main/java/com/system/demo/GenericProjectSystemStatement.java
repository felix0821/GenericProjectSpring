package com.system.demo;

import java.util.HashMap;

public class GenericProjectSystemStatement {
	
	/**
	 *	Predefined settings for the system
	 **/
//	°Configuración inicial del sistema
//	°Declaraciones de configuraciones del periodo academico
	public static final String SETTINGS_PERIOD_INITIAL_BREAK = "period_initial_break";
	public static final String SETTINGS_PERIOD_DURATION_MONTHS = "period_duration_months";
	public static final String SETTINGS_PERIOD_FINAL_BREAK = "period_final_break";
	public static final String SETTINGS_MODULUS_SCHEDULE_BREAK = "modulus_schedule_break";
	public static final String[] SETTINGS_MODULUS_DURATION_WEEKS = {"modulus_1_duration_weeks", "modulus_2_duration_weeks", 
			"modulus_3_duration_weeks", "modulus_4_duration_weeks"};
	public static final String SETTINGS_PAYMENT_SCHEDULE_INTEREST = "payment_schedule_interest";
	
	/**
	 *	Predefined resources for the system
	 **/
//	°Declaraciones generales del sistema
//	°Declaraciones de parametros para ubicación
	public static final String ZONE_DATE_LIMA = "America/Lima";
//	°Recursos generales del sistema
//	°Recursos estados de entidad
	public static final Character SYSTEM_STATE_ACTIVE = 'A';
	public static final Character SYSTEM_STATE_INACTIVE = 'I';
	public static final Character SYSTEM_STATE_DELETE = '*';
	//	Recursos tipos de entidad
	public static final Character SYSTEM_TYPE_AUTOGENERATED = 'A';
	public static final Character SYSTEM_TYPE_DEFINED_USER = 'D';
	public static final Character SYSTEM_TYPE_LOCAL_GENERATED = 'L';
//	Recursos categoria de persona registro
	public static final Character REGISTERING_FINANCIAL_MOVEMENT = 'F';
	//	Recursos especificos del sistema
	//	Recursos de referencia
	public static final Long SYSTEM_REFERENCE_PERIOD_DEFINED = 2000001000001L;
	public static final Long SYSTEM_REFERENCE_PROGRAM_DEFINED = 2000001000002L;
	//	Recursos de uso
	public static final Long SYSTEM_USE_ENROLLMENT_REQUEST = 3000001000001L;
	public static final Long SYSTEM_USE_ENROLLMENT_SELECT = 3000001000002L;
	public static final Long SYSTEM_USE_PAYMENT_DEPOSIT = 3000002000001L;
	//	Recursos id de roles
	public static final Long SYSTEM_ID_ADMINISTRATOR = 1000001000001L;
	public static final Long SYSTEM_ID_USER = 1000001000002L;
	public static final Long SYSTEM_ID_GUEST = 1000001000003L;
	//	Recursos genero de personas
	public static final Character SYSTEM_GENDER_MALE = 'M';
	public static final Character SYSTEM_GENDER_FEMALE = 'F';
	public static final Character SYSTEM_GENDER_UNDEFINED = 'X';
	//	Recursos identificación de personas
	public static final Long SYSTEM_IDENTIFICATION_DNI = 1000002000001L;
	//	Recursos estado de solicitud
	public static final Long SYSTEM_REQUISITION_STATUS_SEND = 500010001L;
	public static final Long SYSTEM_REQUISITION_STATUS_ACCEPT = 500010002L;
	public static final Long SYSTEM_REQUISITION_STATUS_OBSERVE = 500010003L;
//	Recursos movimiento financiero
	public static final Long SYSTEM_FINANTIAL_MOVEMENT_INCOME_SOLES = 700010001L;
	public static final Long SYSTEM_FINANTIAL_MOVEMENT_EGRESS_SOLES = 700010002L;
	public static final Character SYSTEM_FINANTIAL_MOVEMENT_TYPE_INCOME = '+';
	public static final Character SYSTEM_FINANTIAL_MOVEMENT_TYPE_EGRESS = '-';
	
	/**
	 *	Route mapping for the system
	 **/
//	Mapeo para el controlador "Autenticación"
	public static final String URL_AUTH_REQUEST = "/auth";
	public static final String URL_AUTH_LOGIN_POST = "/login";
	public static final String URL_AUTH_ERROR_GET = "/error";
	
//	Mapeo para el controlador "Servicio"
	public static final String URL_SERVICE_REQUEST = "/service";
	
//	Mapeo para el controlador "Persona"
	public static final String URL_PERSON_REQUEST = "/person";
	public static final String URL_PERSON_PROFILE_GET = "/profile";
	public static final String URL_PERSON_PROFILE_EDIT_POST = "/profile/edit";
	public static final String URL_PERSON_REGISTER_POST = "/register";
	public static final String URL_PERSON_DELETE_GET = "/deletePerson"; //-
	public static final String URL_PERSON_EDIT_GET = "/editPerson/{id}";
	public static final String URL_PERSON_EDIT_POST = "/editUser";
	public static final String URL_PERSONxROLES_GET = "/person-roles/{personId}";
	public static final String URL_PERSONxROLE_DELETE_GET = "/person-role/delete";
	public static final String URL_PERSONxROLES_REGISTER_GET = "/person-roles/register/{personId}";
	public static final String URL_PERSONxROLE_REGISTER_POST = "/person-role/register";
	
//	Mapeo para el controlador "Solicitud"
	public static final String URL_REQUISITION_REQUEST = "/requisition";
	public static final String URL_REQUISITION_STATUS_GET = "/status";
	public static final String URL_REQUISITION_REGISTER_GET = "/register/{requisition}";
	public static final String URL_REQUISITION_ENROLL_GET = "/enroll";
	
//	Mapeo para el controlador "Movimiento financiero"
	public static final String URL_FINANCIAL_MOVEMENT_REQUEST = "/financial-movement";
	
//	Mapeo para el controlador "Control documental"
	public static final String URL_DOCUMENTARY_REQUEST = "/documentary";
	
//	Mapeo para el controlador "Gestion academica"
	public static final String URL_ACADEMIC_REQUEST = "/academic";
	public static final String URL_ACADEMIC_PROGRAMxPERIODS_GET = "/program-periods/{idProgram}";
	public static final String URL_ACADEMIC_CYCLExREGISTER_POST = "/cycle-register";
	public static final String URL_ACADEMIC_CYCLExEDIT_GET = "/cycle-edit";
	public static final String URL_ACADEMIC_CYCLExEDIT_POST = "/cycle-edit";
	public static final String URL_ACADEMIC_CYCLExDELETE_GET = "/cycle-delete";
	public static final String URL_ACADEMIC_CYCLE_PROGRAMS_GET = "/{cycle}/programs";
	public static final String URL_ACADEMIC_CYCLE_PROGRAMxREGISTER_GET = "/{cycle}/program-register";
	public static final String URL_ACADEMIC_CYCLE_PROGRAMxREGISTERxSELECT_POST = "/{cycle}/program-register-select";
	public static final String URL_ACADEMIC_CYCLE_PROGRAMxREGISTERxNEW_POST = "/{cycle}/program-register-new";
	public static final String URL_ACADEMIC_CYCLE_PROGRAMxDELETE_GET = "/{cycle}/program-delete";
	public static final String URL_ACADEMIC_CYCLE_PROGRAM_ENROLLED_GET = "/{cycle}/{program}/enrolleds";
	public static final String URL_ACADEMIC_CYCLE_PROGRAM_COURSE_GET = "/{cycle}/{program}/courses";
	//public static final String URL_ACADEMIC_PROGRAMxPERIOD_VIEW_GET = "/program-period/view/{id}";
	
//	Mapeo para el controlador "Gestion de seguridad"
	public static final String URL_SECURITY_REQUEST = "/security";
	public static final String URL_SECURITY_ROLE_GET = "/role";
	public static final String URL_SECURITY_EDITxROLE_GET = "/edit-role/{id}";
	public static final String URL_SECURITY_EDITxROLE_POST = "/edit-role";
	public static final String URL_SECURITY_DELETExROLE_GET = "/delete-role/{id}";
	public static final String URL_SECURITY_ROLE_REGISTER_POST = "/role/register";
	public static final String URL_SECURITY_ACCESS_GET = "/access";
	public static final String URL_SECURITY_INTERFACE_GET = "/interface";
	
//	Mapeo para el controlador "Gestion de configuración"
	public static final String URL_CONFIGURATION_REQUEST = "/configuration";
	public static final String URL_CONFIGURATION_PROGRAM_GET = "/program";
	public static final String URL_CONFIGURATION_PROGRAMxREGISTER_POST = "/program-register";
	public static final String URL_CONFIGURATION_PROGRAMxEDIT_GET = "/program-edit";
	public static final String URL_CONFIGURATION_PROGRAMxEDIT_POST = "/program-edit";
	public static final String URL_CONFIGURATION_PROGRAMxDELETE_GET = "/program-delete";
	public static final String URL_CONFIGURATION_PROGRAM_VIEW_GET = "/program/{program}";
	public static final String URL_CONFIGURATION_PROGRAM_EDIT_POST = "/program/{program}/edit";
	public static final String URL_CONFIGURATION_PROGRAM_OCCUPATIONALxREGISTER_POST = "/program/{program}/occupational-register";
	
	public static final String URL_CONFIGURATION_PROGRAM_MODULUS_GET = "/program/{program}/modulus";
	public static final String URL_CONFIGURATION_PROGRAM_MODULUSxREGISTER_POST = "/program/{program}/modulus-register";
	public static final String URL_CONFIGURATION_PROGRAM_MODULUSxEDIT_GET = "/program/{program}/modulus-edit";//?
	public static final String URL_CONFIGURATION_PROGRAM_MODULUSxEDIT_POST = "/program/{program}/modulus-edit";//?
	public static final String URL_CONFIGURATION_PROGRAM_MODULUSxDELETE_GET = "/program/{program}/modulus-delete";
	
	public static final String URL_CONFIGURATION_PROGRAM_GROUP_GET = "/program/{program}/group";
	public static final String URL_CONFIGURATION_PROGRAM_GROUPxREGISTER_GET = "/program/{program}/group-register";
	public static final String URL_CONFIGURATION_PROGRAM_GROUPxREGISTER_POST = "/program/{program}/group-register";
	public static final String URL_CONFIGURATION_PROGRAM_GROUPxDELETE_GET = "/program/{program}/group-delete";
	
	public static final String URL_CONFIGURATION_MODULUS_COURSE_GET = "/modulus/{modulus}/course";
	public static final String URL_CONFIGURATION_MODULUS_COURSExREGISTER_POST = "/modulus/{modulus}/course-register";
	public static final String URL_CONFIGURATION_MODULUS_COURSExEDIT_GET = "/modulus/{modulus}/course-edit";
	public static final String URL_CONFIGURATION_MODULUS_COURSExEDIT_POST = "/modulus/{modulus}/course-edit";
	public static final String URL_CONFIGURATION_MODULUS_COURSExDELETE_GET = "/modulus/{modulus}/course-delete";
	
	public static final String URL_CONFIGURATION_COURSE_GROUP_GET = "/course/{course}/group";
	public static final String URL_CONFIGURATION_COURSE_GROUPxREGISTER_POST = "/course/{course}/group-register";
	public static final String URL_CONFIGURATION_COURSE_GROUPxDELETE_GET = "/course/{course}/group-delete";
	
	public static final String URL_CONFIGURATION_GROUP_GET = "/group";
	public static final String URL_CONFIGURATION_GROUPxREGISTER_POST = "/group-register";
	public static final String URL_CONFIGURATION_GROUPxEDIT_GET = "/group-edit";
	public static final String URL_CONFIGURATION_GROUPxEDIT_POST = "/group-edit";
	public static final String URL_CONFIGURATION_GROUPxDELETE_GET = "/group-delete";
	
//	Mapeo para el controlador "Gestion de alertas"
	public static final String URL_ALERT_REQUEST = "/alert";
	public static final String URL_ALERT_VIEW_GET = "/view";
	public static final String URL_ALERT_VALIDATE_POST = "/validate";
	public static final String URL_ALERT_OBSERVE_POST = "/observe";
	
//	Mapeo para el controlador "Gestion de mis tramites"
	public static final String URL_MYxPROCEDURES_REQUEST = "/my-procedures";
	public static final String URL_MYxPROCEDURES_VIEW_GET = "/view";
	
//	Mapeo para el controlador "Gestion de matriculas"
	public static final String URL_ENROLLMENT_REQUEST = "/enrollment";
	
	private static final HashMap<String,String> MAPPING_URL = new HashMap<String,String>(){
		private static final long serialVersionUID = -5369868392053811478L;
	{
		put("URL_AUTH_REQUEST",URL_AUTH_REQUEST);
	}};
	
	public static final HashMap<String,String> getMappingUrl() {
		return MAPPING_URL;
	}
}
