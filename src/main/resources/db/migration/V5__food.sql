INSERT INTO food(id, name, energy_value, details, protein, carbohydrates, sugars, fats, saturated_fatty_acids,
                 trans_fatty_acids, monounsaturated, semi_saturated, cholesterol, fiber, salt, water, calcium, phe)
VALUES (1, 'Water', 0, 'Clear water should be clear, tasteless and odorless.

Water is essential for all the body''s functions. Lack of fluids is most often manifested by headaches or mood swings.

In hot thirsts, the best water is pure water, but it should not be icy.', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 100, 0,
        0);
INSERT INTO food(id, name, energy_value, details, protein, carbohydrates, sugars, fats, saturated_fatty_acids,
                 trans_fatty_acids, monounsaturated, semi_saturated, cholesterol, fiber, salt, water, calcium, phe)
VALUES (2, 'Milk 1.5%', 47, 'Milk is a good source.

Calcium, the source of which is milk, the basic human body. It is found in bones, teeth, muscles, blood and other body tissues. Presence in the diet is essential for humans. Its supply is especially important for children and pregnant women. Sufficient vitamin D is needed for proper absorption of the patient in the body. In case of a deficiency of a sufficient amount (vitamin D) in the diet, the risk of leaching the patient from the bones and subsequent osteoporosis increases for a long time (especially in the elderly, eg even with a severe cough).

If feeding in cows causes you problems and you do not want to eat milk to consume grass, consume milk in the form of acidic products. If you want to completely replace cow''s milk, find an alternative in a healthy diet. You can choose from a number of products - from goat''s and sheep''s milk, and mare''s milk is sometimes available. Another alternative is the "milk" of cecelon, almond, cashew nuts and the like, which are not "real" milks, but can be used in the same way in the kitchen. They are also suitable for direct consumption.',
        3, 5, 5, 2, 0.91, 0, 0.41, 0.09, 0.01, 0, 0, 88, 121, 169);
INSERT INTO food(id, name, energy_value, details, protein, carbohydrates, sugars, fats, saturated_fatty_acids,
                 trans_fatty_acids, monounsaturated, semi_saturated, cholesterol, fiber, salt, water, calcium, phe)
VALUES (3, 'Banana', 94, 'It contains vitamins C, B, vitamin A, minerals magnesium, fast, phosphorus and very beneficial potassium.

It has a positive effect on the brain, nervous system and muscular system. I recommend it to people with stomach diseases because it has calming effects. Bananas are easy to digest. They are especially popular with athletes due to their higher content and low fat content. You can join the diet as part of a reduction diet, but it is advisable to alternate them with less sweet fruits.

Banana is currently also used in cosmetics, most often in the form of a face mask. We never store bananas inside. When choosing bananas, we follow the color of the peel. If it is grayish in color, it means that the fruits ripen at a low temperature and perish quickly. It is not recommended before peak performance because it has mild damping effects.',
        1, 22, 19, 0.2, 0.1, 0, 0.02, 0.1, 0, 2, 0, 74, 12, 60);
INSERT INTO food(id, name, energy_value, details, protein, carbohydrates, sugars, fats, saturated_fatty_acids,
                 trans_fatty_acids, monounsaturated, semi_saturated, cholesterol, fiber, salt, water, calcium, phe)
VALUES (4, 'Hen Eggs', 151, 'It contains vitamins C, B, vitamin A, minerals magnesium, fast, phosphorus and very beneficial potassium.

It has a positive effect on the brain, nervous system and muscular system. I recommend it to people with stomach diseases because it has calming effects. Bananas are easy to digest. They are especially popular with athletes due to their higher content and low fat content. You can join the diet as part of a reduction diet, but it is advisable to alternate them with less sweet fruits.

An egg is an irreplaceable component of our food, it has a high energy value. White contains a large amount of protein. Yolk is a source of vitamin D, as well as cholesterol.

It is an important food for the growth and development of children. It acts as a prevention of cancer and heart disease. If we do not overdo the consumption of eggs, we can include eggs in the list of foods that have a beneficial effect on human health and should be part of our diet.

Cooked egg whites are consumed on reduction diets. If you really want to enjoy the eggs, get them from the farm or from organic farming. They are more expensive, but the difference in taste is really big (compared to eggs from caged hens, which do not have the option of a paddock with available greenery).',
        12, 0.94, 0.34, 11, 3, 0, 4, 2, 431, 0, 0, 0, 54, 619);
INSERT INTO food(id, name, energy_value, details, protein, carbohydrates, sugars, fats, saturated_fatty_acids,
                 trans_fatty_acids, monounsaturated, semi_saturated, cholesterol, fiber, salt, water, calcium, phe)
VALUES (5, 'Espresso', 4, 0, 0.2, 0, 0, 0.4, 0, 0, 0, 0, 0, 0, 0, 0, 2, 10);



