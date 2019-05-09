<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ attribute name="collection" required="true" type="java.lang.String" %>

<div style="max-width: 50%; margin-left: auto; margin-right: auto; ">
    <table class="table table-bordered table-dark">
        <thead>
            <c:set var="head" scope="request" value="true"/>
            <tr>
                <jsp:doBody/>
            </tr>
        </thead>
        <tbody>
            <c:set var="head" scope="request" value="false"/>
            <s:eval expression="items.${collection}" var="tableName"/>
            <c:forEach items="${tableName}" var="item0">
                <tr>
                    <c:set var="item" scope="request" value="${item0}"/>
                    <jsp:doBody/>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>