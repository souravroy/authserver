-- Insert into users, ignore if already exists
INSERT INTO users (username, password, enabled)
VALUES ('user', '{noop}EazyBytes@12345', '1')
ON CONFLICT (username) DO NOTHING;

-- Insert into authorities, ignore if already exists
INSERT INTO authorities (username, authority)
VALUES ('user', 'read')
ON CONFLICT DO NOTHING;

-- Insert into users, ignore if already exists
INSERT INTO users (username, password, enabled)
VALUES ('admin', '{bcrypt}$2a$12$88.f6upbBvy0okEa7OfHFuorV29qeK.sVbB9VQ6J6dWM1bW6Qef8m', '1')
ON CONFLICT DO NOTHING;

-- Insert into authorities, ignore if already exists
INSERT INTO authorities (username, authority)
VALUES ('admin', 'admin')
ON CONFLICT DO NOTHING;