package com.izeye.study.mockito.plugins;

import com.izeye.study.mockito.invocation.MockHandler;
import com.izeye.study.mockito.mock.MockCreationSettings;

/**
 * Clone for {@code org.mockito.plugins.MockMaker}.
 *
 * @author Johnny Lim
 */
public interface MockMaker {

	<T> T createMock(MockCreationSettings<T> creationSettings, MockHandler mockHandler);

}
