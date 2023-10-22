package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Product> product = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int pn = sc.nextInt();
		
		for (int i=1; i<=pn; i++) {
			sc.nextLine();
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char type = sc.next().charAt(0);
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			if (type == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date data = sdf.parse(sc.next());
				product.add(new UsedProduct(name, price, data));
			}
			else if (type == 'i') {
				System.out.print("Customs fee: ");
				double fee = sc.nextDouble();
				product.add(new ImportedProduct(name, price, fee));
			}
			else {
				product.add(new Product(name, price));
			}
		}
		
		System.out.println();
		System.out.println("PRICE TAGS:");
		for (Product x : product) {
			System.out.println(x.priceTag());
		}
		
		sc.close();
	}

}
