package com.izeye.study.mockito.internal;

import com.izeye.study.mockito.MockSettings;
import com.izeye.study.mockito.internal.creation.MockSettingsImpl;
import com.izeye.study.mockito.internal.util.MockUtil;
import com.izeye.study.mockito.mock.MockCreationSettings;

/**
 * Clone for {@code org.mockito.internal.MockitoCore}.
 *
 * @author Johnny Lim
 */
public class MockitoCore {

	private final MockUtil mockUtil = new MockUtil();

	public <T> T mock(Class<T> typeToMock, MockSettings mockSettings) {
		MockSettingsImpl impl = MockSettingsImpl.class.cast(mockSettings);
		MockCreationSettings<T> creationSettings = impl.confirm(typeToMock);
		T mock = this.mockUtil.createMock(creationSettings);
		// TODO: Implement me!
		return mock;
	}

}
