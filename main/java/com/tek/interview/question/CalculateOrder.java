package com.tek.interview.question;

import java.util.LinkedHashMap;
import java.util.Map;
/* ****************************************************************************************

Please remove all bugs from the code below to get the following output:

<pre>

*******Order 1*******
1 book: 13.74
1 music CD: 16.49
1 chocolate bar: 0.94
Sales Tax: 2.84
Total: 28.33
*******Order 2*******
1 imported box of chocolate: 11.5
1 imported bottle of perfume: 54.62
Sales Tax: 8.62
Total: 57.5
*******Order 3*******
1 Imported bottle of perfume: 32.19
1 bottle of perfume: 20.89
1 packet of headache pills: 10.73
1 box of imported chocolates: 12.94
Sales Tax: 8.77
Total: 67.98
Sum of orders: 153.81

</pre>

******************************************************************************************** */
public class CalculateOrder {
	
	
	public static void main(String[] args) throws Exception {

        //Linked Hash Map for preventing the order.
        Map<String, Order> orderMap = new LinkedHashMap<String, Order>();

        Order order = new Order();


        order.addOrderDetails(new OrderDetails(new ItemDetails("book", (float) 12.49), 1));
        order.addOrderDetails(new OrderDetails(new ItemDetails("music CD", (float) 14.99), 1));
        order.addOrderDetails(new OrderDetails(new ItemDetails("chocolate bar", (float) 0.85), 1));

        orderMap.put("Order 1", order);

        // Reuse cart for an other order
        order = new Order();

        order.addOrderDetails(new OrderDetails(new ItemDetails("imported box of chocolate", 10), 1));
        order.addOrderDetails(new OrderDetails(new ItemDetails("imported bottle of perfume", (float) 47.50), 1));

        orderMap.put("Order 2", order);

        // Reuse cart for an other order
        order = new Order();

        order.addOrderDetails(new OrderDetails(new ItemDetails("Imported bottle of perfume", (float) 27.99), 1));
        order.addOrderDetails(new OrderDetails(new ItemDetails("bottle of perfume", (float) 18.99), 1));
        order.addOrderDetails(new OrderDetails(new ItemDetails("packet of headache pills", (float) 9.75), 1));
        order.addOrderDetails(new OrderDetails(new ItemDetails("box of imported chocolates", (float) 11.25), 1));

        orderMap.put("Order 3", order);
        
        CalculateUtil util=new CalculateUtil();

        util.calculate(orderMap);

    }
	

    
}
