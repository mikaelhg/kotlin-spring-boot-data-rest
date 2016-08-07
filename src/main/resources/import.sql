INSERT INTO restaurants (name, location, lat, lng) VALUES ('test', 'Helsinki', 123, 456);

INSERT INTO menus (restaurant_id, menu_date, title, menu_text) VALUES (1, CURRENT_DATE(), 'Soups', 'Hello, World!');
