/**
 * Copyright (c) 2011 Dutchworks All rights reserved.
 */

package org.searchworkings.news.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link News}.
 * </p>
 *
 * @author    Dutchworks
 * @see       News
 * @generated
 */
public class NewsWrapper implements News, ModelWrapper<News> {
    public NewsWrapper(News news) {
        _news = news;
    }

    public Class<?> getModelClass() {
        return News.class;
    }

    public String getModelClassName() {
        return News.class.getName();
    }

    /**
    * Returns the primary key of this news.
    *
    * @return the primary key of this news
    */
    public long getPrimaryKey() {
        return _news.getPrimaryKey();
    }

    /**
    * Sets the primary key of this news.
    *
    * @param primaryKey the primary key of this news
    */
    public void setPrimaryKey(long primaryKey) {
        _news.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the uuid of this news.
    *
    * @return the uuid of this news
    */
    public java.lang.String getUuid() {
        return _news.getUuid();
    }

    /**
    * Sets the uuid of this news.
    *
    * @param uuid the uuid of this news
    */
    public void setUuid(java.lang.String uuid) {
        _news.setUuid(uuid);
    }

    /**
    * Returns the news ID of this news.
    *
    * @return the news ID of this news
    */
    public long getNewsId() {
        return _news.getNewsId();
    }

    /**
    * Sets the news ID of this news.
    *
    * @param newsId the news ID of this news
    */
    public void setNewsId(long newsId) {
        _news.setNewsId(newsId);
    }

    /**
    * Returns the group ID of this news.
    *
    * @return the group ID of this news
    */
    public long getGroupId() {
        return _news.getGroupId();
    }

    /**
    * Sets the group ID of this news.
    *
    * @param groupId the group ID of this news
    */
    public void setGroupId(long groupId) {
        _news.setGroupId(groupId);
    }

    /**
    * Returns the company ID of this news.
    *
    * @return the company ID of this news
    */
    public long getCompanyId() {
        return _news.getCompanyId();
    }

    /**
    * Sets the company ID of this news.
    *
    * @param companyId the company ID of this news
    */
    public void setCompanyId(long companyId) {
        _news.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this news.
    *
    * @return the user ID of this news
    */
    public long getUserId() {
        return _news.getUserId();
    }

    /**
    * Sets the user ID of this news.
    *
    * @param userId the user ID of this news
    */
    public void setUserId(long userId) {
        _news.setUserId(userId);
    }

    /**
    * Returns the user uuid of this news.
    *
    * @return the user uuid of this news
    * @throws SystemException if a system exception occurred
    */
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _news.getUserUuid();
    }

    /**
    * Sets the user uuid of this news.
    *
    * @param userUuid the user uuid of this news
    */
    public void setUserUuid(java.lang.String userUuid) {
        _news.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this news.
    *
    * @return the user name of this news
    */
    public java.lang.String getUserName() {
        return _news.getUserName();
    }

    /**
    * Sets the user name of this news.
    *
    * @param userName the user name of this news
    */
    public void setUserName(java.lang.String userName) {
        _news.setUserName(userName);
    }

    /**
    * Returns the create date of this news.
    *
    * @return the create date of this news
    */
    public java.util.Date getCreateDate() {
        return _news.getCreateDate();
    }

    /**
    * Sets the create date of this news.
    *
    * @param createDate the create date of this news
    */
    public void setCreateDate(java.util.Date createDate) {
        _news.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this news.
    *
    * @return the modified date of this news
    */
    public java.util.Date getModifiedDate() {
        return _news.getModifiedDate();
    }

    /**
    * Sets the modified date of this news.
    *
    * @param modifiedDate the modified date of this news
    */
    public void setModifiedDate(java.util.Date modifiedDate) {
        _news.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the status of this news.
    *
    * @return the status of this news
    */
    public int getStatus() {
        return _news.getStatus();
    }

    /**
    * Sets the status of this news.
    *
    * @param status the status of this news
    */
    public void setStatus(int status) {
        _news.setStatus(status);
    }

    /**
    * Returns the status by user ID of this news.
    *
    * @return the status by user ID of this news
    */
    public long getStatusByUserId() {
        return _news.getStatusByUserId();
    }

    /**
    * Sets the status by user ID of this news.
    *
    * @param statusByUserId the status by user ID of this news
    */
    public void setStatusByUserId(long statusByUserId) {
        _news.setStatusByUserId(statusByUserId);
    }

    /**
    * Returns the status by user uuid of this news.
    *
    * @return the status by user uuid of this news
    * @throws SystemException if a system exception occurred
    */
    public java.lang.String getStatusByUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _news.getStatusByUserUuid();
    }

    /**
    * Sets the status by user uuid of this news.
    *
    * @param statusByUserUuid the status by user uuid of this news
    */
    public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
        _news.setStatusByUserUuid(statusByUserUuid);
    }

    /**
    * Returns the status by user name of this news.
    *
    * @return the status by user name of this news
    */
    public java.lang.String getStatusByUserName() {
        return _news.getStatusByUserName();
    }

    /**
    * Sets the status by user name of this news.
    *
    * @param statusByUserName the status by user name of this news
    */
    public void setStatusByUserName(java.lang.String statusByUserName) {
        _news.setStatusByUserName(statusByUserName);
    }

    /**
    * Returns the status date of this news.
    *
    * @return the status date of this news
    */
    public java.util.Date getStatusDate() {
        return _news.getStatusDate();
    }

    /**
    * Sets the status date of this news.
    *
    * @param statusDate the status date of this news
    */
    public void setStatusDate(java.util.Date statusDate) {
        _news.setStatusDate(statusDate);
    }

    /**
    * Returns the title of this news.
    *
    * @return the title of this news
    */
    public java.lang.String getTitle() {
        return _news.getTitle();
    }

    /**
    * Sets the title of this news.
    *
    * @param title the title of this news
    */
    public void setTitle(java.lang.String title) {
        _news.setTitle(title);
    }

    /**
    * Returns the content of this news.
    *
    * @return the content of this news
    */
    public java.lang.String getContent() {
        return _news.getContent();
    }

    /**
    * Sets the content of this news.
    *
    * @param content the content of this news
    */
    public void setContent(java.lang.String content) {
        _news.setContent(content);
    }

    /**
    * Returns the description of this news.
    *
    * @return the description of this news
    */
    public java.lang.String getDescription() {
        return _news.getDescription();
    }

    /**
    * Sets the description of this news.
    *
    * @param description the description of this news
    */
    public void setDescription(java.lang.String description) {
        _news.setDescription(description);
    }

    /**
    * Returns the display date of this news.
    *
    * @return the display date of this news
    */
    public java.util.Date getDisplayDate() {
        return _news.getDisplayDate();
    }

    /**
    * Sets the display date of this news.
    *
    * @param displayDate the display date of this news
    */
    public void setDisplayDate(java.util.Date displayDate) {
        _news.setDisplayDate(displayDate);
    }

    /**
    * @deprecated Renamed to {@link #isApproved()}
    */
    public boolean getApproved() {
        return _news.getApproved();
    }

    /**
    * Returns <code>true</code> if this news is approved.
    *
    * @return <code>true</code> if this news is approved; <code>false</code> otherwise
    */
    public boolean isApproved() {
        return _news.isApproved();
    }

    /**
    * Returns <code>true</code> if this news is a draft.
    *
    * @return <code>true</code> if this news is a draft; <code>false</code> otherwise
    */
    public boolean isDraft() {
        return _news.isDraft();
    }

    /**
    * Returns <code>true</code> if this news is expired.
    *
    * @return <code>true</code> if this news is expired; <code>false</code> otherwise
    */
    public boolean isExpired() {
        return _news.isExpired();
    }

    /**
    * Returns <code>true</code> if this news is pending.
    *
    * @return <code>true</code> if this news is pending; <code>false</code> otherwise
    */
    public boolean isPending() {
        return _news.isPending();
    }

    public boolean isNew() {
        return _news.isNew();
    }

    public void setNew(boolean n) {
        _news.setNew(n);
    }

    public boolean isCachedModel() {
        return _news.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _news.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _news.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _news.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _news.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _news.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _news.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new NewsWrapper((News)_news.clone());
    }

    public int compareTo(News news) {
        return _news.compareTo(news);
    }

    @Override
    public int hashCode() {
        return _news.hashCode();
    }

    public com.liferay.portal.model.CacheModel<News> toCacheModel() {
        return _news.toCacheModel();
    }

    public News toEscapedModel() {
        return new NewsWrapper(_news.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _news.toString();
    }

    public java.lang.String toXmlString() {
        return _news.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _news.persist();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedModel}
     */
    public News getWrappedNews() {
        return _news;
    }

    public News getWrappedModel() {
        return _news;
    }

    public void resetOriginalValues() {
        _news.resetOriginalValues();
    }

    private News _news;
}