package fr.pizzeria.ihm;

import fr.pizzeria.Dao.pizza.IPizzaDao;


public abstract class OptionMenu{
 
 IPizzaDao pizzas;
 private String libelle;
 


public OptionMenu(IPizzaDao pizzas,String libelle) {
	super();
	this.libelle = libelle;
	this.pizzas = pizzas;
}

public abstract boolean execute() ;

public String getLibelle() {
	return libelle;
}

public void setLibelle(String libelle) {
	this.libelle = libelle;
}
 
}
