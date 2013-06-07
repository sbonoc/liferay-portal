<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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
--%>

<c:if test="<%= user.hasMySites() %>">
	<aui:nav-item cssClass="my-sites" dropdown="<%= true %>" id="mySites" label="my-sites" wrapDropDownMenu="<%= false %>">
		<liferay-ui:my-sites cssClass="dropdown-menu my-sites-menu" />
	</aui:nav-item>
</c:if>

<aui:nav-item cssClass="divider-vertical"></aui:nav-item>