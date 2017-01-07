package com.izeye.study.mockito.mock;

import java.util.Set;

/**
 * Clone for {@code org.mockito.mock.MockCreationSettings}.
 *
 * @author Johnny Lim
 */
public interface MockCreationSettings<T> {

	Class<T> getTypeToMock();

	Set<Class> getExtraInterfaces();

	boolean isUsingConstructor();

}
