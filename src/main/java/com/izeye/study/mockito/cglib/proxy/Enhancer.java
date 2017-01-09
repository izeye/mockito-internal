package com.izeye.study.mockito.cglib.proxy;

import java.util.List;

import com.izeye.study.mockito.asm.Type;
import com.izeye.study.mockito.cglib.core.KeyFactory;
import com.izeye.study.mockito.internal.creation.cglib.core.AbstractClassGenerator;
import com.izeye.study.mockito.internal.creation.cglib.core.ReflectUtils;

/**
 * Clone for {@code org.mockito.cglib.proxy.Enhancer}.
 *
 * @author Johnny Lim
 */
public class Enhancer extends AbstractClassGenerator {

	private static final EnhancerKey KEY_FACTORY =
			(EnhancerKey) KeyFactory.create(EnhancerKey.class);

	public interface EnhancerKey {
		Object newInstance(
				String type,
				String[] interfaces,
				CallbackFilter filter,
				Type[] callbackTypes,
				boolean useFactory,
				boolean interceptDuringConstruction,
				Long serialVersionUID);
	}

	private ClassLoader classLoader;
	private Class<?> superclass;
	private Class[] interfaces;
	private CallbackFilter filter;
	private Type[] callbackTypes;
	private boolean classOnly;
	private boolean useFactory = true;
	private Long serialVersionUID;
	private boolean interceptDuringConstruction = true;

	protected void filterConstructors(Class<?> sc, List<?> constructors) {
		// TODO: Implement me!
	}

	public void setClassLoader(ClassLoader classLoader) {
		this.classLoader = classLoader;
	}

	public void setUseFactory(boolean useFactory) {
		this.useFactory = useFactory;
	}

	public void setSuperclass(Class<?> superclass) {
		if (superclass != null && superclass.isInterface()) {
			setInterfaces(new Class[]{ superclass });
		}
		else if (Object.class.equals(superclass)) {
			this.superclass = null;
		}
		else {
			this.superclass = superclass;
		}
	}

	public void setInterfaces(Class<?>[] interfaces) {
		this.interfaces = interfaces;
	}

	public Class createClass() {
		this.classOnly = true;
		return (Class) createHelper();
	}

	private Object createHelper() {
		validate();
		if (this.superclass != null) {
			setNamePrefix(this.superclass.getName());
		}
		else if (this.interfaces != null) {
			setNamePrefix(this.interfaces[ReflectUtils.findPackageProtected(this.interfaces)].getName());
		}
		return super.create(KEY_FACTORY.newInstance(
				this.superclass != null ? this.superclass.getName() : null,
				ReflectUtils.getNames(this.interfaces),
				this.filter,
				this.callbackTypes,
				this.useFactory,
				this.interceptDuringConstruction,
				this.serialVersionUID));
	}

	private void validate() {
		// TODO: Implement me!
	}

}
