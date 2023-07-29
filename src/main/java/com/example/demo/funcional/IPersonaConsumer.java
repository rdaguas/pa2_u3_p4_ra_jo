package com.example.demo.funcional;
@FunctionalInterface
public interface IPersonaConsumer<T> {
	//Interface funcional por LAMBDA
	public void accept(T arg);

}
