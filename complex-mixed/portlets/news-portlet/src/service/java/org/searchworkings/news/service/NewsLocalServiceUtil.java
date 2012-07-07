/**
 * Copyright (c) 2011 Dutchworks All rights reserved.
 */

package org.searchworkings.news.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the news local service. This utility wraps {@link org.searchworkings.news.service.impl.NewsLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Dutchworks
 * @see NewsLocalService
 * @see org.searchworkings.news.service.base.NewsLocalServiceBaseImpl
 * @see org.searchworkings.news.service.impl.NewsLocalServiceImpl
 * @generated
 */
public class NewsLocalServiceUtil {
    /**
    * Adds the news to the database. Also notifies the appropriate model listeners.
    *
    * @param news the news
    * @return the news that was added
    * @throws SystemException if a system exception occurred
    */
    public static org.searchworkings.news.model.News addNews(
        org.searchworkings.news.model.News news)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addNews(news);
    }

    /**
    * Creates a new news with the primary key. Does not add the news to the database.
    *
    * @param newsId the primary key for the new news
    * @return the new news
    */
    public static org.searchworkings.news.model.News createNews(long newsId) {
        return getService().createNews(newsId);
    }

    /**
    * Deletes the news with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param newsId the primary key of the news
    * @throws PortalException if a news with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static void deleteNews(long newsId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().deleteNews(newsId);
    }

    /**
    * Deletes the news from the database. Also notifies the appropriate model listeners.
    *
    * @param news the news
    * @throws SystemException if a system exception occurred
    */
    public static void deleteNews(org.searchworkings.news.model.News news)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().deleteNews(news);
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    public static org.searchworkings.news.model.News fetchNews(long newsId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchNews(newsId);
    }

    /**
    * Returns the news with the primary key.
    *
    * @param newsId the primary key of the news
    * @return the news
    * @throws PortalException if a news with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static org.searchworkings.news.model.News getNews(long newsId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getNews(newsId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns the news with the UUID in the group.
    *
    * @param uuid the UUID of news
    * @param groupId the group id of the news
    * @return the news
    * @throws PortalException if a news with the UUID in the group could not be found
    * @throws SystemException if a system exception occurred
    */
    public static org.searchworkings.news.model.News getNewsByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getNewsByUuidAndGroupId(uuid, groupId);
    }

    /**
    * Returns a range of all the newses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of newses
    * @param end the upper bound of the range of newses (not inclusive)
    * @return the range of newses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<org.searchworkings.news.model.News> getNewses(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getNewses(start, end);
    }

    /**
    * Returns the number of newses.
    *
    * @return the number of newses
    * @throws SystemException if a system exception occurred
    */
    public static int getNewsesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getNewsesCount();
    }

    /**
    * Updates the news in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param news the news
    * @return the news that was updated
    * @throws SystemException if a system exception occurred
    */
    public static org.searchworkings.news.model.News updateNews(
        org.searchworkings.news.model.News news)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateNews(news);
    }

    /**
    * Updates the news in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param news the news
    * @param merge whether to merge the news with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the news that was updated
    * @throws SystemException if a system exception occurred
    */
    public static org.searchworkings.news.model.News updateNews(
        org.searchworkings.news.model.News news, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateNews(news, merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static void clearService() {
        _service = null;
    }

    public static NewsLocalService getService() {
        if (_service == null) {
            Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    NewsLocalService.class.getName());
            ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    "portletClassLoader");

            ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
                    NewsLocalService.class.getName(), portletClassLoader);

            _service = new NewsLocalServiceClp(classLoaderProxy);

            ClpSerializer.setClassLoader(portletClassLoader);

            ReferenceRegistry.registerReference(NewsLocalServiceUtil.class,
                "_service");
            MethodCache.remove(NewsLocalService.class);
        }

        return _service;
    }

    public void setService(NewsLocalService service) {
        MethodCache.remove(NewsLocalService.class);

        _service = service;

        ReferenceRegistry.registerReference(NewsLocalServiceUtil.class,
            "_service");
        MethodCache.remove(NewsLocalService.class);
    }

    private static NewsLocalService _service;
}