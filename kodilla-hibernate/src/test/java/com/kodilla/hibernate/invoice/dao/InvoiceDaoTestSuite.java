package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    @AfterEach
    public void cleanUp() {
        //CleanUp
        try {
            invoiceDao.deleteAll();
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    void testInvoiceDaoSave() {
        //Given
        Product product1 = new Product("Product 1");
        Product product2 = new Product("Product 2");

        Item item1 = new Item(product1, new BigDecimal("1.23"), 4);
        Item item2 = new Item(product1, new BigDecimal("2.34"), 3);
        Item item3 = new Item(product2, new BigDecimal("3.21"), 2);
        Item item4 = new Item(product2, new BigDecimal("4.32"), 1);

        Invoice invoice = new Invoice("FV/1/2024");

        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        item3.setInvoice(invoice);
        item4.setInvoice(invoice);

        List<Item> itemsForInvoice = new ArrayList<>();
        itemsForInvoice.add(item1);
        itemsForInvoice.add(item2);
        itemsForInvoice.add(item3);
        itemsForInvoice.add(item4);
        invoice.setItems(itemsForInvoice);

        //When
        invoiceDao.save(invoice);
        int id = invoice.getId();
        int itemsListSize = invoice.getItems().size();
        Item item5 = new Item(product2, new BigDecimal("1.11"), 1);
        System.out.println(invoice);

        //Then
        assertNotEquals(0, id);
        assertEquals(4, itemsListSize);

        assertEquals(id, item1.getInvoice().getId());
        assertEquals(id, item2.getInvoice().getId());
        assertEquals(id, item3.getInvoice().getId());
        assertEquals(id, item4.getInvoice().getId());

        assertFalse(invoice.getItems().contains(item5));
    }
}
