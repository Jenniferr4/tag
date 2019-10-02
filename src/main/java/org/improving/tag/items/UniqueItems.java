package org.improving.tag.items;

public enum UniqueItems implements Item {
    THE_UNFORGETTABLE_MUSHROOM("An Edible Toad", "The Unforgettable Mushroom"),
    THE_EGOO_WAFFLE("Part of a balanced diet", "Eggo Waffle"),
    EVERLASTING_GOBSTOPPER("A gobstopper that never loses its flavor", "The Everlasting Gobstopper"),
    THE_ONE_RING("A Golden Ring", "The One Ring"),
    BLUE_SHELL("A Blue Shell with Wings", "A Blue Shell"),
    NOTHING("", "") {
        public String getDescription() {
            throw new UnsupportedOperationException();
        }
    };

    private final String description;
    private final String name;

    UniqueItems(String description, String name) {
        this.description = description;
        this.name = name;
    }

    @Override
    public String toString() {
        return name + ": " + description;
    }

    @Override
    public String getName() {
        return name;
    }
}

