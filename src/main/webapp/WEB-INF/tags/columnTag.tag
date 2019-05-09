<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ attribute name="property" required="true" type="java.lang.String" %>
<%@ attribute name="name" required="false" type="java.lang.String" %>

<s:eval expression="requestScope.head" var="isHead" />
<c:if test="${isHead == true}">
    <th style="text-align: center;" scope="col">
        <c:if test="${name != null}" >
            <c:out value="${name}" />
        </c:if>
        <c:if test="${name == null}" >
            <c:out value="${fn:toUpperCase(fn:substring(property, 0, 1))}${fn:toLowerCase(fn:substring(property, 1,fn:length(property)))}" />
        </c:if>
    </th>
</c:if>
<c:if test="${isHead == false}">
    <s:eval expression="requestScope.item.dataDetailAddress" var="url"/>
    <td style="padding-left:10%;">
        <a style="color: white; " href = "<c:url value = "${url}"/>">
            <s:eval expression="requestScope.item.${property}" />
        </a>
    </td>
</c:if>
