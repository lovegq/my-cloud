package com.zhb.cloud.common.service;

public interface Function<T, E> {
	public T callback(E e);

}
