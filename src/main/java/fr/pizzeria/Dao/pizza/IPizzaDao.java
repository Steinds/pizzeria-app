package fr.pizzeria.Dao.pizza;

import java.util.List;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public interface IPizzaDao {

	List<Pizza> findAllPizzas();

boolean saveNewPizza(Pizza pizza) throws SavePizzaException;

default boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException{
	
	return false;
}
default boolean deletePizza(String codePizza) throws DeletePizzaException{
	
	return false;
}
}