package com.izeye.study.mockito.internal.creation.cglib.core;

/**
 * Clone for {@code org.mockito.internal.creation.cglib.core.AbstractClassGenerator}.
 *
 * @author Johnny Lim
 */
public abstract class AbstractClassGenerator {

	private ClassLoader classLoader;
	private String namePrefix;

	public void setClassLoader(ClassLoader classLoader) {
		this.classLoader = classLoader;
	}

	public void setNamePrefix(String namePrefix) {
		this.namePrefix = namePrefix;
	}

	protected Object create(Object key) {
		// TODO: Implement me!
		return null;
	}

}
