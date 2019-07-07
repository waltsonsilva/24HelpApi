package br.com.help.services;

import java.util.List;

public interface IService<T> {

	T inserir(T entity);

	T atualizar(T entity);

	T buscarPorId(int id) throws IllegalAccessException;

	void deletarPorId(int id);

	List<T> buscarTodos();

}
