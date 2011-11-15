/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.kernel.dao.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletURL;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Brian Wing Shun Chan
 */
public class ResultRow {

	public ResultRow(Object obj, long primaryKey, int pos) {
		this(obj, String.valueOf(primaryKey), pos);
	}

	public ResultRow(Object obj, long primaryKey, int pos, boolean bold) {
		this(obj, String.valueOf(primaryKey), pos, bold);
	}

	public ResultRow(Object obj, String primaryKey, int pos) {
		this(obj, primaryKey, pos, false);
	}

	public ResultRow(Object obj, String primaryKey, int pos, boolean bold) {
		_obj = obj;
		_primaryKey = primaryKey;
		_pos = pos;
		_bold = bold;
		_searchEntries = new ArrayList<SearchEntry>();
	}

	public void addButton(int index, String name, String href) {
		addButton(
			index, SearchEntry.DEFAULT_ALIGN, SearchEntry.DEFAULT_VALIGN,
			SearchEntry.DEFAULT_COLSPAN, name, href);
	}

	public void addButton(
		int index, String align, String valign, int colspan, String name,
		String href) {

		if (_restricted) {
			href = null;
		}

		ButtonSearchEntry buttonSearchEntry = new ButtonSearchEntry();

		buttonSearchEntry.setAlign(align);
		buttonSearchEntry.setColspan(colspan);
		buttonSearchEntry.setHref(href);
		buttonSearchEntry.setName(name);
		buttonSearchEntry.setValign(valign);

		_searchEntries.add(index, buttonSearchEntry);
	}

	public void addButton(String name, String href) {
		addButton(_searchEntries.size(), name, href);
	}

	public void addButton(
		String align, String valign, int colspan, String name, String href) {

		addButton(_searchEntries.size(), align, valign, colspan, name, href);
	}

	public void addButton(
		String align, String valign, String name, String href) {

		addButton(
			_searchEntries.size(), align, valign, SearchEntry.DEFAULT_COLSPAN,
			name, href);
	}

	public void addJSP(int index, String path) {
		addJSP(
			index, SearchEntry.DEFAULT_ALIGN, SearchEntry.DEFAULT_VALIGN,
			SearchEntry.DEFAULT_COLSPAN, path);
	}

	public void addJSP(
		int index, String path, ServletContext servletContext,
		HttpServletRequest request, HttpServletResponse response) {

		addJSP(
			index, SearchEntry.DEFAULT_ALIGN, SearchEntry.DEFAULT_VALIGN,
			SearchEntry.DEFAULT_COLSPAN, path, servletContext, request,
			response);
	}

	public void addJSP(
		int index, String align, String valign, int colspan, String path) {

		JSPSearchEntry jspSearchEntry = new JSPSearchEntry();

		jspSearchEntry.setAlign(align);
		jspSearchEntry.setColspan(colspan);
		jspSearchEntry.setPath(path);
		jspSearchEntry.setValign(valign);

		_searchEntries.add(index, jspSearchEntry);
	}

	public void addJSP(
		int index, String align, String valign, int colspan, String path,
		ServletContext servletContext, HttpServletRequest request,
		HttpServletResponse response) {

		JSPSearchEntry jspSearchEntry = new JSPSearchEntry();

		jspSearchEntry.setAlign(align);
		jspSearchEntry.setColspan(colspan);
		jspSearchEntry.setPath(path);
		jspSearchEntry.setRequest(request);
		jspSearchEntry.setResponse(response);
		jspSearchEntry.setServletContext(servletContext);
		jspSearchEntry.setValign(valign);

		_searchEntries.add(index, jspSearchEntry);
	}

	public void addJSP(String path) {
		addJSP(_searchEntries.size(), path);
	}

	public void addJSP(
		String path, ServletContext servletContext, HttpServletRequest request,
		HttpServletResponse response) {

		addJSP(_searchEntries.size(), path, servletContext, request, response);
	}

	public void addJSP(String align, String valign, int colspan, String path) {
		addJSP(_searchEntries.size(), align, valign, colspan, path);
	}

	public void addJSP(
		String align, String valign, int colspan, String path,
		ServletContext servletContext, HttpServletRequest request,
		HttpServletResponse response) {

		addJSP(
			_searchEntries.size(), align, valign, colspan, path, servletContext,
			request, response);
	}

	public void addJSP(String align, String valign, String path) {
		addJSP(
			_searchEntries.size(), align, valign, SearchEntry.DEFAULT_COLSPAN,
			path);
	}

	public void addJSP(
		String align, String valign, String path, ServletContext servletContext,
		HttpServletRequest request, HttpServletResponse response) {

		addJSP(
			_searchEntries.size(), align, valign, SearchEntry.DEFAULT_COLSPAN,
			path, servletContext, request, response);
	}

	public void addScore(float score) {
		addScore(_searchEntries.size(), score);
	}

	public void addScore(int index, float score) {
		ScoreSearchEntry scoreSearchEntry = new ScoreSearchEntry();

		scoreSearchEntry.setScore(score);

		_searchEntries.add(index, scoreSearchEntry);
	}

	public void addSearchEntry(int index, SearchEntry searchEntry) {
		_searchEntries.add(index, searchEntry);
	}

	public void addSearchEntry(SearchEntry searchEntry) {
		_searchEntries.add(searchEntry);
	}

