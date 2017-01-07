package com.izeye.study.mockito.internal.creation.cglib;

import java.util.Collection;

import com.izeye.study.mockito.internal.creation.instance.Instantiator;

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
		// TODO: Implement me!
		return null;
	}

}
