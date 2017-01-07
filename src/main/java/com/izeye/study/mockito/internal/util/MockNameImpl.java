package com.izeye.study.mockito.internal.util;

import com.izeye.study.mockito.mock.MockName;

/**
 * Clone for {@code org.mockito.internal.util.MockNameImpl}.
 *
 * @author Johnny Lim
 */
public class MockNameImpl implements MockName {

	private final String mockName;
	private boolean defaultName;

	public MockNameImpl(String mockName, Class<?> classToMock) {
		if (mockName == null) {
			this.mockName = toInstanceName(classToMock);
			this.defaultName = true;
		}
		else {
			this.mockName = mockName;
		}
	}

	private String toInstanceName(Class<?> clazz) {
		String className = clazz.getSimpleName();
		if (className.length() == 0) {
			// Handle an anonymous class.
			className = clazz.getSuperclass().getSimpleName();
		}
		return className.substring(0, 1).toLowerCase() + className.substring(1);
	}

}
