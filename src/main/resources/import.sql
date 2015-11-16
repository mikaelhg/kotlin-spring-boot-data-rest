INSERT INTO restaurants (name, location, lat, lng) VALUES ('test', 'Helsinki', 123, 456);

INSERT INTO menus (restaurant_id, `date`, title, `text`) VALUES (1, CURRENT_DATE(), 'Soups', 'Hello, World!');
