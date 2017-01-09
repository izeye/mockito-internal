package com.izeye.study.mockito.internal.creation.cglib.core;

import java.lang.reflect.Modifier;

/**
 * Clone for {@code org.mockito.internal.creation.cglib.core.ReflectUtils}.
 *
 * @author Johnny Lim
 */
public class ReflectUtils {

	public static int findPackageProtected(Class<?>[] classes) {
		for (int i = 0; i < classes.length; i++) {
			if (!Modifier.isPublic(classes[i].getModifiers())) {
				return i;
			}
		}
		return 0;
	}

	public static String[] getNames(Class<?>[] classes) {
		if (classes == null) {
			return null;
		}
		String[] names = new String[classes.length];
		for (int i = 0; i < names.length; i++) {
			names[i] = classes[i].getName();
		}
		return names;
	}

}
