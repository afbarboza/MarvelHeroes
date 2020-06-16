package Model;

public class Url {
    private String type;
    private String url;

    /**
     * @param type: A text identifier for the URL.,
     * @param url:  A full URL (including scheme, domain, and path).
     */
    public Url(String type, String url) {
        this.type = type;
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Url{" +
                "type='" + type + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
