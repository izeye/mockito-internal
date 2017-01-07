package com.izeye.study.mockito;

import com.izeye.study.mockito.internal.stubbing.defaultanswers.GloballyConfiguredAnswer;
import com.izeye.study.mockito.stubbing.Answer;

/**
 * Clone for {@code org.mockito.Answers}.
 *
 * @author Johnny Lim
 */
public enum Answers {

	RETURNS_DEFAULTS(new GloballyConfiguredAnswer());

	private final Answer<Object> implementation;

	Answers(Answer<Object> implementation) {
		this.implementation = implementation;
	}

	public Answer<Object> get() {
		return this.implementation;
	}

}
