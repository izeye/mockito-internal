package com.izeye.study.mockito.internal.creation.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Clone for {@code org.mockito.internal.creation.util.SearchingClassLoader}.
 *
 * @author Johnny Lim
 */
public class SearchingClassLoader extends ClassLoader {

	private final ClassLoader nextToSearch;

	public SearchingClassLoader(ClassLoader parent, ClassLoader nextToSearch) {
		super(parent);

		this.nextToSearch = nextToSearch;
	}

	public static ClassLoader combineLoadersOf(Class<?>... classes) {
		List<ClassLoader> loaders = new ArrayList<>();

		for (Class<?> clazz : classes) {
			addIfNewElement(loaders, clazz.getClassLoader());
		}
		return combine(loaders);
	}

	private static ClassLoader combine(List<ClassLoader> parentLoaders) {
		ClassLoader loader = parentLoaders.get(parentLoaders.size() - 1);
		for (int i = parentLoaders.size() - 2; i >= 0; i--) {
			loader = new SearchingClassLoader(parentLoaders.get(i), loader);
		}
		return loader;
	}

	private static void addIfNewElement(List<ClassLoader> loaders, ClassLoader loader) {
		if (loader != null && !loaders.contains(loader)) {
			loaders.add(loader);
		}
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		if (this.nextToSearch != null) {
			return nextToSearch.loadClass(name);
		}
		return super.findClass(name);
	}

}
