package Model;

public class ComicSummary {
    private String name;
    private String resourceURI;

    /**
     * @param name: The canonical name of the comic.
     * @param resourceURI: The path to the individual comic resource.,
     */
    public ComicSummary(String name, String resourceURI) {
        this.name = name;
        this.resourceURI = resourceURI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    @Override
    public String toString() {
        return "ComicSummary{" +
                "name='" + name + '\'' +
                ", resourceURI='" + resourceURI + '\'' +
                '}';
    }
}
