package com.betagames.dto;

/**
 *
 * @author Cristhian Guerrero
 */

public class CategoriesDTO {

    private Integer id;
    private String name;

    public CategoriesDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "CategoriesDTO [id=" + id + ", name=" + name + "]";
    }

}
