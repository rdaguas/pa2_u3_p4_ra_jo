package com.example.demo.funcional;

@FunctionalInterface
public interface IPersonaBIPredicate<T,R> {
	public boolean evaluar(T arg1, R arg2);

}
