package com.system.demo;

public class GenericProjectSystemDefinition {
	
	/**
	 *	Global response for the system
	 **/
	//	Respuestas generales
	//	Respeusta concretada
	public static String SYSTEM_SUCCESS = "Proceso exitoso";
	//	Respuesta de error
	public static String SYSTEM_ERROR = "Fallo general de sistema";
	public static String SYSTEM_ERROR_NO_ID = "No existe Id";
	public static String SYSTEM_ERROR_REGISTER = "Error de registro";
	
	//	Respuestas controlador de autenticación
	//	Respuestas de error
	public static String SYSTEM_ERROR_AUTH = "Login inválido";
	public static String SYSTEM_ERROR_TOKEN = "Error de token";
	
	//	Respuestas controldaro de gestion de usuarios
	//	Respustas concretadas
	public static String SYSTEM_SUCCESS_REGISTER_PERSONxROLE = "Relación registrado exitosamente";
	public static String SYSTEM_SUCCESS_DELETE_PERSONxROLE = "Relación eliminada exitosamente";
	
	//	Respuestas Controlador de gestion académica
	//	Respuestas concretadas
	public static String SYSTEM_SUCCESS_REGISTER_PROGRAM = "Programa registrado exitosamente";
	public static String SYSTEM_SUCCESS_EDIT_PROGRAM = "Programa modificado exitosamente";
	public static String SYSTEM_SUCCESS_DELETE_PROGRAM = "Programa eliminado exitosamente";
	public static String SYSTEM_SUCCESS_EDIT_PERIOD = "Periodo modificado exitosamente";
	public static String SYSTEM_SUCCESS_DELETE_PERIOD = "Periodo eliminado exitosamente";
	//	Respuestas de error
	public static String SYSTEM_ERROR_REGISTER_PROGRAM = "Error de registro en programa";
	public static String SYSTEM_ERROR_NO_PROGRAM = "Programa no encontrado";
	public static String SYSTEM_ERROR_NO_PERIOD = "Periodo no encontrado";
	
	//	Respuestas Controlador de seguridad
	//	Respuestas concretadas
	public static String SYSTEM_SUCCESS_REGISTER_ROLE = "Rol registrado exitosamente";
	public static String SYSTEM_SUCCESS_DELETE_ROLE = "Rol eliminado exitosamente";
	public static String SYSTEM_SUCCESS_EDIT_ROLE = "Rol modificado exitosamente";
	//	Respuestas de error
	public static String SYSTEM_ERROR_ROLE = "Error de procesamiento roles";
	public static String SYSTEM_ERROR_REGISTER_ROLE = "Error de registro en rol";
	public static String SYSTEM_ERROR_NO_ROLE = "Rol no encontrado";
	
	
//	Respuestas Controlador de configuración académica
	//	Respuestas concretadas
	public static String SYSTEM_SUCCESS_REGISTER_MODULUS = "Modulo registrado exitosamente";
	public static String SYSTEM_SUCCESS_DELETE_MODULUS= "Modulo eliminado exitosamente";
	public static String SYSTEM_SUCCESS_REGISTER_COURSE = "Curso registrado exitosamente";
	public static String SYSTEM_SUCCESS_DELETE_COURSE = "Curso eliminado exitosamente";
	//	Respuestas de error
	public static String SYSTEM_ERROR_REGISTER_MODULUS = "Error de registro en modulo";
	public static String SYSTEM_ERROR_REGISTER_COURSE = "Error de registro en curso";
	public static String SYSTEM_ERROR_NO_MODULUS = "Modulo no encontrado";
	
//	Respuestas Controlador de configuración académica
//	Respeusta concretada
	public static String SYSTEM_SUCCESS_ALERT_VALIDATE = "Usuario matriculado exitosamente";
//	Respuestas de error
	public static String SYSTEM_ERROR_ALERT_VALIDATE = "El usuario ya esta matriculado o hay un campo no valido";
	
	/**
	 * Global defined entities
	 */
	
	public static String SYSTEM_TYPE_AUTOGENERATED_DESCRIPTION = "Generado por el sistema";
	public static String SYSTEM_TYPE_DEFINED_USER_DESCRIPTION = "Generado por el usuario";
	public static String SYSTEM_TYPE_LOCAL_GENERATED_DESCRIPTION = "Generado localmente";

}
