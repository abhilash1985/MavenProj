package MyProj;

import java.util.ArrayList;
import java.util.List;

public class JavaStreamExample {

	public static void main(String[] args) {
		List<Product> productList = new ArrayList<Product>();
		productList.add(new Product(1, "HP Laptop", 25000f));
		productList.add(new Product(2, "Dell Laptop", 30000f));
		productList.add(new Product(3, "lenovo Laptop", 28000f));
		productList.add(new Product(4, "Sony Laptop", 90000f));
		
		List<Float> productPriceList = new ArrayList<Float>();
		for(Product product: productList) { // filtering data of list
			if(product.price < 30000) {
				productPriceList.add(product.price); // adding price to productPriceList
			}
		}
		System.out.println(productPriceList); // displaying data
	}
}
