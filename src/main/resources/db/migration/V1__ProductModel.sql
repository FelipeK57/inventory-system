CREATE TABLE "products"
(
    "id"         BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    "sku"        VARCHAR(255) UNIQUE NOT NULL,
    "name"       VARCHAR(255)        NOT NULL,
    "is_active"  BOOLEAN             NOT NULL,
    "price"      DECIMAL(10, 2)      NOT NULL,
    "created_at" TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)