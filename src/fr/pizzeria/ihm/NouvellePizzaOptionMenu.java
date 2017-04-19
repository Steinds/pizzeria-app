package fr.pizzeria.ihm;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.Dao.pizza.IPizzaDao;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class NouvellePizzaOptionMenu extends OptionMenu {

	public NouvellePizzaOptionMenu(IPizzaDao pizzas ,String libelle) {
		super(pizzas , libelle);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute() {
		// TODO Auto-generated method stub
		
		
		Scanner choiceUser = new Scanner(System.in);
		//int a = choiceUser.nextInt();// choiceUser
		String code, nom;
		double prix;
		

		System.out.println("Veuillez saisir le code");
		code = choiceUser.next();
		System.out.println("Veuillez saisir le nom (sans espace)");
		nom = choiceUser.next();
		System.out.println("Veuillez saisir le prix");
		prix = choiceUser.nextDouble();
		System.out.println("Veuillez saisir le type de Pizza: VIANDE POISSON SANS_VIANDE");
		String cat = choiceUser.next();
		List<Pizza> listPizza= pizzas.findAllPizzas();
		int i; int j = 0;
		for( i=0;i<listPizza.size();i++){
			if(listPizza.get(i)!=null){ 
			j++;
		}}
		boolean out;
		try {
			out = pizzas.saveNewPizza(new Pizza(code,nom,prix,CategoriePizza.valueOf(cat)));
			if (out)
				System.out.println("done");
			return out;
		} catch (SavePizzaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return false;
	}
		
}
