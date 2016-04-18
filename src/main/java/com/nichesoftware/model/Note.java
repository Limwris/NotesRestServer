package com.nichesoftware.model;

import java.util.UUID;

/**
 * Created by n_che on 15/04/2016.
 */
public class Note {
    /**
     * Identifiant unique de la note
     */
    private String id;
    /**
     * Titre de la note
     */
    private String title;
    /**
     * Description de la note
     */
    private String description;

    /**
     * Constructeur
     * @param title
     * @param description
     */
    public Note(final String title, final String description) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
    }

    /**
     * Getter sur la description de la note
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Getter sur l'identifiant unique de la note
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Getter sur le titre de la note
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter sur la description de la note
     * @param description
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * Setter sur l'identifiant unique de la note
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Setter sur le titre de la note
     * @param title
     */
    public void setTitle(final String title) {
        this.title = title;
    }
}
