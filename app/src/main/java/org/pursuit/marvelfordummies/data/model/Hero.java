package org.pursuit.marvelfordummies.data.model;

import org.pursuit.marvelfordummies.recyclerview.HeroSummary;

public final class Hero implements HeroSummary {
    public final int id;
    public final String name;
    public final String description;
    public final String modified;
    public final Thumbnail thumbnail;
    public final String resourceURI;
    public final Comics comics;
    public final Link[] urls;

    public Hero(int id, String name, String description, String modified, Thumbnail thumbnail, String resourceURI, Comics comics, Link[] urls) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.modified = modified;
        this.thumbnail = thumbnail;
        this.resourceURI = resourceURI;
        this.comics = comics;
        this.urls = urls;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getImage() {
        return thumbnail.path + ".jpg";
    }

    private final class Thumbnail {
        public final String path;
        public final String extension;

        public Thumbnail(String path, String extension) {
            this.path = path;
            this.extension = extension;
        }
    }

    private final class Comics {
        private final int available;
        private final String collectionURI;
        private final Item[] items;

        public Comics(int available, String collectionURI, Item[] items) {
            this.available = available;
            this.collectionURI = collectionURI;
            this.items = items;
        }

        private final class Item {
            String resourceURI;
            String name;

            public Item(String resourceURI, String name) {
                this.resourceURI = resourceURI;
                this.name = name;
            }
        }
    }

    public final class Link {
        public final String type;
        public final String url;

        public Link(String type, String url) {
            this.type = type;
            this.url = url;
        }
    }

}
