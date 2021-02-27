package com.example.groupproject.Model;

import java.util.List;

public class MovieResponse {
    private int page,total_results,total_pages;
    private List<MovieResponseResults> results;

    public MovieResponse() {
    }

    public MovieResponse(int page, int total_results, int total_pages, List<MovieResponseResults> results) {
        this.page = page;
        this.total_results = total_results;
        this.total_pages = total_pages;
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<MovieResponseResults> getResults() {
        return results;
    }

    public void setResults(List<MovieResponseResults> results) {
        this.results = results;
    }
}
