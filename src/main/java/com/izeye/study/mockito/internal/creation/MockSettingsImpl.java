package com.izeye.study.mockito.internal.creation;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.izeye.study.mockito.MockSettings;
import com.izeye.study.mockito.internal.creation.settings.CreationSettings;
import com.izeye.study.mockito.internal.util.MockNameImpl;
import com.izeye.study.mockito.mock.MockCreationSettings;
import com.izeye.study.mockito.stubbing.Answer;

/**
 * Clone for {@code org.mockito.internal.creation.MockSettingsImpl}.
 *
 * @author Johnny Lim
 */
public class MockSettingsImpl<T> extends CreationSettings<T> implements MockSettings {

	public <T> MockCreationSettings<T> confirm(Class<T> typeToMock) {
		return validatedSettings(typeToMock, this);
	}

	private static <T> CreationSettings<T> validatedSettings(
			Class<T> typeToMock, CreationSettings source) {
		// TODO: Implement me!
		CreationSettings<T> settings = new CreationSettings<T>(source);
		settings.setMockName(new MockNameImpl(source.getName(), typeToMock));
		settings.setTypeToMock(typeToMock);
		settings.setExtraInterfaces(prepareExtraInterfaces(source));
		return settings;
	}

	private static Set<Class> prepareExtraInterfaces(CreationSettings settings) {
		Set<Class> interfaces = new HashSet<>(settings.getExtraInterfaces());
		if (settings.isSerializable()) {
			interfaces.add(Serializable.class);
		}
		return interfaces;
	}

	public MockSettings defaultAnswer(Answer<Object> defaultAnswer) {
		this.defaultAnswer = defaultAnswer;
		// TODO: Implement me!
		return this;
	}

}