INSERT INTO food_vitamin(id, food_id, vitamin_id)
VALUES (1, 1, 10);
INSERT INTO food_vitamin(id, food_id, vitamin_id)
VALUES (2, 1, 1);
INSERT INTO food_vitamin(id, food_id, vitamin_id)
VALUES (3, 2, 8);
INSERT INTO food_vitamin(id, food_id, vitamin_id)
VALUES (4, 2, 6);
INSERT INTO food_vitamin(id, food_id, vitamin_id)
VALUES (5, 2, 12);
INSERT INTO food_vitamin(id, food_id, vitamin_id)
VALUES (6, 2, 4);
INSERT INTO food_vitamin(id, food_id, vitamin_id)
VALUES (7, 2, 14);
INSERT INTO food_vitamin(id, food_id, vitamin_id)
VALUES (8, 2, 11);
INSERT INTO food_vitamin(id, food_id, vitamin_id)
VALUES (9, 2, 3);
INSERT INTO food_vitamin(id, food_id, vitamin_id)
VALUES (10, 2, 10);
INSERT INTO food_vitamin(id, food_id, vitamin_id)
VALUES (11, 2, 1);
INSERT INTO food_vitamin(id, food_id, vitamin_id)
VALUES (12, 2, 9);
INSERT INTO food_vitamin(id, food_id, vitamin_id)
VALUES (13, 2, 2);
INSERT INTO food_vitamin(id, food_id, vitamin_id)
VALUES (14, 2, 5);
INSERT INTO food_vitamin(id, food_id, vitamin_id)
VALUES (15, 2, 7);
INSERT INTO food_vitamin(id, food_id, vitamin_id)
VALUES (16, 3, 10);
INSERT INTO food_vitamin(id, food_id, vitamin_id)
VALUES (17, 3, 9);
INSERT INTO food_vitamin(id, food_id, vitamin_id)
VALUES (18, 3, 5);
INSERT INTO food_vitamin(id, food_id, vitamin_id)
VALUES (19, 3, 14);
INSERT INTO food_vitamin(id, food_id, vitamin_id)
VALUES (20, 3, 4);
INSERT INTO food_vitamin(id, food_id, vitamin_id)
VALUES (21, 3, 8);
INSERT INTO food_vitamin(id, food_id, vitamin_id)
VALUES (22, 3, 1);
INSERT INTO food_vitamin(id, food_id, vitamin_id)
VALUES (23, 3, 12);
INSERT INTO food_vitamin(id, food_id, vitamin_id)
VALUES (24, 3, 6);
INSERT INTO food_vitamin(id, food_id, vitamin_id)
VALUES (25, 3, 2);
INSERT INTO food_vitamin(id, food_id, vitamin_id)
VALUES (26, 3, 7);
INSERT INTO food_vitamin(id, food_id, vitamin_id)
VALUES (27, 4, 8);
INSERT INTO food_vitamin(id, food_id, vitamin_id)
VALUES (28, 4, 2);
INSERT INTO food_vitamin(id, food_id, vitamin_id)
VALUES (29, 4, 11);
INSERT INTO food_vitamin(id, food_id, vitamin_id)
VALUES (30, 4, 13);
INSERT INTO food_vitamin(id, food_id, vitamin_id)
VALUES (31, 4, 6);
INSERT INTO food_vitamin(id, food_id, vitamin_id)
VALUES (32, 4, 9);
INSERT INTO food_vitamin(id, food_id, vitamin_id)
VALUES (33, 4, 10);
INSERT INTO food_vitamin(id, food_id, vitamin_id)
VALUES (34, 4, 1);
INSERT INTO food_vitamin(id, food_id, vitamin_id)
VALUES (35, 4, 12);
INSERT INTO food_vitamin(id, food_id, vitamin_id)
VALUES (36, 4, 14);
INSERT INTO food_vitamin(id, food_id, vitamin_id)
VALUES (37, 4, 5);
INSERT INTO food_vitamin(id, food_id, vitamin_id)
VALUES (38, 4, 7);
INSERT INTO food_vitamin(id, food_id, vitamin_id)
VALUES (39, 4, 3);
INSERT INTO food_vitamin(id, food_id, vitamin_id)
VALUES (40, 4, 4);
INSERT INTO food_vitamin(id, food_id, vitamin_id)
VALUES (41, 5, 10);



INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (1, 1, 8);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (2, 1, 4);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (3, 1, 9);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (4, 1, 12);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (5, 1, 13);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (6, 1, 16);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (7, 1, 10);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (8, 1, 14);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (9, 1, 11);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (10, 1, 1);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (11, 1, 3);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (12, 1, 7);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (13, 2, 4);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (14, 2, 16);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (15, 2, 5);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (16, 2, 7);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (17, 2, 13);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (18, 2, 14);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (19, 2, 8);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (20, 2, 11);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (21, 2, 1);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (22, 2, 12);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (23, 2, 13);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (24, 2, 3);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (25, 2, 6);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (26, 2, 9);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (27, 3, 14);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (28, 3, 5);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (29, 3, 1);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (30, 3, 16);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (31, 3, 12);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (32, 3, 10);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (33, 3, 13);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (34, 3, 8);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (35, 3, 6);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (36, 3, 7);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (37, 3, 11);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (38, 3, 9);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (39, 3, 3);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (40, 3, 4);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (41, 4, 12);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (42, 4, 5);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (43, 4, 6);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (44, 4, 16);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (45, 4, 14);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (46, 4, 9);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (47, 4, 10);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (48, 4, 11);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (49, 4, 8);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (50, 4, 13);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (51, 4, 7);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (52, 4, 1);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (53, 4, 3);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (54, 4, 4);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (55, 5, 1);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (56, 5, 12);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (57, 5, 14);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (58, 5, 7);
INSERT INTO food_mineral(id, food_id, mineral_id)
VALUES (59, 5, 8);


