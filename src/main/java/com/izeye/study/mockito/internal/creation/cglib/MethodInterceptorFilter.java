package com.izeye.study.mockito.internal.creation.cglib;

import com.izeye.study.mockito.internal.InternalMockHandler;
import com.izeye.study.mockito.mock.MockCreationSettings;

/**
 * Clone for {@code org.mockito.internal.creation.cglib.MethodInterceptorFilter}.
 *
 * @author Johnny Lim
 */
class MethodInterceptorFilter {

	private final InternalMockHandler handler;
	private final MockCreationSettings mockSettings;

	public <T> MethodInterceptorFilter(InternalMockHandler handler, MockCreationSettings<T> mockSettings) {
		this.handler = handler;
		this.mockSettings = mockSettings;
	}

}
