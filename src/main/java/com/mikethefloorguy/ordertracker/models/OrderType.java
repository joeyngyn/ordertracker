package com.mikethefloorguy.ordertracker.models;

public enum OrderType {

    HARDWOOD("Hardwood"),
    LAMINATE("Laminate"),
    VINYL("Vinyl"),
    LINOLEUM("Linoleum"),
    PORCELAIN("Porcelain"),
    CERAMIC("Ceramic"),
    STONE("Stone"),
    CARPET("Carpet");

    private final String displayName;

    OrderType(String displayName){
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
