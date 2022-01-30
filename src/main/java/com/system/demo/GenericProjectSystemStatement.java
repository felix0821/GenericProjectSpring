package com.system.demo;

public class GenericProjectSystemStatement {
	
	/**
	 *	Global response for the system
	 **/
	//	Respuestas generales
	//	Respuesta de error
	public static String SYSTEM_ERROR = "Error general de sistema";
	public static String SYSTEM_ERROR_NO_ID = "No existe Id";
	public static String SYSTEM_ERROR_REGISTER = "Error de registro";
	
	//	Respuestas controlador de autenticación
	public static String SYSTEM_ERROR_AUTH = "Error de login";
	public static String SYSTEM_ERROR_TOKEN = "Error de token";
	
	//	Respuestas Controlador de gestion académica
	//	Respuestas concretadas
	public static String SYSTEM_SUCCESS_REGISTER_PROGRAM = "Programa registrado exitosamente";
	public static String SYSTEM_SUCCESS_EDIT_PROGRAM = "Programa modificado exitosamente";
	public static String SYSTEM_SUCCESS_DELETE_PROGRAM = "Programa eliminado exitosamente";
	//	Respuestas de error
	public static String SYSTEM_ERROR_NO_PROGRAM = "Programa no encontrado";
	
	
	
	/**
	 *	Predefined resources for the system
	 **/
	//public static final
	
	/**
	 *	Route mapping for the system
	 **/
	//	Mapeo para el controlador "Autenticación"
	public static final String URL_AUTH_REQUEST = "/auth";
	public static final String URL_AUTH_LOGIN_POST = "/login";
	public static final String URL_AUTH_ERROR_GET = "/error";
	//	Mapeo para el controlador "Persona"
	public static final String URL_PERSON_REQUEST = "/user";
	public static final String URL_PERSON_PROFILE_GET = "/profile";
	public static final String URL_PERSON_PROFILE_EDIT_POST = "/profile/edit";
	public static final String URL_PERSON_REGISTER_POST = "/register";
	public static final String URL_PERSON_DELETE_GET = "/deleteUser/{id}";
	public static final String URL_PERSON_EDIT_GET = "/editUser/{id}";
	public static final String URL_PERSON_EDIT_POST = "/editUser";
	//	Mapeo para el controlador "Solicitud"
	public static final String URL_REQUISITION_REQUEST = "/requisition";
	public static final String URL_REQUISITION_STATUS_GET = "/status";
	public static final String URL_REQUISITION_REGISTER_GET = "/register/{requisition}";
	//	Mapeo para el controlador "Movimiento financiero"
	public static final String URL_FINANCIAL_MOVEMENT_REQUEST = "/financial-movement";
	//	Mapeo para el controlador "Control documental"
	public static final String URL_DOCUMENTARY_REQUEST = "/documentary";
	//	Mapeo para el controlador "Gestion academica"
	public static final String URL_ACADEMIC_REQUEST = "/academic";
	public static final String URL_ACADEMIC_EDITxPROGRAM_GET = "/edit-program/{id}";
	public static final String URL_ACADEMIC_EDITxPROGRAM_POST = "/edit-program";
	public static final String URL_ACADEMIC_PROGRAM_REGISTER_POST = "/program/register";
	public static final String URL_ACADEMIC_PROGRAM_VIEW_GET = "/program/view/{id}";
	public static final String URL_ACADEMIC_PROGRAM_EDIT_POST = "/program/edit";
	public static final String URL_ACADEMIC_PROGRAM_DELETE_GET = "/program/delete/{id}";
	public static final String URL_ACADEMIC_PROGRAMxOCCUPATIONAL_REGISTER_POST = "/program-occupational/register";
	public static final String URL_ACADEMIC_PEDAGOGICALxPERIOD_REGISTER_POST = "/pedagogical-period/register";
	public static final String URL_ACADEMIC_PROGRAMxPERIOD_GET = "/program-period/{id}";
	public static final String URL_ACADEMIC_PROGRAMxPERIOD_VIEW_GET = "/program-period/view/{id}";

}
