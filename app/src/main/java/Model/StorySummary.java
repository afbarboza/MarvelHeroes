package Model;

public class StorySummary {
    private String name;
    private String type;
    private String resourceURI;

    /**
     * @param name: The canonical name of the story
     * @param type: The type of the story (interior or cover).
     * @param resourceURI: The path to the individual story resource.,
     */
    public StorySummary(String name, String type, String resourceURI) {
        this.name = name;
        this.type = type;
        this.resourceURI = resourceURI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    @Override
    public String toString() {
        return "StorySummary{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", resourceURI='" + resourceURI + '\'' +
                '}';
    }
}
