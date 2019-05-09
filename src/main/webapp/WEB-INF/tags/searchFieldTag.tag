<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ attribute name="field" required="true" type="java.lang.String" %>
<%@ attribute name="name" required="false" type="java.lang.String" %>
<%@ attribute name="values" required="false" type="java.lang.String" %>

<c:if test="${requestScope.inlineCounter == 0}">
    <div style="margin-top: 2%" class="row" >
</c:if>
<c:if test="${values != null}">
    <div style="max-width: 33%; margin-left: 0.5%" class="col">
        <select name="${field}" id="inputState" class="form-control" />
            <option disabled selected value>
                <c:if test="${name == null}">
                    <c:out value="${field}"/>
                </c:if>
                <c:if test="${name != null}">
                    <c:out value="${name}" />
                </c:if>
            </option>
            <s:eval expression="items.${values}" var="vals" />
            <c:forEach items="${vals}" var="value">
                <option value="<c:out value="${value}"/>">
                    <c:out value="${value}" />
                </option>
            </c:forEach>
        </select>
    </div>
</c:if>
<c:if test="${values == null}">
    <div style="max-width: 33%; margin-left: 0.5%" class="col">
        <c:if test="${name == null}">
            <c:set var="ph" value="${field}" />
        </c:if>
        <c:if test="${name != null}">
            <c:set var="ph" value="${name}" />
        </c:if>
        <sf:input class="form-control" path="${field}" placeholder="${ph}"/>
    </div>
</c:if>
<c:if test="${requestScope.inlineCounter == 2}">
    </div>
</c:if>
<c:set var="inlineCounter" scope="request" value="${(requestScope.inlineCounter + 1) % 3}"/>