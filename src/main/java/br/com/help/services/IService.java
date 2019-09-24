package br.com.help.services;

import java.util.List;

import javassist.tools.rmi.ObjectNotFoundException;

public interface IService<T> {

	T inserir(T entity) throws ObjectNotFoundException ;

	T atualizar(T entity);

	T buscarPorId(Long id) throws IllegalAccessException;

	void deletarPorId(Long id);

	List<T> buscarTodos();


}
