CREATE TABLE batches
(
    id   BIGINT NOT NULL,
    name VARCHAR(255) NULL,
    CONSTRAINT pk_batches PRIMARY KEY (id)
);

CREATE TABLE learners
(
    id         BIGINT NOT NULL,
    name       VARCHAR(255) NULL,
    batches_id BIGINT NULL,
    CONSTRAINT pk_learners PRIMARY KEY (id)
);

CREATE TABLE products
(
    id            BIGINT AUTO_INCREMENT NOT NULL,
    name          VARCHAR(255) NULL,
    category      VARCHAR(255) NULL,
    `description` VARCHAR(255) NULL,
    CONSTRAINT pk_products PRIMARY KEY (id)
);

ALTER TABLE learners
    ADD CONSTRAINT FK_LEARNERS_ON_BATCHES FOREIGN KEY (batches_id) REFERENCES batches (id);