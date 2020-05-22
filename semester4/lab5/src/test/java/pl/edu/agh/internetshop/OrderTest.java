package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static pl.edu.agh.internetshop.util.CustomAssertions.assertBigDecimalCompareValue;

public class OrderTest {

	private Order getOrderWithMockedProducts() {
		Product product = mock(Product.class);
		return new Order(Collections.singletonList(product));
	}

	@Test
	public void testGetProductsThroughOrder() {
		// given
		Product expectedProduct1 = mock(Product.class);
		Product expectedProduct2 = mock(Product.class);
		Order order = new Order(Arrays.asList(expectedProduct1, expectedProduct2));

		// when
		Product actualProduct1 = order.getProducts().get(0);
		Product actualProduct2 = order.getProducts().get(1);

		// then
		assertSame(expectedProduct1, actualProduct1);
		assertSame(expectedProduct2, actualProduct2);
	}

	@Test
	public void testIllegalArgumentException(){
		// when then
		assertThrows(IllegalArgumentException.class, () -> new Order(null));
	}

	@Test
	public void testSetShipment() throws Exception {
		// given
		Order order = getOrderWithMockedProducts();
		Shipment expectedShipment = mock(Shipment.class);

		// when
		order.setShipment(expectedShipment);

		// then
		assertSame(expectedShipment, order.getShipment());
	}

	@Test
	public void testShipmentWithoutSetting() throws Exception {
		// given
		Order order = getOrderWithMockedProducts();

		// when

		// then
		assertNull(order.getShipment());
	}

	@Test
	public void testGetPrice() throws Exception {
		// given
		BigDecimal expectedProductPrice = BigDecimal.valueOf(1000);
		Product product = mock(Product.class);
		given(product.getPriceWithDiscount()).willReturn(expectedProductPrice);
		Order order1 = new Order(Collections.singletonList(product));
		Order order2 = new Order(Collections.singletonList(product));
		order1.setDiscount(0.2);

		// when
		BigDecimal actualProductPrice1 = order1.getPrice();
		BigDecimal actualProductPrice2 = order2.getPrice();

		// then
		assertBigDecimalCompareValue(expectedProductPrice.multiply(new BigDecimal(0.8)), actualProductPrice1);
		assertBigDecimalCompareValue(expectedProductPrice, actualProductPrice2);
	}

	private Order getOrderWithCertainProductPrice(double productPriceValue) {
		BigDecimal productPrice = BigDecimal.valueOf(productPriceValue);
		Product product = mock(Product.class);
		given(product.getPriceWithDiscount()).willReturn(productPrice);
		return new Order(Collections.singletonList(product));
	}

	@Test
	public void testPriceWithTaxesWithoutRoundUp() {
		// given

		// when
		Order order = getOrderWithCertainProductPrice(2); // 2 PLN

		// then
		assertBigDecimalCompareValue(order.getPriceWithTaxes(), BigDecimal.valueOf(2.46)); // 2.46 PLN
	}

	@Test
	public void testPriceWithTaxesWithRoundDown() {
		// given

		// when
		Order order = getOrderWithCertainProductPrice(0.01); // 0.01 PLN

		// then
		assertBigDecimalCompareValue(order.getPriceWithTaxes(), BigDecimal.valueOf(0.01)); // 0.01 PLN
																							
	}

	@Test
	public void testPriceWithTaxesWithRoundUp() {
		// given

		// when
		Order order = getOrderWithCertainProductPrice(0.03); // 0.03 PLN

		// then
		assertBigDecimalCompareValue(order.getPriceWithTaxes(), BigDecimal.valueOf(0.04)); // 0.04 PLN
																							
	}

	@Test
	public void testSetShipmentMethod() {
		// given
		Order order = getOrderWithMockedProducts();
		ShipmentMethod surface = mock(SurfaceMailBus.class);

		// when
		order.setShipmentMethod(surface);

		// then
		assertSame(surface, order.getShipmentMethod());
	}

	@Test
	public void testSending() {
		// given
		Order order = getOrderWithMockedProducts();
		SurfaceMailBus surface = mock(SurfaceMailBus.class);
		Shipment shipment = mock(Shipment.class);
		given(shipment.isShipped()).willReturn(true);

		// when
		order.setShipmentMethod(surface);
		order.setShipment(shipment);
		order.send();

		// then
		assertTrue(order.isSent());
	}

	@Test
	public void testIsSentWithoutSending() {
		// given
		Order order = getOrderWithMockedProducts();
		Shipment shipment = mock(Shipment.class);
		given(shipment.isShipped()).willReturn(true);

		// when

		// then
		assertFalse(order.isSent());
	}

	@Test
	public void testWhetherIdExists() throws Exception {
		// given
		Order order = getOrderWithMockedProducts();

		// when

		// then
		assertNotNull(order.getId());
	}

	@Test
	public void testSetPaymentMethod() throws Exception {
		// given
		Order order = getOrderWithMockedProducts();
		PaymentMethod paymentMethod = mock(MoneyTransferPaymentTransaction.class);

		// when
		order.setPaymentMethod(paymentMethod);

		// then
		assertSame(paymentMethod, order.getPaymentMethod());
	}

	@Test
	public void testPaying() throws Exception {
		// given
		Order order = getOrderWithMockedProducts();
		PaymentMethod paymentMethod = mock(MoneyTransferPaymentTransaction.class);
		given(paymentMethod.commit(any(MoneyTransfer.class))).willReturn(true);
		MoneyTransfer moneyTransfer = mock(MoneyTransfer.class);
		given(moneyTransfer.isCommitted()).willReturn(true);

		// when
		order.setPaymentMethod(paymentMethod);
		order.pay(moneyTransfer);

		// then
		assertTrue(order.isPaid());
	}

	@Test
	public void testIsPaidWithoutPaying() throws Exception {
		// given
		Order order = getOrderWithMockedProducts();

		// when

		// then
		assertFalse(order.isPaid());
	}

	@Test
	public void testProductDiscount() throws Exception{
		//given
		Order order1 = getOrderWithMockedProducts();
		Order order2 = getOrderWithMockedProducts();
		// when
		order1.setDiscount(0.1);

		// then
		assertEquals(0.1, order1.getDiscount());
		assertEquals(0, order2.getDiscount());
	}

	@Test
	public void testDiscountException() throws Exception{
		//given
		Order order = getOrderWithMockedProducts();
		// when then
		assertThrows(IllegalArgumentException.class, () -> order.setDiscount(2));
		assertThrows(IllegalArgumentException.class, () -> order.setDiscount(-0.1));
	}
}
