package com.izeye.study.mockito.internal;

import com.izeye.study.mockito.MockSettings;
import com.izeye.study.mockito.internal.util.MockUtil;
import com.izeye.study.mockito.mock.MockCreationSettings;

/**
 * Clone for {@code org.mockito.internal.MockitoCore}.
 *
 * @author Johnny Lim
 */
public class MockitoCore {

	private final MockUtil mockUtil = new MockUtil();

	public <T> T mock(Class<T> classToMock, MockSettings mockSettings) {
		// TODO: Implement me!
		MockCreationSettings<T> createSettings = null;
		T mock = this.mockUtil.createMock(createSettings);
		return mock;
	}

}
