package fr.pizzeria.Dao;

import fr.pizzeria.Dao.pizza.IPizzaDao;
import fr.pizzeria.Dao.pizza.PizzaDaoImplFichier;

public class DaoFichierFactory implements DaoFactory {
	private static final String DATA_DIR= "data";

	private IPizzaDao pizzaDao= new PizzaDaoImplFichier(DATA_DIR);
	@Override
	public IPizzaDao getPizzaDao(){
		return pizzaDao;
	}

}
