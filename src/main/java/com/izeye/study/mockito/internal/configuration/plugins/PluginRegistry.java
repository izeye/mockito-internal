package com.izeye.study.mockito.internal.configuration.plugins;

import com.izeye.study.mockito.internal.creation.cglib.CglibMockMaker;
import com.izeye.study.mockito.plugins.MockMaker;
import com.izeye.study.mockito.plugins.PluginSwitch;

/**
 * Clone for {@code org.mockito.internal.configuration.plugins.PluginRegistry}.
 *
 * @author Johnny Lim
 */
class PluginRegistry {

	private final PluginSwitch pluginSwitch =
			new PluginLoader(new DefaultPluginSwitch()).loadPlugin(
					PluginSwitch.class, DefaultPluginSwitch.class.getName());

	private MockMaker mockMaker =
			new PluginLoader(this.pluginSwitch).loadPlugin(
					MockMaker.class, CglibMockMaker.class.getName());

	MockMaker getMockMaker() {
		return this.mockMaker;
	}

}
