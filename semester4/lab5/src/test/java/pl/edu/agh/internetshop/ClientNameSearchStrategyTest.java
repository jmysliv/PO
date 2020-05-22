package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class ClientNameSearchStrategyTest {

    private Order getOrderWithCertainClientName(String name) {
        Address address = mock(Address.class);
        given(address.getName()).willReturn(name);
        Shipment shipment = mock(Shipment.class);
        given(shipment.getRecipientAddress()).willReturn(address);
        Order order = mock(Order.class);
        given(order.getShipment()).willReturn(shipment);
        return order;
    }

    @Test
    void testFilter() {
        // given
        ClientNameSearchStrategy clientNameSearchStrategy = new ClientNameSearchStrategy("Mysliwiec");
        // when
        Order order1 = getOrderWithCertainClientName("Mysliwiec");
        Order order2 = getOrderWithCertainClientName("Kowalski");
        //then
        assertTrue(clientNameSearchStrategy.filter(order1));
        assertFalse(clientNameSearchStrategy.filter(order2));
    }
}