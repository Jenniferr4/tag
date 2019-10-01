package org.improving.tag.items;

public enum UniqueItems implements Item {
    THE_ONE_RING("A Golden Ring"),
    BLUE_SHELL ("A Blue Shell with Wings"),
    NOTHING ("") {
        public String getDescription(){
            throw new UnsupportedOperationException();
        }
    };

    private final String description;

    UniqueItems(String description) {
        this.description =  description;
    }

    @Override
    public String toString() {
        return description;
    }
}

