package fr.pizzeria.ihm;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.Dao.pizza.IPizzaDao;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.model.Pizza;


public class SupprimerOptionMenu extends OptionMenu {

	public SupprimerOptionMenu(IPizzaDao pizzas,String libelle) {
		super(pizzas, libelle);
		// TODO Auto-generated constructor stub
	}

	public boolean execute() {
		// TODO Auto-generated method stub
		List<Pizza> listPizza= pizzas.findAllPizzas();
		Scanner choiceUser = new Scanner(System.in);		
		System.out.println("Veuillez choisir la pizza � supprimer(code)");
		String code =choiceUser.next();
		try {
			pizzas.deletePizza(code);
		} catch (DeletePizzaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//listePizza[num] = null;
		return false;
	}

}
