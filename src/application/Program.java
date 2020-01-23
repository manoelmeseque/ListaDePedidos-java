package application;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Nome: ");
		String name = sc.nextLine();
		System.out.println("E-mail: ");
		String email = sc.nextLine();
		
		Client client = new Client(name, email);
		
		System.out.println("Faça seu pedido ");
		System.out.println("Status: ");
		String s = sc.nextLine();
		OrderStatus status = OrderStatus.valueOf(s);
		
		System.out.println("Quantos produtos você adicionar ?");
		int totalProdutos = sc.nextInt();
		Date date = new Date();
		Order order = new Order(date, status, client);
		
		
		for(int i = 1; i <= totalProdutos; i++) {
			System.out.println("#" + i + " Produto");
			sc.nextLine();
			System.out.println("Nome do produto: ");
			name = sc.nextLine();
			System.out.println("Preço: ");
			double p = sc.nextDouble();
			System.out.println("Quantidade: ");
			int qtd = sc.nextInt();
			Product product = new Product(name, p);
			OrderItem item = new OrderItem(qtd, product);
			order.addItems(item);

		}
		
		System.out.println(order);
		
		sc.close();
		
		
		
	}

}
