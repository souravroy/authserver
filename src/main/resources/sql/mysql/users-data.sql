INSERT IGNORE INTO `users` VALUES ('user', '{noop}EazyBytes@12345', '1');
INSERT IGNORE INTO `authorities` VALUES ('user', 'read');

-- password: "EazyBytes@54321". Check out from-> https://bcrypt-generator.com/
INSERT IGNORE INTO `users` VALUES ('admin', '{bcrypt}$2a$12$88.f6upbBvy0okEa7OfHFuorV29qeK.sVbB9VQ6J6dWM1bW6Qef8m', '1');
INSERT IGNORE INTO `authorities` VALUES ('admin', 'admin');