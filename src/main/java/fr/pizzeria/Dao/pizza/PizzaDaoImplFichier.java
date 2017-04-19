package fr.pizzeria.Dao.pizza;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImplFichier implements IPizzaDao {
private String dataDir;

/*
	
public static void main(String[] args) {
	new PizzaDaoImplFichier().findAllPizzas().stream().forEach(p->System.out.println(p.toString()));
}
	*/

	
	
public PizzaDaoImplFichier(String dataDir) {
	super();
	this.dataDir = dataDir;
}


@Override
public List<Pizza> findAllPizzas() {

	try {
		return Files.list(Paths.get(dataDir)).map(path -> {
			
			String code = path.toFile().getName().replaceAll(".txt","");
			
			try {
				String[] valueTab = Files.lines(path)
											.findFirst()
											.orElseThrow(() -> new StockageException("fichier vide"))
											.split(";");
				
				return new Pizza(code, valueTab[0], Double.valueOf(valueTab[1]),  CategoriePizza.valueOf(valueTab[2]));
				
			} catch (IOException e) {
				throw new StockageException(e);
			}
		}).collect(Collectors.toList());
	} catch (IOException e) {
		throw new StockageException(e);
	}
}
	

	@Override
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException {
	
		
		       File f = new File(dataDir +"/"+pizza.getCode()+".txt");
		       try {
		    	   FileWriter printer= new FileWriter(f);
		    	  
		    	   printer.write(pizza.getNom()+";"+Double.toString(pizza.getPrix())+";"+pizza.getCat());
		    	   
		    	   printer.close();
		    	   return false;
			} catch (IOException e) {
				throw new SavePizzaException("erreur création pizza");
			}
		       
	}
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException{
		
		return false;
	}
	 public boolean deletePizza(String codePizza) throws DeletePizzaException{
		
		return false;
	}
}
