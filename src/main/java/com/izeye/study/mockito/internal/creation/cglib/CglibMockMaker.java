package com.izeye.study.mockito.internal.creation.cglib;

import com.izeye.study.mockito.internal.InternalMockHandler;
import com.izeye.study.mockito.internal.creation.instance.Instantiator;
import com.izeye.study.mockito.internal.creation.instance.InstantiatorProvider;
import com.izeye.study.mockito.invocation.MockHandler;
import com.izeye.study.mockito.mock.MockCreationSettings;
import com.izeye.study.mockito.plugins.MockMaker;

/**
 * Clone for {@code org.mockito.internal.creation.cglib.CglibMockMaker}.
 *
 * @author Johnny Lim
 */
public class CglibMockMaker implements MockMaker {

	@Override
	public <T> T createMock(MockCreationSettings<T> creationSettings, MockHandler mockHandler) {
		InternalMockHandler mockitoHandler = cast(mockHandler);
		// TODO: Implement me!
		Instantiator instantiator = new InstantiatorProvider().getInstantiator(creationSettings);
		ClassImposterizer classImposterizer = new ClassImposterizer(instantiator);
		MethodInterceptorFilter interceptor =
				new MethodInterceptorFilter(mockitoHandler, creationSettings);
		return classImposterizer.imposterise(
				interceptor, creationSettings.getTypeToMock(), creationSettings.getExtraInterfaces());
	}

	private InternalMockHandler cast(MockHandler mockHandler) {
		return (InternalMockHandler) mockHandler;
	}

}
