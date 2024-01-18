package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class Bigmac {

    private final int pattiesQty;
    private final Bun bun;
    private final Sauce sauce;
    private List<Ingredients> ingredients = new ArrayList<>();

    public static class BigmacBuilder {

        private int pattiesQty;
        private Bun bun;
        private Sauce sauce;
        private List<Ingredients> ingredients = new ArrayList<>();

        public BigmacBuilder pattiesQty(int pattiesQty) {
            this.pattiesQty = pattiesQty;
            return this;
        }

        public BigmacBuilder bun(Bun bun) {
            this.bun = bun;
            return this;
        }

        public BigmacBuilder sauce(Sauce sauce) {
            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder ingredient(Ingredients ingredient) {
            ingredients.add(ingredient);
            return this;
        }

        public Bigmac build() {
            return new Bigmac(pattiesQty, bun, sauce, ingredients);
        }
    }

    private Bigmac(final int pattiesQty, final Bun bun, final Sauce sauce, List<Ingredients> ingredients) {
        this.pattiesQty = pattiesQty;
        this.bun = bun;
        this.sauce = sauce;
        this.ingredients = ingredients;
    }

    public int getPattiesQty() {
        return pattiesQty;
    }

    public Bun getBun() {
        return bun;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public List<Ingredients> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "Bigmac{" +
                "pattiesQuantity=" + pattiesQty +
                ", bun=" + bun +
                ", sauce=" + sauce +
                ", ingredients=" + ingredients +
                '}';
    }
}
