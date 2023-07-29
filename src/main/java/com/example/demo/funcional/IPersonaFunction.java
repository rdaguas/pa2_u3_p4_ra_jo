package com.example.demo.funcional;
@FunctionalInterface
public interface IPersonaFunction<T, R> {
	//Interface funcional por LAMBDA
	public T aplicar(R arg);

}
