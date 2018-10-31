package springmvc.java.domain;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {

	private Map<Product, Integer> items = new HashMap<>();
	
	public void  addProduct(Product product)
	{
		items.put(product, 1);
	}

	public Map<Product, Integer> getItems() {
		return items;
	}

	public void setItems(Map<Product, Integer> items) {
		this.items = items;
	}

	public void clear()
	{
		items.clear();
	}
	
	public double totalCost()
	{
		double totalCost = 0;
		for(Product product : items.keySet())
		{
			totalCost += product.getProductCost();
		}
		return totalCost;
	}
}
