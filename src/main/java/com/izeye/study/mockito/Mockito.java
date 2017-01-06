package com.izeye.study.mockito;

import com.izeye.study.mockito.internal.MockitoCore;
import com.izeye.study.mockito.stubbing.OngoingStubbing;

/**
 * Clone for {@code org.mockito.Mockito}.
 *
 * @author Johnny Lim
 */
public class Mockito {

	private static final MockitoCore MOCKITO_CORE = new MockitoCore();

	public static <T> T mock(Class<T> classToMock) {
		return mock(classToMock, withSettings());
	}

	public static <T> T mock(Class<T> classToMock, MockSettings mockSettings) {
		return MOCKITO_CORE.mock(classToMock, mockSettings);
	}

	public static MockSettings withSettings() {
		// TODO: Implement me!
		return null;
	}

	public static <T> OngoingStubbing<T> when(T methodCall) {
		// TODO: Implement me!
		return null;
	}

}
