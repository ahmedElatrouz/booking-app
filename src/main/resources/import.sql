INSERT INTO Hotel (name, location, rating, amenities) VALUES
  ('The Grand Hotel', 'New York', 5, 'pool, spa, gym');

INSERT INTO Room (hotel_id, room_type, num_beds, price, availability) VALUES
  (1, 'DOUBLE', 2, 199.99, true),
  (1, 'SINGLE', 1, 149.99, true),
  (1, 'DOUBLE', 2, 249.99, false),
  (1, 'SUITE', 4, 399.99, true);

INSERT INTO User (name, email, phone) VALUES
  ('John Smith', 'john.smith@example.com', '555-555-1212'),
  ('Jane Doe', 'jane.doe@example.com', '555-555-1213'),
  ('Bob Johnson', 'bob.johnson@example.com', '555-555-1214');