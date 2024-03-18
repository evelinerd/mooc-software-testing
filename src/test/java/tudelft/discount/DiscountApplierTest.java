package tudelft.discount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;


public class DiscountApplierTest {

    @Test
    public void PriceOfZero() {
        Product product1 = new Product("lamp", 0, "HOME");
        Product product2 = new Product("chair", 0, "BUSINESS");

        ProductDao dao = Mockito.mock(ProductDao.class);

        List<Product> products = new ArrayList<>(Arrays.asList(product1, product2));

        when(dao.all()).thenReturn(products);

        DiscountApplier discountApplier = new DiscountApplier(dao);
        discountApplier.setNewPrices();

        Assertions.assertEquals(0, product1.getPrice());
        Assertions.assertEquals(0, product2.getPrice());
    }
    @Test
    public void PricesAboveZeroAndUnderZero() {
        Product product1 = new Product("lamp", 90, "HOME");
        Product product2 = new Product("chair", 110, "BUSINESS");
        Product product3 = new Product("chair", -110, "BUSINESS");

        ProductDao dao = Mockito.mock(ProductDao.class);

        List<Product> products = new ArrayList<>(Arrays.asList(product1, product2, product3));

        when(dao.all()).thenReturn(products);

        DiscountApplier discountApplier = new DiscountApplier(dao);
        discountApplier.setNewPrices();

        Assertions.assertEquals(99, product1.getPrice());
        Assertions.assertEquals(99, product2.getPrice());
        Assertions.assertEquals(0, product3.getPrice());
    }

    @Test
    public void CategoryOther() {
        Product product1 = new Product("lamp", 90, "NO");
        Product product2 = new Product("chair", 110, "CATEGORY");

        ProductDao dao = Mockito.mock(ProductDao.class);

        List<Product> products = new ArrayList<>(Arrays.asList(product1, product2));

        when(dao.all()).thenReturn(products);

        DiscountApplier discountApplier = new DiscountApplier(dao);
        discountApplier.setNewPrices();

        Assertions.assertEquals(90, product1.getPrice());
        Assertions.assertEquals(110, product2.getPrice());
    }

    @Test
    public void OnlyOneProductInList() {
        Product product1 = new Product("lamp", 90, "HOME");

        ProductDao dao = Mockito.mock(ProductDao.class);

        List<Product> products = new ArrayList<>(Collections.singletonList(product1));

        when(dao.all()).thenReturn(products);

        DiscountApplier discountApplier = new DiscountApplier(dao);
        discountApplier.setNewPrices();

        Assertions.assertEquals(99, product1.getPrice());
    }

}
