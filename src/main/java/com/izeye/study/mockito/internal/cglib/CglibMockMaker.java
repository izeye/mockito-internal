package com.izeye.study.mockito.internal.cglib;

import com.izeye.study.mockito.invocation.MockHandler;
import com.izeye.study.mockito.mock.MockCreationSettings;
import com.izeye.study.mockito.plugins.MockMaker;

/**
 * Clone for {@code org.mockito.internal.cglib.CglibMockMaker}.
 *
 * @author Johnny Lim
 */
public class CglibMockMaker implements MockMaker {

	@Override
	public <T> T createMock(MockCreationSettings<T> createSettings, MockHandler mockHandler) {
		// TODO: Implement me!
		return null;
	}

}
