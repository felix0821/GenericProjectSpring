package com.system.demo.security;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.log.LogMessage;
import org.springframework.util.ClassUtils;

public class AclFilterProcessor {
	
	public void operate(Method method, Class<?> targetClass) {
		if (method.getDeclaringClass() == Object.class) {
			System.out.println("vacio");
		}
		LogMessage.format("Looking for Pre/Post annotations for method '%s' on target class '%s'",
				method.getName(), targetClass);
		AclFilter aclFilter = findAnnotation(method, targetClass, AclFilter.class);
		if (aclFilter == null) {
			System.out.println("No se encontraron anotaciones de expresión");
		}
		
	}
	
	private <A extends Annotation> A findAnnotation(Method method, Class<?> targetClass, Class<A> annotationClass) {
		// El método puede estar en una interfaz, pero necesitamos atributos de la clase de destino.
		// Si la clase de destino es nula, el método no cambiará.
		Method specificMethod = ClassUtils.getMostSpecificMethod(method, targetClass);
		A annotation = AnnotationUtils.findAnnotation(specificMethod, annotationClass);
		if (annotation != null) {
			LogMessage.format("%s found on specific method: %s", annotation, specificMethod);
			return annotation;
		}
		// Comprueba el método original (por ejemplo, la interfaz)
		if (specificMethod != method) {
			annotation = AnnotationUtils.findAnnotation(method, annotationClass);
			if (annotation != null) {
				LogMessage.format("%s found on: %s", annotation, method);
				return annotation;
			}
		}
		// Verifiqua el nivel de clase (tenga en cuenta que declara Class, no targetClass, que en
		// realidad puede no implementar el método)
		annotation = AnnotationUtils.findAnnotation(specificMethod.getDeclaringClass(), annotationClass);
		if (annotation != null) {
			LogMessage.format("%s found on: %s", annotation, specificMethod.getDeclaringClass().getName());
			return annotation;
		}
		return null;
	}

}
