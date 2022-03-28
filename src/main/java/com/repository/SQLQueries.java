package com.repository;

public class SQLQueries {
    public static final String SELECT_ALL_FLOWERS = "SELECT p FROM Flower p";
    public static final String SELECT_ALL_FLOWER_BY_ID = "SELECT p FROM Flower p WHERE p.flowerId = :id";
    public static final String SELECT_ALL_FLOWER_BY_NAME = "SELECT p FROM Flower p WHERE p.name = :name";

    public static final String SELECT_ALL_FLOWERS_FOR_ORDERING = "SELECT p FROM Flowersforordering p";
    public static final String SELECT_ALL_FLOWERS_FOR_ORDERING_BY_ID =
            "SELECT p FROM Flowersforordering p WHERE p.flowersForOrderingId = :id";

    public static final String SELECT_ALL_FLOWERS_ORDER = "SELECT p FROM Flowersorder p";
    public static final String SELECT_ALL_FLOWERS_ORDER_BY_ID =
            "SELECT p FROM Flowersorder p WHERE p.flowersOrderId = :id";

    public static final String SELECT_ALL_CUSTOMERS = "SELECT p FROM Customer p";
    public static final String SELECT_ALL_CUSTOMERS_BY_ID =
            "SELECT p FROM Customer p WHERE p.customerId = :id";
}
