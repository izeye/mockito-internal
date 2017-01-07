package com.izeye.study.mockito.internal.creation.instance;

import com.izeye.study.mockito.mock.MockCreationSettings;

/**
 * Clone for {@code org.mockito.internal.creation.instance.InstantiatorProvider}.
 *
 * @author Johnny Lim
 */
public class InstantiatorProvider {

	private static final Instantiator INSTANCE = new ObjenesisInstatiator();

	public Instantiator getInstantiator(MockCreationSettings createSettings) {
		if (createSettings.isUsingConstructor()) {
			// TODO: Implement me!
			return null;
		}
		else {
			return INSTANCE;
		}
	}

}
