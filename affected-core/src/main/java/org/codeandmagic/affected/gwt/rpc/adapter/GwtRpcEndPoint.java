package org.codeandmagic.affected.gwt.rpc.adapter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target( { ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface GwtRpcEndPoint {
	String value() default "";
}
