package Model;

import java.util.List;

public class CharacterDataContainer {
    private int offset;
    private int limit;
    private int total;
    private int count;
    private List<Character> results;

    /**
     * @param offset: The requested offset (number of skipped results) of the call.,
     * @param limit: The requested result limit.,
     * @param total: The total number of resources available given the current filter set.,
     * @param count : The total number of results returned by this call.,
     * @param results:  The list of characters returned by the call.
     */
    public CharacterDataContainer(int offset, int limit, int total, int count, List<Character> results) {
        this.offset = offset;
        this.limit = limit;
        this.total = total;
        this.results = results;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Character> getResults() {
        return results;
    }

    public void setResults(List<Character> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "CharacterDataContainer{" +
                "offset=" + offset +
                ", limit=" + limit +
                ", total=" + total +
                ", results=" + results +
                '}';
    }
}
