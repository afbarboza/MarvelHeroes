package Model;

public class SeriesSummary {
    private String name;
    private String resourceURI;

    /**
     * @param name: The path to the individual series resource
     * @param resourceURI: The canonical name of the series.
     */
    public SeriesSummary(String name, String resourceURI) {
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
        return "SeriesSummary{" +
                "name='" + name + '\'' +
                ", resourceURI='" + resourceURI + '\'' +
                '}';
    }
}
