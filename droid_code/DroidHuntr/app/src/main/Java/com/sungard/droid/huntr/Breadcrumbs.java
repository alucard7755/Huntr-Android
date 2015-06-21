package com.sungard.droid.huntr;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;

public class Breadcrumbs {

    @Expose
    private List<Breadcrumb> breadcrumbs = new ArrayList<Breadcrumb>();

    /**
     *
     * @return
     * The breadcrumbs
     */
    public List<Breadcrumb> getBreadcrumbs() {
        return breadcrumbs;
    }

    /**
     *
     * @param breadcrumbs
     * The breadcrumbs
     */
    public void setBreadcrumbs(List<Breadcrumb> breadcrumbs) {
        this.breadcrumbs = breadcrumbs;
    }

    public Breadcrumbs withBreadcrumbs(List<Breadcrumb> breadcrumbs) {
        this.breadcrumbs = breadcrumbs;
        return this;
    }

    public String toString() {
        return "[Breadcrumbs] " + breadcrumbs ;
    }
}