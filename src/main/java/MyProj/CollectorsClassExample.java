package MyProj;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CollectorsClassExample {

	public static void main(String[] args) {
		List<Product> productList = new ArrayList<Product>();
		productList.add(new Product(1, "HP Laptop", 25000f));
		productList.add(new Product(2, "Dell Laptop", 30000f));
		productList.add(new Product(3, "lenovo Laptop", 28000f));
		productList.add(new Product(4, "Sony Laptop", 90000f));
		
		List<Float> productPriceList =
				productList.stream()
				           .map(x -> x.price) // fetching price
				           .collect(Collectors.toList()); // Collecting as list
		System.out.println(productPriceList); // displaying data
	}

}
