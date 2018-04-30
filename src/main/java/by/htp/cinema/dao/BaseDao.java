package by.htp.cinema.dao;

import java.util.List;

import by.htp.cinema.domain.BaseEntity;

public interface BaseDao <T extends BaseEntity>{
	void create (T entity);
	T read(int id);
	void update(T entity);
	void delete(T entity);
	List<T> readAll();
}
