package com.izeye.study.mockito.internal.creation.settings;

import java.util.LinkedHashSet;
import java.util.Set;

import com.izeye.study.mockito.mock.MockCreationSettings;
import com.izeye.study.mockito.mock.MockName;
import com.izeye.study.mockito.mock.SerializableMode;
import com.izeye.study.mockito.stubbing.Answer;

/**
 * Clone for {@code org.mockito.internal.creation.settings.CreationSettings}.
 *
 * @author Johnny Lim
 */
public class CreationSettings<T> implements MockCreationSettings<T> {

	private Class<T> typeToMock;
	private Set<Class> extraInterfaces = new LinkedHashSet<>();
	private String name;
	protected Answer<Object> defaultAnswer;
	private MockName mockName;
	private SerializableMode serializableMode = SerializableMode.NONE;
	private boolean useConstructor;

	public CreationSettings() {
	}

	public CreationSettings(CreationSettings copy) {
		this.typeToMock = copy.getTypeToMock();
		this.extraInterfaces = copy.getExtraInterfaces();
		this.name = copy.getName();
		// TODO: Implement me!
		this.defaultAnswer = copy.getDefaultAnswer();
		this.mockName = copy.getMockName();
		this.serializableMode = copy.getSerializableMode();
		this.useConstructor = copy.isUsingConstructor();
	}

	@Override
	public Class<T> getTypeToMock() {
		return this.typeToMock;
	}

	public CreationSettings<T> setTypeToMock(Class<T> typeToMock) {
		this.typeToMock = typeToMock;
		return this;
	}

	@Override
	public Set<Class> getExtraInterfaces() {
		return this.extraInterfaces;
	}

	public CreationSettings<T> setExtraInterfaces(Set<Class> extraInterfaces) {
		this.extraInterfaces = extraInterfaces;
		return this;
	}

	public String getName() {
		return this.name;
	}

	public Answer<Object> getDefaultAnswer() {
		return this.defaultAnswer;
	}

	public MockName getMockName() {
		return this.mockName;
	}

	public void setMockName(MockName mockName) {
		this.mockName = mockName;
	}

	public boolean isSerializable() {
		return this.serializableMode != SerializableMode.NONE;
	}

	public SerializableMode getSerializableMode() {
		return this.serializableMode;
	}

	@Override
	public boolean isUsingConstructor() {
		return this.useConstructor;
	}

}
