/**
 * Copyright (c) 2011 Dutchworks All rights reserved.
 */

package org.searchworkings.news.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the news remote service. This utility wraps {@link org.searchworkings.news.service.impl.NewsServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Dutchworks
 * @see NewsService
 * @see org.searchworkings.news.service.base.NewsServiceBaseImpl
 * @see org.searchworkings.news.service.impl.NewsServiceImpl
 * @generated
 */
public class NewsServiceUtil {
    public static void clearService() {
        _service = null;
    }

    public static NewsService getService() {
        if (_service == null) {
            Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    NewsService.class.getName());
            ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    "portletClassLoader");

            ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
                    NewsService.class.getName(), portletClassLoader);

            _service = new NewsServiceClp(classLoaderProxy);

            ClpSerializer.setClassLoader(portletClassLoader);

            ReferenceRegistry.registerReference(NewsServiceUtil.class,
                "_service");
            MethodCache.remove(NewsService.class);
        }

        return _service;
    }

    public void setService(NewsService service) {
        MethodCache.remove(NewsService.class);

        _service = service;

        ReferenceRegistry.registerReference(NewsServiceUtil.class, "_service");
        MethodCache.remove(NewsService.class);
    }

    private static NewsService _service;
}