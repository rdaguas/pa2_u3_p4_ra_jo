package com.example.demo.funcional;
@FunctionalInterface
public interface IPersonaPredicate<T> {
	//Interface funcional por LAMBDA
	public boolean evaluar(T arg);

}
