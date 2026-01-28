CREATE TABLE habits (
    id           BINARY(16) PRIMARY KEY,
    name         VARCHAR(100) NOT NULL,
    icon         VARCHAR(50),
    goal         INT NOT NULL,
    completed    INT DEFAULT 0,
    category     VARCHAR(50),
    week_data    JSON NOT NULL,
    user_id      BINARY(16) NOT NULL,
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                  ON UPDATE CURRENT_TIMESTAMP,

    CONSTRAINT fk_habits_user
        FOREIGN KEY (user_id)
        REFERENCES users(id)
        ON DELETE CASCADE
);
CREATE TABLE tasks (
    id           BINARY(16) PRIMARY KEY,
    title        VARCHAR(150) NOT NULL,
    completed    BOOLEAN DEFAULT FALSE,
    due_date     DATETIME NOT NULL,
    priority     VARCHAR(20),
    user_id      BINARY(16) NOT NULL,
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_tasks_user
        FOREIGN KEY (user_id)
        REFERENCES users(id)
        ON DELETE CASCADE
);
CREATE INDEX idx_goals_user ON goals(user_id);
CREATE INDEX idx_habits_user ON habits(user_id);
CREATE INDEX idx_tasks_user ON tasks(user_id);
