/**
 * Copyright (c) 2011 Dutchworks All rights reserved.
 */

package org.searchworkings.news.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link NewsService}.
 * </p>
 *
 * @author    Dutchworks
 * @see       NewsService
 * @generated
 */
public class NewsServiceWrapper implements NewsService,
    ServiceWrapper<NewsService> {
    public NewsServiceWrapper(NewsService newsService) {
        _newsService = newsService;
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public NewsService getWrappedNewsService() {
        return _newsService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedNewsService(NewsService newsService) {
        _newsService = newsService;
    }

    public NewsService getWrappedService() {
        return _newsService;
    }

    public void setWrappedService(NewsService newsService) {
        _newsService = newsService;
    }

    private NewsService _newsService;
}