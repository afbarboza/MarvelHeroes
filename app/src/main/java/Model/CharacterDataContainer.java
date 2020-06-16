package Model;

import java.util.List;

public class CharacterDataContainer {
    private int offset;
    private int limit;
    private int total;
    private List<Character> results;

    public CharacterDataContainer(int offset, int limit, int total, List<Character> results) {
        this.offset = offset;
        this.limit = limit;
        this.total = total;
        this.results = results;
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
