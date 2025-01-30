package com.betagames.dto;

/**
 *
 * @author Fabrini Marco
 */
public class EditorsDTO {
    private Integer id;
    private String name;
    private String website;

    public EditorsDTO(Integer id, String name, String website) {
        this.id = id;
        this.name = name;
        this.website = website;
    }

    @Override
    public String toString() {
        return "EditorsDTO [id=" + id + ", name=" + name + ", website=" + website + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

}// class
