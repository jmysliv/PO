package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class OrderPriceSearchStrategyTest {


    private Order getOrderWithCertainPrice(BigDecimal price) {
        Order order = mock(Order.class);
        given(order.getPriceWithTaxes()).willReturn(price);
        return order;
    }

    @Test
    void testFilter() {
        // given
        BigDecimal minValue = BigDecimal.valueOf(10);
        BigDecimal maxValue = BigDecimal.valueOf(100);
        OrderPriceSearchStrategy orderPriceSearchStrategy = new OrderPriceSearchStrategy(minValue, maxValue);
        // when
        Order order1 = getOrderWithCertainPrice(minValue);
        Order order2 = getOrderWithCertainPrice(maxValue);
        Order order3 = getOrderWithCertainPrice(BigDecimal.valueOf(50));
        Order order4 = getOrderWithCertainPrice(BigDecimal.valueOf(110));
        //then
        assertTrue(orderPriceSearchStrategy.filter(order1));
        assertTrue(orderPriceSearchStrategy.filter(order2));
        assertTrue(orderPriceSearchStrategy.filter(order3));
        assertFalse(orderPriceSearchStrategy.filter(order4));
    }
}