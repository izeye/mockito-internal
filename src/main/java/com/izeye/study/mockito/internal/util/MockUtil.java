package com.izeye.study.mockito.internal.util;

import com.izeye.study.mockito.internal.configuration.plugins.Plugins;
import com.izeye.study.mockito.invocation.MockHandler;
import com.izeye.study.mockito.mock.MockCreationSettings;
import com.izeye.study.mockito.plugins.MockMaker;

/**
 * Clone for {@code org.mockito.internal.util.MockUtil}.
 *
 * @author Johnny Lim
 */
public class MockUtil {

	private static final MockMaker MOCK_MAKER = Plugins.getMockMaker();

	public <T> T createMock(MockCreationSettings<T> creationSettings) {
		// TODO: Implement me!
		MockHandler mockHandler = null;
		T mock = MOCK_MAKER.createMock(creationSettings, mockHandler);
		return mock;
	}

}
