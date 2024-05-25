-- Dropping existing tables
drop table if exists reviews cascade;
drop table if exists restaurants cascade;
drop table if exists users cascade;

-- Creating tables
create table restaurants (
                             id bigint generated by default as identity,
                             address varchar(255) not null,
                             avg_rating float(53) not null,
                             city varchar(255) not null,
                             contact_email varchar(255),
                             contact_phone varchar(255),
                             cuisine varchar(255) not null,
                             image_url varchar(255) not null,
                             menu varchar(255),
                             name varchar(255) not null,
                             opening_hours varchar(255),
                             pincode varchar(255) not null,
                             price_range float(53) not null,
                             state varchar(255) not null,
                             primary key (id)
);

create table users (
                       id bigint generated by default as identity,
                       email varchar(255) not null,
                       first_name varchar(255) not null,
                       last_name varchar(255) not null,
                       password varchar(255) not null,
                       primary key (id)
);

alter table users
drop constraint if exists UK6dotkott2kjsp8vw4d0m25fb7;

alter table users
    add constraint UK6dotkott2kjsp8vw4d0m25fb7
        unique (email);

create table reviews (
                         id bigint generated by default as identity,
                         rating integer not null,
                         restaurant_id bigint not null,
                         text varchar(255),
                         user_name varchar(255) not null,
                         primary key (id)
);

-- Inserting sample data into restaurants table
INSERT INTO restaurants (address, avg_rating, city, contact_email, contact_phone, cuisine, image_url, menu, name, opening_hours, pincode, price_range, state) VALUES
                                                                                                                                                                  ('123 Main St, Springfield', 5.0, 'Springfield', 'contact@luigis.com', '555-1234', 'Italian', 'https://source.unsplash.com/1600x900/?restaurant', 'menu1.pdf', 'Luigis', 'Mon-Sun 11:00-22:00', '12345', 2.0, 'IL'),
                                                                                                                                                                  ('456 Elm St, Springfield', 4.0, 'Springfield', 'contact@burgerhaven.com', '555-5678', 'Fast Food', 'https://source.unsplash.com/1600x900/?restaurant', 'menu2.pdf', 'Burger Haven', 'Mon-Sun 10:00-23:00', '12345', 1.0, 'IL'),
                                                                                                                                                                  ('789 Oak St, Springfield', 3.0, 'Springfield', 'contact@sushiworld.com', '555-8765', 'Sushi', 'https://source.unsplash.com/1600x900/?restaurant', 'menu3.pdf', 'Sushi World', 'Mon-Sun 12:00-21:00', '12345', 3.0, 'IL');

-- Inserting sample data into users table
INSERT INTO users (email, first_name, last_name, password) VALUES
                                                               ('john.doe@example.com', 'John', 'Doe', 'password123'),
                                                               ('jane.smith@example.com', 'Jane', 'Smith', 'password456'),
                                                               ('admin@example.com', 'Admin', 'User', 'adminpassword'),
                                                               ('gg@gg.com','gg','gg','$2a$10$iBN.dWu7SijTEeWefoG8V.c4MVAmcZiHxBcokTtNv4/sb9n5VAnIC');

-- Inserting sample data into reviews table
INSERT INTO reviews (rating, restaurant_id, text, user_name) VALUES
                                                                 (5, 1, 'Amazing food and great service!', 'John'),
                                                                 (4, 2, 'Good burgers but the fries were a bit salty.', 'Jane'),
                                                                 (3, 3, 'Sushi was fresh but the wait time was long.', 'Admin');

INSERT INTO restaurants (address, avg_rating, city, contact_email, contact_phone, cuisine, image_url, menu, name, opening_hours, pincode, price_range, state) VALUES
                                                                                                                                                                  ('101 Maple St, Springfield', 4.5, 'Springfield', 'contact@pizzapalace.com', '555-4321', 'Pizza', 'https://source.unsplash.com/1600x900/?restaurant', 'menu4.pdf', 'Pizza Palace', 'Mon-Sun 11:00-22:00', '12345', 2.5, 'IL'),
                                                                                                                                                                  ('202 Pine St, Springfield', 3.5, 'Springfield', 'contact@steakhouse.com', '555-5432', 'Steakhouse', 'https://source.unsplash.com/1600x900/?restaurant', 'menu5.pdf', 'Steak House', 'Mon-Sun 17:00-23:00', '12345', 3.5, 'IL'),
                                                                                                                                                                  ('303 Birch St, Springfield', 4.2, 'Springfield', 'contact@veggiedelight.com', '555-6543', 'Vegetarian', 'https://source.unsplash.com/1600x900/?restaurant', 'menu6.pdf', 'Veggie Delight', 'Mon-Sun 10:00-21:00', '12345', 2.0, 'IL'),
                                                                                                                                                                  ('404 Cedar St, Springfield', 2.8, 'Springfield', 'contact@bbqking.com', '555-7654', 'BBQ', 'https://source.unsplash.com/1600x900/?restaurant', 'menu7.pdf', 'BBQ King', 'Mon-Sun 11:00-22:00', '12345', 3.0, 'IL'),
                                                                                                                                                                  ('505 Walnut St, Springfield', 4.7, 'Springfield', 'contact@tacotown.com', '555-8765', 'Mexican', 'https://source.unsplash.com/1600x900/?restaurant', 'menu8.pdf', 'Taco Town', 'Mon-Sun 11:00-21:00', '12345', 1.5, 'IL');
INSERT INTO users (email, first_name, last_name, password) VALUES
                                                               ('mike.jones@example.com', 'Mike', 'Jones', 'password789'),
                                                               ('susan.lee@example.com', 'Susan', 'Lee', 'password101'),
                                                               ('david.wong@example.com', 'David', 'Wong', 'password202'),
                                                               ('laura.garcia@example.com', 'Laura', 'Garcia', 'password303'),
                                                               ('james.brown@example.com', 'James', 'Brown', 'password404');
INSERT INTO reviews (rating, restaurant_id, text, user_name) VALUES
                                                                 (4, 4, 'Great steak but a bit pricey.', 'Mike'),
                                                                 (5, 5, 'Loved the vegetarian options!', 'Susan'),
                                                                 (2, 6, 'BBQ sauce was too sweet.', 'David'),
                                                                 (4, 7, 'Fantastic tacos, will come again!', 'Laura'),
                                                                 (3, 1, 'Good pizza but the service was slow.', 'James'),
                                                                 (5, 2, 'Best burgers in town!', 'Mike'),
                                                                 (3, 3, 'Sushi was just okay.', 'Susan'),
                                                                 (4, 4, 'Really enjoyed the BBQ ribs.', 'David'),
                                                                 (2, 5, 'Not many vegan options.', 'Laura'),
                                                                 (4, 6, 'Great vegetarian dishes.', 'James'),
                                                                 (3, 7, 'Tacos were decent but nothing special.', 'Mike'),
                                                                 (5, 1, 'Loved the ambiance and the food.', 'Susan');
