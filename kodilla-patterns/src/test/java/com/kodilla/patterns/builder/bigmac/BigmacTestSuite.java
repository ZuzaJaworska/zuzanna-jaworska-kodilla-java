package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        int howManyIngredients = bigmac.getIngredients().size();

        //Then
        assertEquals(4, howManyIngredients);
    }
}
