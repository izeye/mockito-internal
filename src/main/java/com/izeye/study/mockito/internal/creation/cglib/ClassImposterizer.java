package com.izeye.study.mockito.internal.creation.cglib;

import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.List;

import com.izeye.study.mockito.cglib.proxy.Enhancer;
import com.izeye.study.mockito.cglib.proxy.Factory;
import com.izeye.study.mockito.internal.creation.instance.Instantiator;
import com.izeye.study.mockito.internal.creation.util.SearchingClassLoader;

/**
 * Clone for {@code org.mockito.internal.creation.cglib.ClassImposterizer}.
 *
 * @author Johnny Lim
 */
class ClassImposterizer {

	private final Instantiator instantiator;

	public ClassImposterizer(Instantiator instantiator) {
		this.instantiator = instantiator;
	}

	public <T> T imposterise(
			MethodInterceptorFilter interceptor, Class<T> mockedType, Collection<Class> ancillaryTypes) {
		return imposterise(interceptor, mockedType, ancillaryTypes.toArray(new Class[ancillaryTypes.size()]));
	}

	private <T> T imposterise(
			MethodInterceptorFilter interceptor, Class<T> mockedType, Class<?>... ancillaryTypes) {
		setConstructorAccessible(mockedType, true);
		Class<Factory> proxyClass = createProxyClass(mockedType, ancillaryTypes);
		// TODO: Implement me!
		setConstructorAccessible(mockedType, false);
		return null;
	}

	private Class<Factory> createProxyClass(Class<?> mockedType, Class<?>... interfaces) {
		if (mockedType == Object.class) {
			mockedType = ClassWithSuperclassToWorkAroundCglibBug.class;
		}
		Enhancer enhancer = new Enhancer() {
			@Override
			protected void filterConstructors(Class<?> sc, List<?> constructors) {
			}
		};
		Class<?>[] allMockedTypes = prepend(mockedType, interfaces);
		enhancer.setClassLoader(SearchingClassLoader.combineLoadersOf(allMockedTypes));
		enhancer.setUseFactory(true);
		if (mockedType.isInterface()) {
			enhancer.setSuperclass(Object.class);
			enhancer.setInterfaces(allMockedTypes);
		}
		else {
			enhancer.setSuperclass(mockedType);
			enhancer.setInterfaces(interfaces);
		}
		// TODO: Implement me!
		return enhancer.createClass();
	}

	private Class<?>[] prepend(Class<?> first, Class<?>... rest) {
		Class<?>[] all = new Class<?>[rest.length + 1];
		all[0] = first;
		System.arraycopy(rest, 0, all, 1, rest.length);
		return all;
	}

	private void setConstructorAccessible(Class<?> mockedType, boolean accessible) {
		for (Constructor<?> constructor : mockedType.getDeclaredConstructors()) {
			constructor.setAccessible(accessible);
		}
	}

	public static class ClassWithSuperclassToWorkAroundCglibBug {
	}

}
