package Model;

import java.util.List;

public class SeriesList {
    private int available;
    private int returned;
    private String collectionURI;
    private List<SeriesSummary> items;

    /**
     * @param available: The number of total available series in this list.
     * @param returned:  The number of series returned in this collection (up to 20)
     * @param collectionURI: The path to the full list of series in this collection.
     * @param items: The list of returned series in this collection.
     */
    public SeriesList(int available, int returned, String collectionURI, List<SeriesSummary> items) {
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

    public List<SeriesSummary> getItems() {
        return items;
    }

    public void setItems(List<SeriesSummary> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "SeriesList{" +
                "available=" + available +
                ", returned=" + returned +
                ", collectionURI='" + collectionURI + '\'' +
                ", items=" + items +
                '}';
    }
}
