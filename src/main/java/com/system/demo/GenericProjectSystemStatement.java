package com.system.demo;

public class GenericProjectSystemStatement {
	
	/**
	 *	predefined resources for the system
	 **/
	//public static final
	
	/**
	 *	Route mapping for the system
	 **/
	//	Mapeo para el controlador "Autenticación"
	public static final String URL_AUTH_REQUEST = "/auth";
	public static final String URL_AUTH_LOGIN_POST = "/login";
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

}
