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
		T plugin = loadImpl(pluginType);
		if (plugin != null) {
			return plugin;
		}
		try {
			return pluginType.cast(Class.forName(defaultPluginClassName).newInstance());
		}
		catch (ClassNotFoundException ex) {
			throw new RuntimeException(ex);
		}
		catch (InstantiationException ex) {
			throw new RuntimeException(ex);
		}
		catch (IllegalAccessException ex) {
			throw new RuntimeException(ex);
		}
	}

	private <T> T loadImpl(Class<T> pluginType) {
		// TODO: Implement me!
		return null;
	}

}
