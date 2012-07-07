/**
 * Copyright (c) 2011 Dutchworks All rights reserved.
 */

package org.searchworkings.news.service;

import com.liferay.portal.kernel.util.ClassLoaderProxy;

/**
 * @author Dutchworks
 */
public class NewsServiceClp implements NewsService {
    public NewsServiceClp(ClassLoaderProxy classLoaderProxy) {
        _classLoaderProxy = classLoaderProxy;
    }

    public ClassLoaderProxy getClassLoaderProxy() {
        return _classLoaderProxy;
    }

    private ClassLoaderProxy _classLoaderProxy;
}