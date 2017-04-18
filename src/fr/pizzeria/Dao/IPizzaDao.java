package fr.pizzeria.Dao;

import java.util.List;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public interface IPizzaDao {

	List<Pizza> findAllPizzas();

boolean saveNewPizza(Pizza pizza) throws SavePizzaException;

default boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException{
	// TODO Auto-generated method stub
	return false;
}
default boolean deletePizza(String codePizza) throws DeletePizzaException{
	// TODO Auto-generated method stub
	return false;
}
}