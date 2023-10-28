package coffee.order;

import java.util.LinkedList;
import java.util.Queue;

public class CoffeeOrderBoard {
    private int nextOrderNumber = 1;
    private Queue<Order> orders = new LinkedList<>();


    public void add(Order order) {
        order.setOrderNumber(nextOrderNumber);
        orders.add(order);
        nextOrderNumber++;
    }

    public void deliver() {
        Order nextOrder = orders.poll();
        if (nextOrder != null) {
            System.out.println("The order #" + nextOrder.getOrderNumber() + " for " + nextOrder.getCustomerName() + " is ready");
            orders.remove(nextOrder);
        } else {
            System.out.println("There are no orders to issue");
        }
    }

    public void deliver(int orderNumber) {

        Order foundOrder = null;
        for (Order order : orders) {
            if (order.getOrderNumber() == orderNumber) {
                foundOrder = order;
                break;
            }
        }
        if (foundOrder != null) {
            orders.remove(foundOrder);
            System.out.println("The order #" + foundOrder.getOrderNumber() + " for " + foundOrder.getCustomerName() + " is ready");
        } else {
            System.out.println("The order #" + orderNumber + " not found!");
        }
    }

    public void draw() {
        System.out.println("=============" + '\n' + "Num | Name");
        for (Order order : orders) {
            System.out.println(order.getOrderNumber() + " | " + order.getCustomerName());
        }
    }
}
