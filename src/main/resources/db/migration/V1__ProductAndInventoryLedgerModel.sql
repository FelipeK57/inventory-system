CREATE TABLE products
(
    id         BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    sku        VARCHAR(255) UNIQUE NOT NULL,
    name       VARCHAR(255)        NOT NULL,
    is_active  BOOLEAN             NOT NULL,
    price      DECIMAL(10, 2)      NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE inventory_ledger
(
    id            BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    product_id    BIGINT         NOT NULL REFERENCES products (id),
    movement_type VARCHAR(20)    NOT NULL,
    -- IN | OUT | ADJUSTMENT
    quantity      NUMERIC(19, 4) NOT NULL CHECK (quantity > 0),
    unit_cost     NUMERIC(19, 4),
    reference     VARCHAR(255),
    created_at    TIMESTAMP      NOT NULL DEFAULT NOW()
);