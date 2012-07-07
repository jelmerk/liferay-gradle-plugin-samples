/**
 * Copyright (c) 2011 Dutchworks All rights reserved.
 */

package org.searchworkings.news.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.searchworkings.news.model.News;

import java.util.List;

/**
 * The persistence utility for the news service. This utility wraps {@link NewsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Dutchworks
 * @see NewsPersistence
 * @see NewsPersistenceImpl
 * @generated
 */
public class NewsUtil {
    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(News news) {
        getPersistence().clearCache(news);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<News> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<News> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<News> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static News update(News news, boolean merge)
        throws SystemException {
        return getPersistence().update(news, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static News update(News news, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(news, merge, serviceContext);
    }

    /**
    * Caches the news in the entity cache if it is enabled.
    *
    * @param news the news
    */
    public static void cacheResult(org.searchworkings.news.model.News news) {
        getPersistence().cacheResult(news);
    }

    /**
    * Caches the newses in the entity cache if it is enabled.
    *
    * @param newses the newses
    */
    public static void cacheResult(
        java.util.List<org.searchworkings.news.model.News> newses) {
        getPersistence().cacheResult(newses);
    }

    /**
    * Creates a new news with the primary key. Does not add the news to the database.
    *
    * @param newsId the primary key for the new news
    * @return the new news
    */
    public static org.searchworkings.news.model.News create(long newsId) {
        return getPersistence().create(newsId);
    }

    /**
    * Removes the news with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param newsId the primary key of the news
    * @return the news that was removed
    * @throws org.searchworkings.news.NoSuchNewsException if a news with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static org.searchworkings.news.model.News remove(long newsId)
        throws com.liferay.portal.kernel.exception.SystemException,
            org.searchworkings.news.NoSuchNewsException {
        return getPersistence().remove(newsId);
    }

    public static org.searchworkings.news.model.News updateImpl(
        org.searchworkings.news.model.News news, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(news, merge);
    }

    /**
    * Returns the news with the primary key or throws a {@link org.searchworkings.news.NoSuchNewsException} if it could not be found.
    *
    * @param newsId the primary key of the news
    * @return the news
    * @throws org.searchworkings.news.NoSuchNewsException if a news with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static org.searchworkings.news.model.News findByPrimaryKey(
        long newsId)
        throws com.liferay.portal.kernel.exception.SystemException,
            org.searchworkings.news.NoSuchNewsException {
        return getPersistence().findByPrimaryKey(newsId);
    }

    /**
    * Returns the news with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param newsId the primary key of the news
    * @return the news, or <code>null</code> if a news with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static org.searchworkings.news.model.News fetchByPrimaryKey(
        long newsId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(newsId);
    }

    /**
    * Returns all the newses where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching newses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<org.searchworkings.news.model.News> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid);
    }

    /**
    * Returns a range of all the newses where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of newses
    * @param end the upper bound of the range of newses (not inclusive)
    * @return the range of matching newses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<org.searchworkings.news.model.News> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end);
    }

    /**
    * Returns an ordered range of all the newses where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of newses
    * @param end the upper bound of the range of newses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching newses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<org.searchworkings.news.model.News> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end, orderByComparator);
    }

    /**
    * Returns the first news in the ordered set where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching news
    * @throws org.searchworkings.news.NoSuchNewsException if a matching news could not be found
    * @throws SystemException if a system exception occurred
    */
    public static org.searchworkings.news.model.News findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            org.searchworkings.news.NoSuchNewsException {
        return getPersistence().findByUuid_First(uuid, orderByComparator);
    }

    /**
    * Returns the last news in the ordered set where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching news
    * @throws org.searchworkings.news.NoSuchNewsException if a matching news could not be found
    * @throws SystemException if a system exception occurred
    */
    public static org.searchworkings.news.model.News findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            org.searchworkings.news.NoSuchNewsException {
        return getPersistence().findByUuid_Last(uuid, orderByComparator);
    }

    /**
    * Returns the newses before and after the current news in the ordered set where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param newsId the primary key of the current news
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next news
    * @throws org.searchworkings.news.NoSuchNewsException if a news with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static org.searchworkings.news.model.News[] findByUuid_PrevAndNext(
        long newsId, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            org.searchworkings.news.NoSuchNewsException {
        return getPersistence()
                   .findByUuid_PrevAndNext(newsId, uuid, orderByComparator);
    }

    /**
    * Returns the news where uuid = &#63; and groupId = &#63; or throws a {@link org.searchworkings.news.NoSuchNewsException} if it could not be found.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching news
    * @throws org.searchworkings.news.NoSuchNewsException if a matching news could not be found
    * @throws SystemException if a system exception occurred
    */
    public static org.searchworkings.news.model.News findByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            org.searchworkings.news.NoSuchNewsException {
        return getPersistence().findByUUID_G(uuid, groupId);
    }

    /**
    * Returns the news where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching news, or <code>null</code> if a matching news could not be found
    * @throws SystemException if a system exception occurred
    */
    public static org.searchworkings.news.model.News fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId);
    }

    /**
    * Returns the news where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching news, or <code>null</code> if a matching news could not be found
    * @throws SystemException if a system exception occurred
    */
    public static org.searchworkings.news.model.News fetchByUUID_G(
        java.lang.String uuid, long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
    }

    /**
    * Returns all the newses where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the matching newses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<org.searchworkings.news.model.News> findByCompanyId(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCompanyId(companyId);
    }

    /**
    * Returns a range of all the newses where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of newses
    * @param end the upper bound of the range of newses (not inclusive)
    * @return the range of matching newses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<org.searchworkings.news.model.News> findByCompanyId(
        long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCompanyId(companyId, start, end);
    }

    /**
    * Returns an ordered range of all the newses where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param companyId the company ID
    * @param start the lower bound of the range of newses
    * @param end the upper bound of the range of newses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching newses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<org.searchworkings.news.model.News> findByCompanyId(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCompanyId(companyId, start, end, orderByComparator);
    }

    /**
    * Returns the first news in the ordered set where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching news
    * @throws org.searchworkings.news.NoSuchNewsException if a matching news could not be found
    * @throws SystemException if a system exception occurred
    */
    public static org.searchworkings.news.model.News findByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            org.searchworkings.news.NoSuchNewsException {
        return getPersistence()
                   .findByCompanyId_First(companyId, orderByComparator);
    }

    /**
    * Returns the last news in the ordered set where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching news
    * @throws org.searchworkings.news.NoSuchNewsException if a matching news could not be found
    * @throws SystemException if a system exception occurred
    */
    public static org.searchworkings.news.model.News findByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            org.searchworkings.news.NoSuchNewsException {
        return getPersistence()
                   .findByCompanyId_Last(companyId, orderByComparator);
    }

    /**
    * Returns the newses before and after the current news in the ordered set where companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param newsId the primary key of the current news
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next news
    * @throws org.searchworkings.news.NoSuchNewsException if a news with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static org.searchworkings.news.model.News[] findByCompanyId_PrevAndNext(
        long newsId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            org.searchworkings.news.NoSuchNewsException {
        return getPersistence()
                   .findByCompanyId_PrevAndNext(newsId, companyId,
            orderByComparator);
    }

    /**
    * Returns all the newses where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching newses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<org.searchworkings.news.model.News> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId(groupId);
    }

    /**
    * Returns a range of all the newses where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of newses
    * @param end the upper bound of the range of newses (not inclusive)
    * @return the range of matching newses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<org.searchworkings.news.model.News> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGroupId(groupId, start, end);
    }

    /**
    * Returns an ordered range of all the newses where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param groupId the group ID
    * @param start the lower bound of the range of newses
    * @param end the upper bound of the range of newses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching newses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<org.searchworkings.news.model.News> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByGroupId(groupId, start, end, orderByComparator);
    }

    /**
    * Returns the first news in the ordered set where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching news
    * @throws org.searchworkings.news.NoSuchNewsException if a matching news could not be found
    * @throws SystemException if a system exception occurred
    */
    public static org.searchworkings.news.model.News findByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            org.searchworkings.news.NoSuchNewsException {
        return getPersistence().findByGroupId_First(groupId, orderByComparator);
    }

    /**
    * Returns the last news in the ordered set where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching news
    * @throws org.searchworkings.news.NoSuchNewsException if a matching news could not be found
    * @throws SystemException if a system exception occurred
    */
    public static org.searchworkings.news.model.News findByGroupId_Last(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            org.searchworkings.news.NoSuchNewsException {
        return getPersistence().findByGroupId_Last(groupId, orderByComparator);
    }

    /**
    * Returns the newses before and after the current news in the ordered set where groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param newsId the primary key of the current news
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next news
    * @throws org.searchworkings.news.NoSuchNewsException if a news with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static org.searchworkings.news.model.News[] findByGroupId_PrevAndNext(
        long newsId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            org.searchworkings.news.NoSuchNewsException {
        return getPersistence()
                   .findByGroupId_PrevAndNext(newsId, groupId, orderByComparator);
    }

    /**
    * Returns all the newses.
    *
    * @return the newses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<org.searchworkings.news.model.News> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<org.searchworkings.news.model.News> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the newses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of newses
    * @param end the upper bound of the range of newses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of newses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<org.searchworkings.news.model.News> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the newses where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUuid(uuid);
    }

    /**
    * Removes the news where uuid = &#63; and groupId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            org.searchworkings.news.NoSuchNewsException {
        getPersistence().removeByUUID_G(uuid, groupId);
    }

    /**
    * Removes all the newses where companyId = &#63; from the database.
    *
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByCompanyId(companyId);
    }

    /**
    * Removes all the newses where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByGroupId(groupId);
    }

    /**
    * Removes all the newses from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of newses where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching newses
    * @throws SystemException if a system exception occurred
    */
    public static int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUuid(uuid);
    }

    /**
    * Returns the number of newses where uuid = &#63; and groupId = &#63;.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the number of matching newses
    * @throws SystemException if a system exception occurred
    */
    public static int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUUID_G(uuid, groupId);
    }

    /**
    * Returns the number of newses where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the number of matching newses
    * @throws SystemException if a system exception occurred
    */
    public static int countByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByCompanyId(companyId);
    }

    /**
    * Returns the number of newses where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching newses
    * @throws SystemException if a system exception occurred
    */
    public static int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByGroupId(groupId);
    }

    /**
    * Returns the number of newses.
    *
    * @return the number of newses
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static NewsPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (NewsPersistence)PortletBeanLocatorUtil.locate(org.searchworkings.news.service.ClpSerializer.getServletContextName(),
                    NewsPersistence.class.getName());

            ReferenceRegistry.registerReference(NewsUtil.class, "_persistence");
        }

        return _persistence;
    }

    public void setPersistence(NewsPersistence persistence) {
        _persistence = persistence;

        ReferenceRegistry.registerReference(NewsUtil.class, "_persistence");
    }

    private static NewsPersistence _persistence;
}