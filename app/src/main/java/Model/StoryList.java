package Model;

import java.util.List;

public class StoryList {
    private int available;
    private int returned;
    private String collectionURI;
    private List<StorySummary> items;

    /**
     * @param available: The number of total available stories in this list.
     * @param returned: The number of stories returned in this collection (up to 20).,
     * @param collectionURI: The path to the full list of stories in this collection.,
     * @param items:  The list of returned stories in this collection.
     */
    public StoryList(int available, int returned, String collectionURI, List<StorySummary> items) {
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

    public String getCollectionURI() {
        return collectionURI;
    }

    public void setCollectionURI(String collectionURI) {
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
