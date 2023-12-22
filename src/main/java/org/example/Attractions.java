package org.example;

public class Attractions {
    private String name;
    private String description;

    private Integer uniqueid;
    private double tickPrice;
    private boolean openClose;

    private int visitCount;

    public int getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }

    public boolean isOpenClose() {
        return openClose;
    }

    public void setOpenClose(boolean openClose) {
        this.openClose = openClose;
    }

    public Integer getUniqueid() {
        return uniqueid;
    }

    public void setUniqueid(Integer uniqueid) {
        this.uniqueid = uniqueid;
    }

    public double getTickPrice() {
        return tickPrice;
    }

    public void setTickPrice(double tickPrice) {
        this.tickPrice = tickPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private static int attractionIdCounter = 0;

    public Attractions(String name, String description) {
        this.setOpenClose(false);
        this.name = name;
        this.description = description;
        this.visitCount=0;
        this.uniqueid = attractionIdCounter++;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n Description: " + description;
    }



}
