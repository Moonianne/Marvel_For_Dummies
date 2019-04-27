package org.pursuit.marvelfordummies;

public class DummyHero implements HeroSummary {
    @Override
    public String getName() {
        return "Iron-Man";
    }

    @Override
    public String getImage() {
        return "https://www.sideshow.com/storage/product-images/903341/iron-man-mark-iv_marvel_silo.png";
    }
}
