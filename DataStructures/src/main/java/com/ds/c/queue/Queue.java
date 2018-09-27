package com.ds.c.queue;

public interface Queue<T> {

	void push(T value);

	T poll();

	Integer size();

	Boolean isEmpty();

}