/**
 * Copyright (c) 2011 Dutchworks All rights reserved.
 */

package org.searchworkings.news.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link NewsLocalService}.
 * </p>
 *
 * @author    Dutchworks
 * @see       NewsLocalService
 * @generated
 */
public class NewsLocalServiceWrapper implements NewsLocalService,
    ServiceWrapper<NewsLocalService> {
    public NewsLocalServiceWrapper(NewsLocalService newsLocalService) {
        _newsLocalService = newsLocalService;
    }

    /**
    * Adds the news to the database. Also notifies the appropriate model listeners.
    *
    * @param news the news
    * @return the news that was added
    * @throws SystemException if a system exception occurred
    */
    public org.searchworkings.news.model.News addNews(
        org.searchworkings.news.model.News news)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _newsLocalService.addNews(news);
    }

    /**
    * Creates a new news with the primary key. Does not add the news to the database.
    *
    * @param newsId the primary key for the new news
    * @return the new news
    */
    public org.searchworkings.news.model.News createNews(long newsId) {
        return _newsLocalService.createNews(newsId);
    }

    /**
    * Deletes the news with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param newsId the primary key of the news
    * @throws PortalException if a news with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public void deleteNews(long newsId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _newsLocalService.deleteNews(newsId);
    }

    /**
    * Deletes the news from the database. Also notifies the appropriate model listeners.
    *
    * @param news the news
    * @throws SystemException if a system exception occurred
    */
    public void deleteNews(org.searchworkings.news.model.News news)
        throws com.liferay.portal.kernel.exception.SystemException {
        _newsLocalService.deleteNews(news);
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _newsLocalService.dynamicQuery(dynamicQuery);
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
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _newsLocalService.dynamicQuery(dynamicQuery, start, end);
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
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _newsLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _newsLocalService.dynamicQueryCount(dynamicQuery);
    }

    public org.searchworkings.news.model.News fetchNews(long newsId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _newsLocalService.fetchNews(newsId);
    }

    /**
    * Returns the news with the primary key.
    *
    * @param newsId the primary key of the news
    * @return the news
    * @throws PortalException if a news with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public org.searchworkings.news.model.News getNews(long newsId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _newsLocalService.getNews(newsId);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _newsLocalService.getPersistedModel(primaryKeyObj);
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
    public org.searchworkings.news.model.News getNewsByUuidAndGroupId(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _newsLocalService.getNewsByUuidAndGroupId(uuid, groupId);
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
    public java.util.List<org.searchworkings.news.model.News> getNewses(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _newsLocalService.getNewses(start, end);
    }

    /**
    * Returns the number of newses.
    *
    * @return the number of newses
    * @throws SystemException if a system exception occurred
    */
    public int getNewsesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _newsLocalService.getNewsesCount();
    }

    /**
    * Updates the news in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param news the news
    * @return the news that was updated
    * @throws SystemException if a system exception occurred
    */
    public org.searchworkings.news.model.News updateNews(
        org.searchworkings.news.model.News news)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _newsLocalService.updateNews(news);
    }

    /**
    * Updates the news in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param news the news
    * @param merge whether to merge the news with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the news that was updated
    * @throws SystemException if a system exception occurred
    */
    public org.searchworkings.news.model.News updateNews(
        org.searchworkings.news.model.News news, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _newsLocalService.updateNews(news, merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _newsLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _newsLocalService.setBeanIdentifier(beanIdentifier);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public NewsLocalService getWrappedNewsLocalService() {
        return _newsLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedNewsLocalService(NewsLocalService newsLocalService) {
        _newsLocalService = newsLocalService;
    }

    public NewsLocalService getWrappedService() {
        return _newsLocalService;
    }

    public void setWrappedService(NewsLocalService newsLocalService) {
        _newsLocalService = newsLocalService;
    }

    private NewsLocalService _newsLocalService;
}