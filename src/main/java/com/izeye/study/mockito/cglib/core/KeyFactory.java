package com.izeye.study.mockito.cglib.core;

import com.izeye.study.mockito.internal.creation.cglib.core.AbstractClassGenerator;

/**
 * Clone for {@code org.mockito.cglib.core.KeyFactory}.
 *
 * @author Johnny Lim
 */
public abstract class KeyFactory {

	public static KeyFactory create(Class<?> keyInterface) {
		return create(keyInterface, null);
	}

	private static KeyFactory create(Class<?> keyInterface, Customizer customizer) {
		return create(keyInterface.getClassLoader(), keyInterface, customizer);
	}

	private static KeyFactory create(ClassLoader loader, Class<?> keyInterface, Customizer customizer) {
		Generator generator = new Generator();
		generator.setInterface(keyInterface);
		generator.setCustomizer(customizer);
		generator.setClassLoader(loader);
		return generator.create();
	}

	public static class Generator extends AbstractClassGenerator {

		private Class<?> keyInterface;
		private Customizer customizer;

		public void setInterface(Class<?> keyInterface) {
			this.keyInterface = keyInterface;
		}

		public void setCustomizer(Customizer customizer) {
			this.customizer = customizer;
		}

		public KeyFactory create() {
			setNamePrefix(this.keyInterface.getName());
			return (KeyFactory) create(this.keyInterface.getName());
		}
	}

}
