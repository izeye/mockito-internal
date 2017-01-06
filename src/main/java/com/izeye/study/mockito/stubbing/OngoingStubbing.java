package com.izeye.study.mockito.stubbing;

/**
 * Clone for {@code org.mockito.stubbing.OngoingStubbing}.
 *
 * @author Johnny Lim
 */
public interface OngoingStubbing<T> {

	OngoingStubbing<T> thenReturn(T value);

}
