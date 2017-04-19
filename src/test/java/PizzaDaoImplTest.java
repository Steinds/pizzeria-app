import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import fr.pizzeria.Dao.pizza.IPizzaDao;
import fr.pizzeria.Dao.pizza.PizzaDaoImpl;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImplTest {

	@Test
	public void test() {
		IPizzaDao dao = new PizzaDaoImpl();
		
		Assert.assertTrue("le tableau n'est pas vide",dao.findAllPizzas().isEmpty());
		dao.saveNewPizza(new Pizza("PEP", "Pépéroni", 12.50F,CategoriePizza.VIANDE));
		dao.saveNewPizza(new Pizza("MAR", "Margherita", 14.00F,CategoriePizza.VIANDE));
		dao.saveNewPizza(new Pizza("REI", "La Reine", 11.50F,CategoriePizza.VIANDE));
		dao.saveNewPizza(new Pizza("FRO", "La 4 fromages", 12.00F,CategoriePizza.SANS_VIANDE));
		dao.saveNewPizza(new Pizza("CAN", "La cannibale", 12.50F,CategoriePizza.VIANDE));
		dao.saveNewPizza(new Pizza("SAV", "La savoyarde", 13.00F,CategoriePizza.SANS_VIANDE));
		dao.saveNewPizza(new Pizza("ORI", "L’orientale", 13.50F,CategoriePizza.VIANDE));
		dao.saveNewPizza(new Pizza("IND", "L’indienne", 14.00F,CategoriePizza.VIANDE));
		Assert.assertTrue("taille invalide", dao.findAllPizzas().size()==8);
		
	}

}
