package Model;

import java.util.List;

public class EventList {
    private int available;
    private int returned;
    private String collectionURI;
    private List<EventSummary> items;

    /**
     * @param available: The number of total available events in this list.
     * @param returned:  The number of events returned in this collection
     * @param collectionURI: The path to the full list of events in this collection.
     * @param items: The list of returned events in this collection.
     */
    public EventList(int available, int returned, String collectionURI, List<EventSummary> items) {
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

    public List<EventSummary> getItems() {
        return items;
    }

    public void setItems(List<EventSummary> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "EventList{" +
                "available=" + available +
                ", returned=" + returned +
                ", collectionURI='" + collectionURI + '\'' +
                ", items=" + items +
                '}';
    }
}
