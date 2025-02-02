package Model;

import java.util.List;

public class ComicList {
    private int available;
    private int returned;
    private String collectionURI;
    private List<ComicSummary> items;

    /**
     * @param available: The number of total available issues in this list.
     * @param returned: The number of issues returned in this collection
     * @param collectionURI: The path to the full list of issues in this collection.,
     * @param items:  The list of returned issues in this collection.
     */
    public ComicList(int available, int returned, String collectionURI, List<ComicSummary> items) {
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

    public List<ComicSummary> getItems() {
        return items;
    }

    public void setItems(List<ComicSummary> items) {
        this.items = items;
    }
}
