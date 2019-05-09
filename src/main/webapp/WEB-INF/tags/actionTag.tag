<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ attribute name="action" required="true" type="java.lang.String" %>
<%@ attribute name="value" required="false" type="java.lang.String" %>

<%
    String forward = (String) request.getAttribute("javax.servlet.forward.request_uri");
    String s = "/action" + forward.substring(4);
    request.setAttribute("url",s);
    request.setAttribute("forward","forward="+ forward);
%>
</br>
<div style="max-width: 50%; margin-left: auto; margin-right: auto;">
    <a href="<c:url value="${url}/${action}?${forward}" context="/"/> ">
        <button type="button" class="btn btn-primary" style="margin-left:89.5%; margin-top: 1%; margin-bottom: 1%;">
            <c:if test="${value == null}">
                <c:out value="${action}"/>
            </c:if>
            <c:if test="${value != null}">
                <c:out value="${value}"/>
            </c:if>
        </button>
    </a>
</div>
