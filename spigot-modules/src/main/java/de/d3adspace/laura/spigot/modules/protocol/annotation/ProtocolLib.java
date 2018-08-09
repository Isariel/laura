package de.d3adspace.laura.spigot.modules.protocol.annotation;

import com.comphenix.protocol.ProtocolLibrary;
import com.google.inject.BindingAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Binding annotation for {@link ProtocolLibrary}'s plugin instance.
 *
 * @author Felix Klauke <info@felix-klauke.de>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@BindingAnnotation
public @interface ProtocolLib {

}
