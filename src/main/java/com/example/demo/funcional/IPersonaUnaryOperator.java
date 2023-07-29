package com.example.demo.funcional;
@FunctionalInterface
public interface IPersonaUnaryOperator<T> {
	//Interface funcional por LAMBDA
	public T aplicar(T arg);

}
