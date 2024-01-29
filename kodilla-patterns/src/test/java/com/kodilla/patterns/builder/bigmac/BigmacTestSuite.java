package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BigmacTestSuite {

    @Test
    void testBigmacNew() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .pattiesQty(2)
                .ingredient(Ingredients.CHEESE)
                .bun(Bun.BUN_WITH_SESAME)
                .ingredient(Ingredients.BACON)
                .sauce(Sauce.BBQ)
                .ingredient(Ingredients.LETTUCE)
                .ingredient(Ingredients.ONION)
                .build();
        System.out.println(bigmac);

        //When
        int howManyPatties = bigmac.getPattiesQty();
        int howManyIngredients = bigmac.getIngredients().size();

        //Then
        assertEquals(2, howManyPatties);
        assertEquals(4, howManyIngredients);

        assertEquals("BUN_WITH_SESAME", bigmac.getBun().toString());
        assertEquals("BBQ", bigmac.getSauce().toString());

        assertTrue(bigmac.getIngredients().contains(Ingredients.BACON));
        assertTrue(bigmac.getIngredients().contains(Ingredients.CHEESE));
        assertTrue(bigmac.getIngredients().contains(Ingredients.ONION));
        assertTrue(bigmac.getIngredients().contains(Ingredients.LETTUCE));

        assertFalse(bigmac.getIngredients().contains(Ingredients.PICKLE));
        assertFalse(bigmac.getIngredients().contains(Ingredients.CHILLI_PEPPERS));
        assertFalse(bigmac.getIngredients().contains(Ingredients.MUSHROOMS));
        assertFalse(bigmac.getIngredients().contains(Ingredients.SHRIMPS));
    }
}
