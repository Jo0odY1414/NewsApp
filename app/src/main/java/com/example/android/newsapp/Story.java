package com.example.android.newsapp;

/**
 * Created by Mj0o0oD on 08/10/2017.
 */

public class Story {

    /**
     * Constant value that represents no author name was provided for this story
     */
    private static final String NO_AUTHOR_NAME_PROVIDED = "Author: N/A";

    /**
     * Constant value that represents no published date was provided for this story
     */
    private static final String NO_PUBLISHED_DATE_PROVIDED = "N/A";

    /**
     * Title of the story
     */
    private String title;

    /**
     * Type of the story
     */
    private String type;

    /**
     * Section name of the story
     */
    private String sectionName;

    /**
     * Author name of the story
     */
    private String authorName;

    /**
     * Date published of the story
     */
    private String publicationDate;

    /**
     * Website URL of the story
     */
    private String url;

    /**
     * Constructs a new {@link Story} object.
     *
     * @param storyTitle       is the title of the story
     * @param storyType        is the type of the story
     * @param storySectionName is the section name of the story
     * @param storyUrl         is the story URL to find more details about the story
     */
    public Story(String storyTitle, String storyType, String storySectionName, String storyUrl) {
        title = storyTitle;
        type = storyType;
        sectionName = storySectionName;
        url = storyUrl;
        authorName = NO_AUTHOR_NAME_PROVIDED;
        publicationDate = NO_PUBLISHED_DATE_PROVIDED;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Returns whether or not there is an author name for this story.
     */
    public boolean hasAuthor() {
        return !(authorName.equalsIgnoreCase(NO_AUTHOR_NAME_PROVIDED)) && !(authorName.isEmpty());
    }

    /**
     * Returns whether or not there is a published date for this story.
     */
    public boolean hasDate() {
        return !(publicationDate.equalsIgnoreCase(NO_PUBLISHED_DATE_PROVIDED)) && !(publicationDate.isEmpty());
    }
}
