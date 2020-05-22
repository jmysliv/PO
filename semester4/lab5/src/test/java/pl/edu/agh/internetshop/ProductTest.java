package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static pl.edu.agh.internetshop.util.CustomAssertions.assertBigDecimalCompareValue;

import java.math.BigDecimal;


public class ProductTest {

	
    private static final String NAME = "Mr. Sparkle";
    private static final BigDecimal PRICE = BigDecimal.valueOf(100);

	@Test
    public void testProductName() throws Exception{
        //given
    	
        // when
        Product product = new Product(NAME, PRICE);
        
        // then
        assertEquals(NAME, product.getName());
    }
    
    @Test
    public void testProductPrice() throws Exception{
        //given
    	
        // when
        Product product = new Product(NAME, PRICE);
        
        // then
        assertBigDecimalCompareValue(product.getPrice(), PRICE);
    }

    @Test
    public void testProductDiscount() throws Exception{
        //given
        Product product = new Product(NAME, PRICE);
        Product product2 = new Product(NAME, PRICE);
        // when
        product.setDiscount(0.1);

        // then
        assertEquals(0.1, product.getDiscount());
        assertEquals(0, product2.getDiscount());
    }

    @Test
    public void testDiscountException() throws Exception{
        //given
        Product product = new Product(NAME, PRICE);
        // when then
        assertThrows(IllegalArgumentException.class, () -> product.setDiscount(2));
        assertThrows(IllegalArgumentException.class, () -> product.setDiscount(-0.1));
    }

    @Test
    public void testProductPriceWithDiscount() throws Exception{
        //given
        Product product = new Product(NAME, PRICE);
        Product product2 = new Product(NAME, PRICE);

        // when
        product.setDiscount(0.1);

        // then
        assertEquals(PRICE.multiply(new BigDecimal(0.9)), product.getPriceWithDiscount());
        assertEquals(PRICE, product2.getPriceWithDiscount());
    }
}