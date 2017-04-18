package fr.pizzeria.ihm;

import java.util.Scanner; 

import fr.pizzeria.Dao.IPizzaDao;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;


public class MettreAJourOptionMenu extends OptionMenu{

	public MettreAJourOptionMenu(IPizzaDao pizzas,String libelle) {
		super(pizzas, libelle);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute() {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner choiceUser = new Scanner(System.in);
		
		//	listerPizza(listePizza);
		System.out.println("Veuillez choisir la pizza � modifier(CODE)");
		String num = choiceUser.next();
		
		System.out.println("Veuillez saisir le code");
		String code = choiceUser.next();
		System.out.println("Veuillez saisir le nom (sans espace)");
		String nom = choiceUser.next();
		System.out.println("Veuillez saisir le prix");
		double prix = choiceUser.nextDouble();
		System.out.println("Veuillez saisir le type de Pizza: VIANDE POISSON SANS_VIANDE");
		String cat = choiceUser.next();
		
		Pizza upPizza= new Pizza( code, nom, prix,CategoriePizza.valueOf(cat));
		try {
			pizzas.updatePizza(num,upPizza);
		} catch (UpdatePizzaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}

}
