/**
 * Copyright (c) 2011 Dutchworks All rights reserved.
 */

package org.searchworkings.news.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import org.searchworkings.news.model.News;

/**
 * The persistence interface for the news service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Dutchworks
 * @see NewsPersistenceImpl
 * @see NewsUtil
 * @generated
 */
public interface NewsPersistence extends BasePersistence<News> {
    /**
    * Caches the news in the entity cache if it is enabled.
    *
    * @param news the news
    */
    public void cacheResult(org.searchworkings.news.model.News news);

    /**
    * Caches the newses in the entity cache if it is enabled.
    *
    * @param newses the newses
    */
    public void cacheResult(
        java.util.List<org.searchworkings.news.model.News> newses);

    /**
    * Creates a new news with the primary key. Does not add the news to the database.
    *
    * @param newsId the primary key for the new news
    * @return the new news
    */
    public org.searchworkings.news.model.News create(long newsId);

    /**
    * Removes the news with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param newsId the primary key of the news
    * @return the news that was removed
    * @throws org.searchworkings.news.NoSuchNewsException if a news with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public org.searchworkings.news.model.News remove(long newsId)
        throws com.liferay.portal.kernel.exception.SystemException,
            org.searchworkings.news.NoSuchNewsException;

    public org.searchworkings.news.model.News updateImpl(
        org.searchworkings.news.model.News news, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the news with the primary key or throws a {@link org.searchworkings.news.NoSuchNewsException} if it could not be found.
    *
    * @param newsId the primary key of the news
    * @return the news
    * @throws org.searchworkings.news.NoSuchNewsException if a news with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public org.searchworkings.news.model.News findByPrimaryKey(long newsId)
        throws com.liferay.portal.kernel.exception.SystemException,
            org.searchworkings.news.NoSuchNewsException;

    /**
    * Returns the news with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param newsId the primary key of the news
    * @return the news, or <code>null</code> if a news with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public org.searchworkings.news.model.News fetchByPrimaryKey(long newsId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the newses where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching newses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<org.searchworkings.news.model.News> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<org.searchworkings.news.model.News> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<org.searchworkings.news.model.News> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public org.searchworkings.news.model.News findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            org.searchworkings.news.NoSuchNewsException;

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
    public org.searchworkings.news.model.News findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            org.searchworkings.news.NoSuchNewsException;

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
    public org.searchworkings.news.model.News[] findByUuid_PrevAndNext(
        long newsId, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            org.searchworkings.news.NoSuchNewsException;

    /**
    * Returns the news where uuid = &#63; and groupId = &#63; or throws a {@link org.searchworkings.news.NoSuchNewsException} if it could not be found.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching news
    * @throws org.searchworkings.news.NoSuchNewsException if a matching news could not be found
    * @throws SystemException if a system exception occurred
    */
    public org.searchworkings.news.model.News findByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            org.searchworkings.news.NoSuchNewsException;

    /**
    * Returns the news where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching news, or <code>null</code> if a matching news could not be found
    * @throws SystemException if a system exception occurred
    */
    public org.searchworkings.news.model.News fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the news where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching news, or <code>null</code> if a matching news could not be found
    * @throws SystemException if a system exception occurred
    */
    public org.searchworkings.news.model.News fetchByUUID_G(
        java.lang.String uuid, long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the newses where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the matching newses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<org.searchworkings.news.model.News> findByCompanyId(
        long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<org.searchworkings.news.model.News> findByCompanyId(
        long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<org.searchworkings.news.model.News> findByCompanyId(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public org.searchworkings.news.model.News findByCompanyId_First(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            org.searchworkings.news.NoSuchNewsException;

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
    public org.searchworkings.news.model.News findByCompanyId_Last(
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            org.searchworkings.news.NoSuchNewsException;

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
    public org.searchworkings.news.model.News[] findByCompanyId_PrevAndNext(
        long newsId, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            org.searchworkings.news.NoSuchNewsException;

    /**
    * Returns all the newses where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the matching newses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<org.searchworkings.news.model.News> findByGroupId(
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<org.searchworkings.news.model.News> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<org.searchworkings.news.model.News> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public org.searchworkings.news.model.News findByGroupId_First(
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            org.searchworkings.news.NoSuchNewsException;

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
    public org.searchworkings.news.model.News findByGroupId_Last(long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            org.searchworkings.news.NoSuchNewsException;

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
    public org.searchworkings.news.model.News[] findByGroupId_PrevAndNext(
        long newsId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            org.searchworkings.news.NoSuchNewsException;

    /**
    * Returns all the newses.
    *
    * @return the newses
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<org.searchworkings.news.model.News> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<org.searchworkings.news.model.News> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<org.searchworkings.news.model.News> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the newses where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the news where uuid = &#63; and groupId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            org.searchworkings.news.NoSuchNewsException;

    /**
    * Removes all the newses where companyId = &#63; from the database.
    *
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the newses where groupId = &#63; from the database.
    *
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the newses from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of newses where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching newses
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of newses where uuid = &#63; and groupId = &#63;.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the number of matching newses
    * @throws SystemException if a system exception occurred
    */
    public int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of newses where companyId = &#63;.
    *
    * @param companyId the company ID
    * @return the number of matching newses
    * @throws SystemException if a system exception occurred
    */
    public int countByCompanyId(long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of newses where groupId = &#63;.
    *
    * @param groupId the group ID
    * @return the number of matching newses
    * @throws SystemException if a system exception occurred
    */
    public int countByGroupId(long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of newses.
    *
    * @return the number of newses
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}