	public void addText(int index, String name) {
		addText(
			index, SearchEntry.DEFAULT_ALIGN, SearchEntry.DEFAULT_VALIGN,
			SearchEntry.DEFAULT_COLSPAN, name);
	}

	public void addText(int index, String name, PortletURL portletURL) {
		if (portletURL == null) {
			addText(index, name);
		}
		else {
			addText(index, name, portletURL.toString());
		}
	}

	public void addText(int index, String name, String href) {
		addText(
			index, SearchEntry.DEFAULT_ALIGN, SearchEntry.DEFAULT_VALIGN,
			SearchEntry.DEFAULT_COLSPAN, name, href);
	}

	public void addText(
		int index, String align, String valign, int colspan, String name) {

		TextSearchEntry textSearchEntry = new TextSearchEntry();

		textSearchEntry.setAlign(align);
		textSearchEntry.setColspan(colspan);
		textSearchEntry.setName(name);
		textSearchEntry.setValign(valign);

		_searchEntries.add(index, textSearchEntry);
	}

	public void addText(
		int index, String align, String valign, int colspan, String name,
		PortletURL portletURL) {

		if (portletURL == null) {
			addText(index, align, valign, colspan, name);
		}
		else {
			addText(index, align, valign, colspan, name, portletURL.toString());
		}
	}

	public void addText(
		int index, String align, String valign, int colspan, String name,
		String href) {

		if (_restricted) {
			href = null;
		}

		TextSearchEntry textSearchEntry = new TextSearchEntry();

		textSearchEntry.setAlign(align);
		textSearchEntry.setColspan(colspan);
		textSearchEntry.setHref(href);
		textSearchEntry.setName(name);
		textSearchEntry.setValign(valign);

		_searchEntries.add(index, textSearchEntry);
	}

	public void addText(int index, TextSearchEntry searchEntry) {
		if (_restricted) {
			searchEntry.setHref(null);
		}

		_searchEntries.add(index, searchEntry);
	}

	public void addText(String name) {
		addText(_searchEntries.size(), name);
	}

	public void addText(String name, PortletURL portletURL) {
		if (portletURL == null) {
			addText(name);
		}
		else {
			addText(name, portletURL.toString());
		}
	}

	public void addText(String name, String href) {
		addText(_searchEntries.size(), name, href);
	}

	public void addText(
		String align, String valign, int colspan, String name) {

		addText(_searchEntries.size(), align, valign, colspan, name);
	}

	public void addText(
		String align, String valign, int colspan, String name,
		PortletURL portletURL) {

		if (portletURL == null) {
			addText(align, valign, colspan, name);
		}
		else {
			addText(align, valign, colspan, name, portletURL.toString());
		}
	}

	public void addText(
		String align, String valign, int colspan, String name, String href) {

		addText(_searchEntries.size(), align, valign, colspan, name, href);
	}

	public void addText(String align, String valign, String name) {
		addText(
			_searchEntries.size(), align, valign, SearchEntry.DEFAULT_COLSPAN,
			name);
	}

	public void addText(
		String align, String valign, String name, PortletURL portletURL) {

		addText(align, valign, SearchEntry.DEFAULT_COLSPAN, name, portletURL);
	}

	public void addText(String align, String valign, String name, String href) {
		addText(
			_searchEntries.size(), align, valign, SearchEntry.DEFAULT_COLSPAN,
			name, href);
	}

	public void addText(TextSearchEntry searchEntry) {
		if (_restricted) {
			searchEntry.setHref(null);
		}

		_searchEntries.add(_searchEntries.size(), searchEntry);
	}

	public String getClassHoverName() {
		return _classHoverName;
	}

	public String getClassName() {
		return _className;
	}

	public List<SearchEntry> getEntries() {
		return _searchEntries;
	}

	public Object getObject() {
		return _obj;
	}

	public Object getParameter(String param) {
		if (_params == null) {
			_params = new HashMap<String, Object>();
		}

		return _params.get(param);
	}

	public int getPos() {
		return _pos;
	}

	public String getPrimaryKey() {
		return _primaryKey;
	}

	public boolean isBold() {
		return _bold;
	}

	public boolean isRestricted() {
		return _restricted;
	}

	public boolean isSkip() {
		return _skip;
	}

	public void removeSearchEntry(int pos) {
		_searchEntries.remove(pos);
	}

	public void setBold(boolean bold) {
		_bold = bold;
	}

	public void setClassHoverName(String classHoverName) {
		_classHoverName = classHoverName;
	}

	public void setClassName(String className) {
		_className = className;
	}

	public void setObject(Object obj) {
		_obj = obj;
	}

	public void setParameter(String param, Object value) {
		if (_params == null) {
			_params = new HashMap<String, Object>();
		}

		_params.put(param, value);
	}

	public void setPrimaryKey(String primaryKey) {
		_primaryKey = primaryKey;
	}

	public void setRestricted(boolean restricted) {
		_restricted = restricted;
	}

	public void setSkip(boolean skip) {
		_skip = skip;
	}

	private boolean _bold;
	private String _classHoverName;
	private String _className;
	private List<SearchEntry> _searchEntries;
	private Object _obj;
	private Map<String, Object> _params;
	private int _pos;
	private String _primaryKey;
	private boolean _restricted;
	private boolean _skip;

}