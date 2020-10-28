package sqat.swc.neu;

import org.junit.jupiter.api.Test;
import sqat.swc.neu.shop.Basket;
import sqat.swc.neu.shop.Discount;
import sqat.swc.neu.shop.Product;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class is in order to test the basket class in sqat.swc.neu.shop package.
 *
 * @author Ali hasan
 * @date 2019.11.9 16:33:55
 */
public class TestBasket {

    /**
     * Now we test the addProduct method in Basket class.
     */
    //Pass. Input the product and quantity.
    @Test
    public void testAddProduct_WithProductAndQuantity() {
        Basket basket = new Basket();
        Product phoneProduct = new Product("Samsung S10", 9000);

        assertTrue(basket.addProduct(phoneProduct, 1));
        assertEquals(1, basket.getNumberOfItems());
    }

    //Not pass. Input the null product.
    @Test
    public void testAddProduct_ForNoProduct() {
        Basket basket = new Basket();
        assertFalse(basket.addProduct(null, 1));
        assertEquals(0, basket.getNumberOfItems());
    }

    //Not pass. Input the same product twice.
    @Test
    public void testAddProduct_ForSameProductName() {
        Basket basket = new Basket();
        Product phoneProduct = new Product("Samsung S10", 9000);
        basket.addProduct(phoneProduct, 1);
        basket.addProduct(phoneProduct, 1);
        assertEquals(2, basket.getNumberOfItems());
    }

    //Not pass. Input the minus quantity.
    @Test
    public void testAddProduct_ForMinusQuantity() {
        Basket basket = new Basket();
        Product phoneProduct = new Product("Samsung S10", 9000);

        assertFalse(basket.addProduct(phoneProduct, -1));
    }

    //Pass. Input null product and cash exception.
    @Test
    public void testAddProduct_ThrowException_ForNoProduct() {
        assertThrows(NullPointerException.class, () -> {
            Basket basket = new Basket();
            basket.addProduct(null, 1);
        });
    }

    //Pass. Input the minus quantity and cash exception.
    @Test
    public void testAddProduct_ThrowException_ForMinusQuantity() {
        assertThrows(IllegalArgumentException.class, () -> {
            Basket basket = new Basket();
            Product phoneProduct = new Product("Samsung S10", 9000);
            basket.addProduct(phoneProduct, -1);
        });
    }

    //Pass. Input when paid.
    @Test
    public void testAddProduct_WhenPaid() {
        Basket basket = new Basket();
        Product phoneProduct = new Product("Samsung S10", 9000);
        Product watchProduct = new Product("Apple Watch", 5200);
        basket.addProduct(phoneProduct, 1);
        assertEquals(1, basket.getNumberOfItems());
        basket.pay(9000);
        assertFalse(basket.addProduct(watchProduct, 1));
    }

    /**
     * Now we test the removeAllProductItems method in Basket class.
     */
    //Pass. Input the product exists.
    @Test
    public void testRemoveAllProductItems_WithProductsExist() {
        Basket basket = new Basket();
        Product phoneProduct = new Product("Samsung S10", 9000);
        basket.addProduct(phoneProduct, 1);

        assertTrue(basket.removeAllProductItems(phoneProduct));
        assertEquals(0, basket.getNumberOfItems());
    }

    //Pass. Input the product not exists.
    @Test
    public void testRemoveAllProductItems_WithProductsNotExist() {
        Basket basket = new Basket();
        Product phoneProduct = new Product("Samsung S10", 9000);
        Product watchProduct = new Product("Apple Watch", 5200);
        basket.addProduct(watchProduct, 1);
        assertFalse(basket.removeAllProductItems(phoneProduct));
        assertEquals(1, basket.getNumberOfItems());
    }

    //Not Pass. Input when paid.
    @Test
    public void testRemoveAllProductItems_WhenPaid() {
        Basket basket = new Basket();
        Product phoneProduct = new Product("Samsung S10", 9000);
        basket.addProduct(phoneProduct, 1);
        basket.pay(9000);
        assertFalse(basket.removeAllProductItems(phoneProduct));
    }

