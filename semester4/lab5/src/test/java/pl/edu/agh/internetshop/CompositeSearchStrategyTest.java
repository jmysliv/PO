package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class CompositeSearchStrategyTest {

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
    void filter() {
        // given
        BigDecimal minValue = BigDecimal.valueOf(10);
        BigDecimal maxValue = BigDecimal.valueOf(100);
        OrderPriceSearchStrategy orderPriceSearchStrategy = new OrderPriceSearchStrategy(minValue, maxValue);
        ClientNameSearchStrategy clientNameSearchStrategy = new ClientNameSearchStrategy("Mysliwiec");
        ProductNameSearchStrategy productNameSearchStrategy = new ProductNameSearchStrategy("good");
        CompositeSearchStrategy compositeSearchStrategy =
                new CompositeSearchStrategy(Arrays.asList(orderPriceSearchStrategy, clientNameSearchStrategy, productNameSearchStrategy));
        // when
        Order order1 = getOrderWithCertainValues("Mysliwiec", "good", new BigDecimal(50));
        Order order2 = getOrderWithCertainValues("Kowalski", "good", new BigDecimal(50));
        Order order3 = getOrderWithCertainValues("Mysliwiec", "bad", new BigDecimal(50));
        Order order4 = getOrderWithCertainValues("Mysliwiec", "good", new BigDecimal(500));
        //then
        assertTrue(compositeSearchStrategy.filter(order1));
        assertFalse(compositeSearchStrategy.filter(order2));
        assertFalse(compositeSearchStrategy.filter(order3));
        assertFalse(compositeSearchStrategy.filter(order4));
    }
}