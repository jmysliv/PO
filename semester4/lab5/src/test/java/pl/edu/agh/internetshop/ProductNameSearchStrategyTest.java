package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class ProductNameSearchStrategyTest {

    private Order getOrderWithCertainProductName(String name) {
        Product product = mock(Product.class);
        given(product.getName()).willReturn(name);
        return new Order(Collections.singletonList(product));
    }

    @Test
    void testFilter() {
        // given
        ProductNameSearchStrategy productNameSearchStrategy = new ProductNameSearchStrategy("good");
        // when
        Order order1 = getOrderWithCertainProductName("good");
        Order order2 = getOrderWithCertainProductName("bad");
        //then
        assertTrue(productNameSearchStrategy.filter(order1));
        assertFalse(productNameSearchStrategy.filter(order2));
    }
}