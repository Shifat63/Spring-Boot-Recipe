INSERT INTO category (name) VALUES ('American');
INSERT INTO category (name) VALUES ('Italian');
INSERT INTO category (name) VALUES ('Mexican');
INSERT INTO category (name) VALUES ('Fast Food');

INSERT INTO ingredient (name) VALUES ('Milk');
INSERT INTO ingredient (name) VALUES ('Onion');
INSERT INTO ingredient (name) VALUES ('Garlic');
INSERT INTO ingredient (name) VALUES ('Ginger');
INSERT INTO ingredient (name) VALUES ('Spice');
INSERT INTO ingredient (name) VALUES ('Rice');
INSERT INTO ingredient (name) VALUES ('Chicken');
INSERT INTO ingredient (name) VALUES ('Beef');

INSERT INTO recipe (name, preparation_time, cook_time, description, difficulty)
VALUES ('Perfect Guacamole', 10.20, 15.50,
        '1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife
        and scoop out the flesh with a spoon. 2 Mash with a fork: Using a fork, roughly mash the avocado. (Do not overdo it!
        The guacamole should be a little chunky.) 3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon)
        juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados
        from turning brown. Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their
        hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.
        Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe
        and adjust to your taste. 4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole
        cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.)
        Refrigerate until ready to serve. Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your
        guacamole, add it just before serving. Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvpiV9Sd',
        'EASY');
INSERT INTO recipe (name, preparation_time, cook_time, description, difficulty)
VALUES ('Spicy Grilled Chicken Taco', 50.00, 45.50,
        '1 Prepare a gas or charcoal grill for medium-high, direct heat.
        2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar,
        salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl
        and toss to coat all over. Set aside to marinate while the grill heats and you prepare the rest of the toppings.
        3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest
        part of the meat registers 165F. Transfer to a plate and rest for 5 minutes. 4 Warm the tortillas: Place each tortilla
        on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up
        in the tortilla, turn it with tongs and heat for a few seconds on the other side. Wrap warmed tortillas in a tea towel
        to keep them warm until serving. 5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small
        handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the
        thinned sour cream. Serve with lime wedges. Read more: http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4jvtrAnNm',
        'KIND_OF_HARD');

INSERT INTO recipe_ingredient (recipe_id, ingredient_id) VALUES (1, 2);
INSERT INTO recipe_ingredient (recipe_id, ingredient_id) VALUES (1, 4);
INSERT INTO recipe_ingredient (recipe_id, ingredient_id) VALUES (1, 6);
INSERT INTO recipe_ingredient (recipe_id, ingredient_id) VALUES (1, 7);
INSERT INTO recipe_ingredient (recipe_id, ingredient_id) VALUES (2, 1);
INSERT INTO recipe_ingredient (recipe_id, ingredient_id) VALUES (2, 3);
INSERT INTO recipe_ingredient (recipe_id, ingredient_id) VALUES (2, 5);
INSERT INTO recipe_ingredient (recipe_id, ingredient_id) VALUES (2, 8);

INSERT INTO recipe_category (recipe_id, category_id) VALUES (1, 2);
INSERT INTO recipe_category (recipe_id, category_id) VALUES (1, 4);
INSERT INTO recipe_category (recipe_id, category_id) VALUES (2, 1);
INSERT INTO recipe_category (recipe_id, category_id) VALUES (2, 3);

