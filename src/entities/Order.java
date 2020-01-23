package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss");
	
	private Date moment;
	private OrderStatus status;
	
	private Client client = new Client();
	private List<OrderItem> items = new ArrayList();
	
	public Order() {
		
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public void addItems(OrderItem item) {
		items.add(item);
	}
	
	public void removeItems(OrderItem item) {
		items.remove(item);
	}
	
	public Double total() {
		double soma = 0.0;
		for(OrderItem i: items) {
			soma += i.subTotal();
		}
		return soma;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Momento do pedido: " + sdf.format(moment) + "\n");
		sb.append("Status: " + status + "\n");
		sb.append("Client: " + client + "\n");
		sb.append("Items: \n");
		for(OrderItem item: items) {
			sb.append(item + "\n");
		}
		return sb.toString();
	}
	
	
	
}
