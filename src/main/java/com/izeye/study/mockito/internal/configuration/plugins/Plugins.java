package com.izeye.study.mockito.internal.configuration.plugins;

import com.izeye.study.mockito.plugins.MockMaker;

/**
 * Clone for {@code org.mockito.internal.configuration.plugins.Plugins}.
 *
 * @author Johnny Lim
 */
public class Plugins {

	private static final PluginRegistry REGISTRY = new PluginRegistry();

	public static MockMaker getMockMaker() {
		return REGISTRY.getMockMaker();
	}

}
