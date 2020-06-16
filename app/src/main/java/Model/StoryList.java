package Model;

import java.util.List;

public class StoryList {
    private int available;
    private int returned;
    private int collectionURI;
    private List<StorySummary> items;

    public StoryList(int available, int returned, int collectionURI, List<StorySummary> items) {
        this.available = available;
        this.returned = returned;
        this.collectionURI = collectionURI;
        this.items = items;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getReturned() {
        return returned;
    }

    public void setReturned(int returned) {
        this.returned = returned;
    }

    public int getCollectionURI() {
        return collectionURI;
    }

    public void setCollectionURI(int collectionURI) {
        this.collectionURI = collectionURI;
    }

    public List<StorySummary> getItems() {
        return items;
    }

    public void setItems(List<StorySummary> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "StoryList{" +
                "available=" + available +
                ", returned=" + returned +
                ", collectionURI=" + collectionURI +
                ", items=" + items +
                '}';
    }
}
