<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<s:eval expression="items.searchCriteria" scope="request" var="searchCriteria" />
<div style="margin-top: 10%;">
<div style="max-width: 50%; margin-left: auto; margin-right: auto;">
    <sf:form method="POST" modelAttribute="searchCriteria">
        <c:set value="0" var="inlineCounter" scope="request" />
        <jsp:doBody />

        <div style="padding-left:89.5%; margin-top: 1%; margin-bottom: 1%;">
            <input class="btn btn-primary" type="submit" value="Search"/>
        </div>
    </sf:form>
</div>
</div>