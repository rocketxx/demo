package com.example.demo.mock;

import java.util.Arrays;
import java.util.List;

import com.example.demo.enumerator.ProductType;
import com.example.demo.model.Ingredient;
import com.example.demo.model.MenuItem;

public class MockData {

    public static List<Ingredient> getMockIngredients() {
        Ingredient mozzarella = new Ingredient();
        mozzarella.setId("1");
        mozzarella.setName("Mozzarella");
        mozzarella.setType("Cheese");
        mozzarella.setPrice(0.50);

        Ingredient tomatoSauce = new Ingredient();
        tomatoSauce.setId("2");
        tomatoSauce.setName("Tomato Sauce");
        tomatoSauce.setType("Sauce");
        tomatoSauce.setPrice(0.30);

        Ingredient basil = new Ingredient();
        basil.setId("3");
        basil.setName("Basil");
        basil.setType("Herb");
        basil.setPrice(0.10);

        Ingredient oliveOil = new Ingredient();
        oliveOil.setId("4");
        oliveOil.setName("Olive Oil");
        oliveOil.setType("Oil");
        oliveOil.setPrice(0.20);

        return Arrays.asList(mozzarella, tomatoSauce, basil, oliveOil);
    }

    public static MenuItem getMockMenuItem() {
        MenuItem margherita = new MenuItem();
        margherita.setName("Pizza Margherita");
        margherita.setDescription("Classic pizza with mozzarella, tomato sauce, basil, and olive oil");
        margherita.setPrice(8.50);
        margherita.setType("Pizza");
        margherita.setIngredients(getMockIngredients());
        margherita.setProductType(ProductType.FOOD_TYPE);

        return margherita;
    }
}

