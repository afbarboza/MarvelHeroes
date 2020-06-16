package Model;

public class CharacterDataWrapper {
    private int code;
    private String status;
    private String copyright;
    private String attributionText;
    private String attributionHTML;
    private CharacterDataContainer data;
    private String etag;

    /**
     * @param code: The HTTP status code of the returned result.,
     * @param status: A string description of the call status.,
     * @param copyright: The copyright notice for the returned result.,
     * @param attributionText: The attribution notice for this result.
     * @param attributionHTML: An HTML representation of the attribution notice for this result.
     * @param data: The results returned by the call.,
     * @param etag: A digest value of the content returned by the call.
     */
    public CharacterDataWrapper(int code, String status, String copyright, String attributionText,
                                String attributionHTML, CharacterDataContainer data, String etag) {
        this.code = code;
        this.status = status;
        this.copyright = copyright;
        this.attributionText = attributionText;
        this.attributionHTML = attributionHTML;
        this.data = data;
        this.etag = etag;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getAttributionText() {
        return attributionText;
    }

    public void setAttributionText(String attributionText) {
        this.attributionText = attributionText;
    }

    public String getAttributionHTML() {
        return attributionHTML;
    }

    public void setAttributionHTML(String attributionHTML) {
        this.attributionHTML = attributionHTML;
    }

    public CharacterDataContainer getData() {
        return data;
    }

    public void setData(CharacterDataContainer data) {
        this.data = data;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }
}