    /**
     * Now we test the testRemoveSomeProductItems method in Basket class.
     */
    //Not pass. Input the product and quantity.
    @Test
    public void testRemoveSomeProductItems_WithProductsAndQuantity() {
        Basket basket = new Basket();
        Product phoneProduct = new Product("Samsung S10", 9000);
        basket.addProduct(phoneProduct, 1);

        assertTrue(basket.removeSomeProductItems(phoneProduct, 1));
        assertEquals(0, basket.getNumberOfItems());
    }

    //Not pass. Input the null product.
    @Test
    public void testRemoveSomeProductItems_ForProductNull() {
        Basket basket = new Basket();
        Product phoneProduct = new Product("Samsung S10", 9000);
        basket.addProduct(phoneProduct, 1);

        assertFalse(basket.removeSomeProductItems(null, 1));
    }

    //Pass. Input the null product.
    @Test
    public void testRemoveSomeProductItems_ThrowException_ForProductNull() {
        assertThrows(NullPointerException.class, () -> {
            Basket basket = new Basket();
            Product phoneProduct = new Product("Samsung S10", 9000);
            basket.addProduct(phoneProduct, 1);
            basket.removeSomeProductItems(null, 1);
        });
    }

    //Not pass
    @Test
    public void testRemoveSomeProductItems_ForProductItemsNotExist() {
        Basket basket = new Basket();
        Product phoneProduct = new Product("Samsung S10", 9000);
        Product watchProduct = new Product("Apple Watch", 5200);
        basket.addProduct(phoneProduct, 1);
        assertFalse(basket.removeSomeProductItems(watchProduct, 1));
    }

    //Pass
    @Test
    public void testRemoveSomeProductItems_ForWrongQuantity() {
        Basket basket = new Basket();
        Product phoneProduct = new Product("Samsung S10", 9000);
        basket.addProduct(phoneProduct, 1);

        assertFalse(basket.removeSomeProductItems(phoneProduct, 10));
    }

    //Pass
    @Test
    public void testRemoveSomeProductItems_ForMinusQuantity() {
        Basket basket = new Basket();
        Product phoneProduct = new Product("Samsung S10", 9000);
        basket.addProduct(phoneProduct, 1);

        assertFalse(basket.removeSomeProductItems(phoneProduct, -1));
    }

    //Pass
    @Test
    public void testRemoveSomeProductItems_WhenPaid() {
        Basket basket = new Basket();
        Product phoneProduct = new Product("Samsung S10", 9000);
        basket.addProduct(phoneProduct, 1);
        basket.pay(9000);
        assertFalse(basket.removeSomeProductItems(phoneProduct, 1));
    }

    /**
     * Now we test the findBasketItemWithProduct method in Basket class.
     */
    //Pass
    @Test
    public void testFindBasketItemWithProduct_WithProduct() {
        Basket basket = new Basket();
        Product phoneProduct = new Product("Samsung S10", 9000);
        basket.addProduct(phoneProduct, 1);

        assertEquals(phoneProduct, basket.findBasketItemWithProduct(phoneProduct).getProduct());
        assertEquals(1, basket.findBasketItemWithProduct(phoneProduct).getQuantity());
    }

    //Pass
    @Test
    public void testFindBasketItemWithProduct_WithNullProduct() {
        Basket basket = new Basket();
        Product phoneProduct = new Product("Samsung S10", 9000);
        basket.addProduct(phoneProduct, 1);

        assertEquals(null, basket.findBasketItemWithProduct(null));
    }

    //Pass
    @Test
    public void testFindBasketItemWithProduct_WhenItemsListEmpty() {
        Basket basket = new Basket();
        Product phoneProduct = new Product("Samsung S10", 9000);

        assertEquals(null, basket.findBasketItemWithProduct(phoneProduct));
    }

    //Pass
    @Test
    public void testFindBasketItemWithProduct_ForWrongProduct() {
        Basket basket = new Basket();
        Product phoneProduct = new Product("Samsung S10", 9000);
        Product watchProduct = new Product("Apple Watch", 5200);
        basket.addProduct(phoneProduct, 1);

        assertEquals(null, basket.findBasketItemWithProduct(watchProduct));
    }

    //Pass
    @Test
    public void testAddDiscount_WithDiscount() {
        Basket basket = new Basket();
        Product phoneProduct = new Product("Samsung S10", 9000);
        Discount discount = new Discount("PH0301", phoneProduct, 3, 1);
        basket.addDiscount(discount);

        assertEquals(1, basket.getNumberOfDiscounts());
    }

