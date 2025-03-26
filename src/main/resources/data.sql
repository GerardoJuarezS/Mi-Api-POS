INSERT INTO usuarios (username, password, roles, fecha_registro) 
VALUES (
    'admin', 
    '$2a$10$ABCDEFGHIJKLMNOPQRSTUVu7s.7Z9yLX7W6QZ6YtT3W1V2X3Y4Z5a', -- Contraseña: Admin1234! 
    ARRAY['ADMIN'],
    '2021-01-01'
);