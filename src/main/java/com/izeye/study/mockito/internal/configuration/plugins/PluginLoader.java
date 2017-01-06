package com.izeye.study.mockito.internal.configuration.plugins;

import com.izeye.study.mockito.plugins.PluginSwitch;

/**
 * Clone for {@code org.mockito.internal.configuration.plugins.PluginLoader}.
 *
 * @author Johnny Lim
 */
class PluginLoader {

	private final PluginSwitch pluginSwitch;

	public PluginLoader(PluginSwitch pluginSwitch) {
		this.pluginSwitch = pluginSwitch;
	}

	<T> T loadPlugin(Class<T> pluginType, String defaultPluginClassName) {
		// TODO: Implement me!
		return null;
	}

}