    //Not Pass
    @Test
    public void testAddDiscount_ForNullDiscount() {
        Basket basket = new Basket();
        basket.addDiscount(null);

        assertEquals(0, basket.getNumberOfDiscounts());
    }

    //Pass
    @Test
    public void testAddDiscount_ThrowException_ForNullDiscount() {
        Basket basket = new Basket();
        assertThrows(NullPointerException.class, () ->
                basket.addDiscount(null)
        );
    }

    //Not pass
    @Test
    public void testAddDiscount_ForSameDiscount() {
        Basket basket = new Basket();
        Product phoneProduct = new Product("Samsung S10", 9000);
        Discount phoneDiscountOne = new Discount("PH0301", phoneProduct, 3, 1);
        Discount phoneDiscountTwo = new Discount("PH0302", phoneProduct, 3, 1);

        basket.addDiscount(phoneDiscountOne);
        basket.addDiscount(phoneDiscountTwo);

        assertEquals(1, basket.getNumberOfDiscounts());
    }

    //Pass
    @Test
    public void testGetTotal_WithProduct() {
        Basket basket = new Basket();
        Product phoneProduct = new Product("Samsung S10", 9000);
        basket.addProduct(phoneProduct, 10);

        assertEquals(90000, basket.getTotal());
    }

    //Pass
    @Test
    public void testGetTotal_ForNoProduct() {
        Basket basket = new Basket();
        assertEquals(0, basket.getTotal());
    }

    //Not pass
    @Test
    public void testGetTotal_WithProductAndDiscount() {
        Basket basket = new Basket();
        Product phoneProduct = new Product("Samsung S10", 9000);
        Discount phoneDiscount = new Discount("PH0301", phoneProduct, 3, 1);

        basket.addProduct(phoneProduct, 10);
        basket.addDiscount(phoneDiscount);

        assertEquals(81000, basket.getTotal());
    }

    //Not pass
    @Test
    public void testGetTotal_WithDifferentDiscount() {
        Basket basket = new Basket();
        Product phoneProduct = new Product("Samsung S10", 9000);
        Discount discountOne = new Discount("PH0301", phoneProduct, 5, 1);
        Discount discountTwo = new Discount("PH0302", phoneProduct, 6, 1);

        basket.addProduct(phoneProduct, 5);
        basket.addDiscount(discountOne);
        basket.addDiscount(discountTwo);
        assertEquals(45000, basket.getTotal());
    }

    //Not pass
    @Test
    public void testGetTotal_WithDiscount_WithBiggerDiscountQuantity() {
        Basket basket = new Basket();
        Product phoneProduct = new Product("Samsung S10", 9000);
        Discount discount = new Discount("1", phoneProduct, 10, 1);
        basket.addProduct(phoneProduct, 5);
        basket.addDiscount(discount);
        assertEquals(45000, basket.getTotal());
    }

    //Pass
    @Test
    public void testPay_WithAmount() {
        Basket basket = new Basket();
        Product phoneProduct = new Product("Samsung S10", 9000);
        basket.addProduct(phoneProduct, 5);
        assertTrue(basket.pay(45000).isSuccess());
    }

    //Pass
    @Test
    public void testPay_WrongAmount() {
        Basket basket = new Basket();
        Product phoneProduct = new Product("Samsung S10", 9000);
        basket.addProduct(phoneProduct, 5);
        assertFalse(basket.pay(10).isSuccess());
    }

    //Pass
    @Test
    public void testPay_MinusAmount() {
        Basket basket = new Basket();
        Product phoneProduct = new Product("Samsung S10", 9000);
        basket.addProduct(phoneProduct, 5);
        assertFalse(basket.pay(-5).isSuccess());
    }

    //Not pass
    @Test
    public void testPay_Change() {
        Basket basket = new Basket();
        Product phoneProduct = new Product("Samsung S10", 9000);
        basket.addProduct(phoneProduct, 5);
        assertEquals(5000, basket.pay(50000).getChange());
    }

    //Pass
    @Test
    public void testPay_ForAbout() {
        Basket basket = new Basket();
        Product phoneProduct = new Product("Samsung S10", 9000);
        basket.addProduct(phoneProduct, 5);
        basket.pay(50000);
        assertFalse(basket.pay(50000).isSuccess());
    }
}
