INSERT INTO restaurants (name, location, lat, lng) VALUES ('test', 'Helsinki', 123, 456);

INSERT INTO menus (restaurant_id, `date`, `text`) VALUES (1, CURRENT_DATE(), 'Hello, World!');
