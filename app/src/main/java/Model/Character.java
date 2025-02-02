package Model;

import java.util.Date;
import java.util.List;

public class Character {
    private int id;
    private String name;
    private String description;
    private Date modified;
    private String resourceURI;
    private List<Url> urls;
    private Image thumbnail;
    private ComicList comics;
    private StoryList stories;
    private EventList events;
    private SeriesList series;

    /**
     * @param id: The unique ID of the character resource.,
     * @param name: The name of the character.,
     * @param description: A short bio or description of the character.,
     * @param modified:  The date the resource was most recently modified.,
     * @param resourceURI:  The canonical URL identifier for this resource.,
     * @param urls: A set of public web site URLs for the resource.,
     * @param thumbnail:  The representative image for this character.,
     * @param comics: A resource list containing comics which feature this character.,
     * @param stories: A resource list of stories in which this character appears.,
     * @param events: A resource list of events in which this character appears.,
     * @param series: A resource list of series in which this character appears.
     */
    public Character(int id, String name, String description, Date modified, String resourceURI,
                     List<Url> urls, Image thumbnail, ComicList comics, StoryList stories,
                     EventList events, SeriesList series) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.modified = modified;
        this.resourceURI = resourceURI;
        this.urls = urls;
        this.thumbnail = thumbnail;
        this.comics = comics;
        this.stories = stories;
        this.events = events;
        this.series = series;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public List<Url> getUrls() {
        return urls;
    }

    public void setUrls(List<Url> urls) {
        this.urls = urls;
    }

    public Image getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Image thumbnail) {
        this.thumbnail = thumbnail;
    }

    public ComicList getComics() {
        return comics;
    }

    public void setComics(ComicList comics) {
        this.comics = comics;
    }

    public StoryList getStories() {
        return stories;
    }

    public void setStories(StoryList stories) {
        this.stories = stories;
    }

    public EventList getEvents() {
        return events;
    }

    public void setEvents(EventList events) {
        this.events = events;
    }

    public SeriesList getSeries() {
        return series;
    }

    public void setSeries(SeriesList series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", modified=" + modified +
                ", resourceURI='" + resourceURI + '\'' +
                ", urls=" + urls +
                ", thumbnail=" + thumbnail +
                ", comics=" + comics +
                ", stories=" + stories +
                ", events=" + events +
                ", series=" + series +
                '}';
    }
}
