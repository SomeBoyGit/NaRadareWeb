package ru.someboy.naradareweb.model;

import org.springframework.stereotype.Component;

/**
 * @author Slipets Artem
 */
@Component
public class Search {
    public String searchText;

    public Search(String searchText) {
        this.searchText = searchText;
    }

    public Search() {

    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    @Override
    public String toString() {
        return searchText;
    }
}
