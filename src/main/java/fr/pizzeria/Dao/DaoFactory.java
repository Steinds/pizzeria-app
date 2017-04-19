package fr.pizzeria.Dao;

import fr.pizzeria.Dao.pizza.IPizzaDao;

public interface DaoFactory {
	IPizzaDao getPizzaDao();
}
