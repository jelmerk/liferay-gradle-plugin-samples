/**
 * Copyright (c) 2011 Dutchworks All rights reserved.
 */

package org.searchworkings.news.service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import org.searchworkings.news.model.NewsClp;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
    public static String getServletContextName() {
        if (Validator.isNotNull(_servletContextName)) {
            return _servletContextName;
        }

        synchronized (ClpSerializer.class) {
            if (Validator.isNotNull(_servletContextName)) {
                return _servletContextName;
            }

            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Class<?> portletPropsClass = classLoader.loadClass(
                        "com.liferay.util.portlet.PortletProps");

                Method getMethod = portletPropsClass.getMethod("get",
                        new Class<?>[] { String.class });

                String portletPropsServletContextName = (String)getMethod.invoke(null,
                        "news-portlet-deployment-context");

                if (Validator.isNotNull(portletPropsServletContextName)) {
                    _servletContextName = portletPropsServletContextName;
                }
            }
            catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info(
                        "Unable to locate deployment context from portlet properties");
                }
            }

            if (Validator.isNull(_servletContextName)) {
                try {
                    String propsUtilServletContextName = PropsUtil.get(
                            "news-portlet-deployment-context");

                    if (Validator.isNotNull(propsUtilServletContextName)) {
                        _servletContextName = propsUtilServletContextName;
                    }
                }
                catch (Throwable t) {
                    if (_log.isInfoEnabled()) {
                        _log.info(
                            "Unable to locate deployment context from portal properties");
                    }
                }
            }

            if (Validator.isNull(_servletContextName)) {
                _servletContextName = "news-portlet";
            }

            return _servletContextName;
        }
    }

    public static void setClassLoader(ClassLoader classLoader) {
        _classLoader = classLoader;
    }

    public static Object translateInput(BaseModel<?> oldModel) {
        Class<?> oldModelClass = oldModel.getClass();

        String oldModelClassName = oldModelClass.getName();

        if (oldModelClassName.equals(NewsClp.class.getName())) {
            return translateInputNews(oldModel);
        }

        return oldModel;
    }

    public static Object translateInput(List<Object> oldList) {
        List<Object> newList = new ArrayList<Object>(oldList.size());

        for (int i = 0; i < oldList.size(); i++) {
            Object curObj = oldList.get(i);

            newList.add(translateInput(curObj));
        }

        return newList;
    }

    public static Object translateInputNews(BaseModel<?> oldModel) {
        NewsClp oldCplModel = (NewsClp)oldModel;

        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        try {
            currentThread.setContextClassLoader(_classLoader);

            try {
                Class<?> newModelClass = Class.forName("org.searchworkings.news.model.impl.NewsImpl",
                        true, _classLoader);

                Object newModel = newModelClass.newInstance();

                Method method0 = newModelClass.getMethod("setUuid",
                        new Class[] { String.class });

                String value0 = oldCplModel.getUuid();

                method0.invoke(newModel, value0);

                Method method1 = newModelClass.getMethod("setNewsId",
                        new Class[] { Long.TYPE });

                Long value1 = new Long(oldCplModel.getNewsId());

                method1.invoke(newModel, value1);

                Method method2 = newModelClass.getMethod("setGroupId",
                        new Class[] { Long.TYPE });

                Long value2 = new Long(oldCplModel.getGroupId());

                method2.invoke(newModel, value2);

                Method method3 = newModelClass.getMethod("setCompanyId",
                        new Class[] { Long.TYPE });

                Long value3 = new Long(oldCplModel.getCompanyId());

                method3.invoke(newModel, value3);

                Method method4 = newModelClass.getMethod("setUserId",
                        new Class[] { Long.TYPE });

                Long value4 = new Long(oldCplModel.getUserId());

                method4.invoke(newModel, value4);

                Method method5 = newModelClass.getMethod("setUserName",
                        new Class[] { String.class });

                String value5 = oldCplModel.getUserName();

                method5.invoke(newModel, value5);

                Method method6 = newModelClass.getMethod("setCreateDate",
                        new Class[] { Date.class });

                Date value6 = oldCplModel.getCreateDate();

                method6.invoke(newModel, value6);

                Method method7 = newModelClass.getMethod("setModifiedDate",
                        new Class[] { Date.class });

                Date value7 = oldCplModel.getModifiedDate();

                method7.invoke(newModel, value7);

                Method method8 = newModelClass.getMethod("setStatus",
                        new Class[] { Integer.TYPE });

                Integer value8 = new Integer(oldCplModel.getStatus());

                method8.invoke(newModel, value8);

                Method method9 = newModelClass.getMethod("setStatusByUserId",
                        new Class[] { Long.TYPE });

                Long value9 = new Long(oldCplModel.getStatusByUserId());

                method9.invoke(newModel, value9);

                Method method10 = newModelClass.getMethod("setStatusByUserName",
                        new Class[] { String.class });

                String value10 = oldCplModel.getStatusByUserName();

                method10.invoke(newModel, value10);

                Method method11 = newModelClass.getMethod("setStatusDate",
                        new Class[] { Date.class });

                Date value11 = oldCplModel.getStatusDate();

                method11.invoke(newModel, value11);

                Method method12 = newModelClass.getMethod("setTitle",
                        new Class[] { String.class });

                String value12 = oldCplModel.getTitle();

                method12.invoke(newModel, value12);

                Method method13 = newModelClass.getMethod("setContent",
                        new Class[] { String.class });

                String value13 = oldCplModel.getContent();

                method13.invoke(newModel, value13);

                Method method14 = newModelClass.getMethod("setDescription",
                        new Class[] { String.class });

                String value14 = oldCplModel.getDescription();

                method14.invoke(newModel, value14);

                Method method15 = newModelClass.getMethod("setDisplayDate",
                        new Class[] { Date.class });

                Date value15 = oldCplModel.getDisplayDate();

                method15.invoke(newModel, value15);

                return newModel;
            }
            catch (Exception e) {
                _log.error(e, e);
            }
        }
        finally {
            currentThread.setContextClassLoader(contextClassLoader);
        }

        return oldModel;
    }

    public static Object translateInput(Object obj) {
        if (obj instanceof BaseModel<?>) {
            return translateInput((BaseModel<?>)obj);
        }
        else if (obj instanceof List<?>) {
            return translateInput((List<Object>)obj);
        }
        else {
            return obj;
        }
    }

    public static Object translateOutput(BaseModel<?> oldModel) {
        Class<?> oldModelClass = oldModel.getClass();

        String oldModelClassName = oldModelClass.getName();

        if (oldModelClassName.equals(
                    "org.searchworkings.news.model.impl.NewsImpl")) {
            return translateOutputNews(oldModel);
        }

        return oldModel;
    }

    public static Object translateOutput(List<Object> oldList) {
        List<Object> newList = new ArrayList<Object>(oldList.size());

        for (int i = 0; i < oldList.size(); i++) {
            Object curObj = oldList.get(i);

            newList.add(translateOutput(curObj));
        }

        return newList;
    }

    public static Object translateOutput(Object obj) {
        if (obj instanceof BaseModel<?>) {
            return translateOutput((BaseModel<?>)obj);
        }
        else if (obj instanceof List<?>) {
            return translateOutput((List<Object>)obj);
        }
        else {
            return obj;
        }
    }

    public static Object translateOutputNews(BaseModel<?> oldModel) {
        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        try {
            currentThread.setContextClassLoader(_classLoader);

            try {
                NewsClp newModel = new NewsClp();

                Class<?> oldModelClass = oldModel.getClass();

                Method method0 = oldModelClass.getMethod("getUuid");

                String value0 = (String)method0.invoke(oldModel, (Object[])null);

                newModel.setUuid(value0);

                Method method1 = oldModelClass.getMethod("getNewsId");

                Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

                newModel.setNewsId(value1);

                Method method2 = oldModelClass.getMethod("getGroupId");

                Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

                newModel.setGroupId(value2);

                Method method3 = oldModelClass.getMethod("getCompanyId");

                Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

                newModel.setCompanyId(value3);

                Method method4 = oldModelClass.getMethod("getUserId");

                Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

                newModel.setUserId(value4);

                Method method5 = oldModelClass.getMethod("getUserName");

                String value5 = (String)method5.invoke(oldModel, (Object[])null);

                newModel.setUserName(value5);

                Method method6 = oldModelClass.getMethod("getCreateDate");

                Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

                newModel.setCreateDate(value6);

                Method method7 = oldModelClass.getMethod("getModifiedDate");

                Date value7 = (Date)method7.invoke(oldModel, (Object[])null);

                newModel.setModifiedDate(value7);

                Method method8 = oldModelClass.getMethod("getStatus");

                Integer value8 = (Integer)method8.invoke(oldModel,
                        (Object[])null);

                newModel.setStatus(value8);

                Method method9 = oldModelClass.getMethod("getStatusByUserId");

                Long value9 = (Long)method9.invoke(oldModel, (Object[])null);

                newModel.setStatusByUserId(value9);

                Method method10 = oldModelClass.getMethod("getStatusByUserName");

                String value10 = (String)method10.invoke(oldModel,
                        (Object[])null);

                newModel.setStatusByUserName(value10);

                Method method11 = oldModelClass.getMethod("getStatusDate");

                Date value11 = (Date)method11.invoke(oldModel, (Object[])null);

                newModel.setStatusDate(value11);

                Method method12 = oldModelClass.getMethod("getTitle");

                String value12 = (String)method12.invoke(oldModel,
                        (Object[])null);

                newModel.setTitle(value12);

                Method method13 = oldModelClass.getMethod("getContent");

                String value13 = (String)method13.invoke(oldModel,
                        (Object[])null);

                newModel.setContent(value13);

                Method method14 = oldModelClass.getMethod("getDescription");

                String value14 = (String)method14.invoke(oldModel,
                        (Object[])null);

                newModel.setDescription(value14);

                Method method15 = oldModelClass.getMethod("getDisplayDate");

                Date value15 = (Date)method15.invoke(oldModel, (Object[])null);

                newModel.setDisplayDate(value15);

                return newModel;
            }
            catch (Exception e) {
                _log.error(e, e);
            }
        }
        finally {
            currentThread.setContextClassLoader(contextClassLoader);
        }

        return oldModel;
    }

    private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
    private static ClassLoader _classLoader;
    private static String _servletContextName;
}