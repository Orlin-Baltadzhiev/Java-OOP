import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;


public class InstockTest {
    private ProductStock stock;
    private Product testProduct;
    private static final String PRODUCT_LABEL = "test_label";
    private Product[] products;

    @Before
    public void setUp() {
        this.stock = new Instock();
        this.testProduct = new Product(PRODUCT_LABEL, 11, 1);
    }


    @Test
    public void testAddShouldSaveProduct() {

        stock.add(testProduct);
        assertTrue(stock.contains(testProduct));
    }

    @Test
    public void TestContainsTrueForPreviouslyAddedItem() {
        testAddShouldSaveProduct();
    }

    @Test
    public void testContains() {
        assertFalse(stock.contains(testProduct));
        stock.add(testProduct);
        assertTrue(stock.contains(testProduct));
    }

    @Test
    public void testCountSholdReturnOneForSingleProduct() {
        stock.add(testProduct);
        assertEquals(1, stock.getCount());
    }

    @Test
    public void testhShouldReturnTenFoTenProducts() {
        int expectedProductCount = 10;
        addProductsToStock(expectedProductCount);
        assertEquals(expectedProductCount, stock.getCount());
    }

    @Test
    public void testCountShouldReturnZeroWhenIsEmpty() {
        assertEquals(0, stock.getCount());

    }

    //This test will work only if we add remove operation
    //The only thing you have add is the remove method call
    @Ignore
    @Test
    public void testCountShouldReturnFiveWhenFirstWeAddTenThenWeRemoveFiveProducts() {
        int expectedProductCount = 5;
        addProductsToStock(expectedProductCount);
        //TODO: add remove of five products here
        assertEquals(expectedProductCount, stock.getCount());
    }

    @Test
    public void testFindByIndexReturnCorrectElementWhenOnlyOne() {
        stock.add(testProduct);
        assertProductsAreEqual(testProduct, stock.find(0));

    }

    @Test
    public void testFindByIndexReturnCorrectElementWhenTenProductsAreAdded() {
        addProductsToStock(10);
        assertProductsAreEqual(products[products.length - 1], stock.find(products.length - 1));
    }

    @Test
    public void testFindByIndexReturnCorrectElementWhenTenProductsAreAddedAndTakeProductInMiddle() {
        addProductsToStock(10);
        assertProductsAreEqual(products[(products.length - 1) / 2], stock.find((products.length - 1) / 2));
    }

    @Test
    public void testFindByIndexReturnCorrectProductsWhenTenProductsWhenAllIndexesAreFetched() {
        addProductsToStock(10);
        for (int i = 0; i < 10; i++) {
            assertProductsAreEqual(products[i], stock.find(i));
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindByIndexWhenEmpty(){
        this.stock.find(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindByIndexWhenNegativeIndex(){
        this.stock.find(-2);
    }

    @Test
    public void testFindByLabelShouldReturnTheSameProduct(){
        int newQuantity = testProduct.getQuantity()+10;
        stock.add(testProduct);
        Product actual = stock.findByLabel(testProduct.getLabel());
        assertProductsAreEqual(testProduct,actual);
    }
    @Test (expected = IllegalArgumentException.class)
    public void testsChangeQuantityShouldFailWhenEmpty(){
        stock.findByLabel("None-Exisiting-Label");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeQuantityWihtEmptyStock(){
        stock.changeQuantity(testProduct.getLabel(),100);
    }

    @Test
    public void testeFindFirstByAlphabeticalrderShouldReturnCorrect(){
    addProductsToStock(10);
        List<Product> expected = Arrays.stream(products)
                .sorted(Comparator.comparing(Product::getLabel))
                .limit(5)
                .collect(Collectors.toList());

        Iterable<Product> iterable = stock.findFirstByAlphabeticalOrder(5);
        List<Product> actual = new ArrayList<>();
        iterable.forEach(actual::add);
        assertEquals(expected.size(),actual.size());

        for (int i = 0; i < expected.size(); i++) {
           assertProductsAreEqual(expected.get(i),actual.get(i));
        }
    }


    private void assertProductsAreEqual(Product expected, Product actual) {
        assertEquals(expected.getLabel(), actual.getLabel());
        assertEquals(expected.getPrice(), actual.getPrice(), 0.00);
        assertEquals(expected.getQuantity(), actual.getQuantity());
    }

    private void addProductsToStock(int count) {
        products = new Product[count];
        for (int i = 0; i < count; i++) {
            products[i] = new Product("" + i, i + 10, i);
            stock.add(products[i]);
        }
    }
}