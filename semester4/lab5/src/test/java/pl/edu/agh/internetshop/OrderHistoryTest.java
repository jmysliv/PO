package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class OrderHistoryTest {

    private Order getOrderWithCertainValues(String clientName, String productName, BigDecimal price){
        Address address = mock(Address.class);
        given(address.getName()).willReturn(clientName);
        Shipment shipment = mock(Shipment.class);
        given(shipment.getRecipientAddress()).willReturn(address);
        Order order = mock(Order.class);
        given(order.getShipment()).willReturn(shipment);
        given(order.getPriceWithTaxes()).willReturn(price);
        Product product = mock(Product.class);
        given(product.getName()).willReturn(productName);
        given(order.getProducts()).willReturn(Arrays.asList(product));
        return order;
    }

    @Test
    void testOrdersList() {
        //given
        Order order1 = mock(Order.class);
        Order order2 = mock(Order.class);
        List<Order> expectedOrders = Arrays.asList(order1, order2);
        OrderHistory history = new OrderHistory();
        //when
        history.addOrder(order1);
        history.addOrder(order2);
        //then
        assertEquals(expectedOrders, history.getOrders());
    }

    @Test
    void testSearchingOrders() {
        //given
        BigDecimal minValue = BigDecimal.valueOf(10);
        BigDecimal maxValue = BigDecimal.valueOf(100);
        OrderPriceSearchStrategy orderPriceSearchStrategy = new OrderPriceSearchStrategy(minValue, maxValue);
        ClientNameSearchStrategy clientNameSearchStrategy = new ClientNameSearchStrategy("Mysliwiec");
        ProductNameSearchStrategy productNameSearchStrategy = new ProductNameSearchStrategy("good");
        CompositeSearchStrategy compositeSearchStrategy =
                new CompositeSearchStrategy(Arrays.asList(orderPriceSearchStrategy, clientNameSearchStrategy, productNameSearchStrategy));
        Order order1 = getOrderWithCertainValues("Mysliwiec", "good", new BigDecimal(50));
        Order order2 = getOrderWithCertainValues("Kowalski", "good", new BigDecimal(50));
        Order order3 = getOrderWithCertainValues("Mysliwiec", "bad", new BigDecimal(50));
        Order order4 = getOrderWithCertainValues("Mysliwiec", "good", new BigDecimal(500));
        List<Order> expectedOrders = Arrays.asList(order1);
        OrderHistory history = new OrderHistory();
        //when
        history.addOrder(order1);
        history.addOrder(order2);
        history.addOrder(order3);
        history.addOrder(order4);
        //then
        assertEquals(expectedOrders, history.searchOrders(compositeSearchStrategy));
    }
}