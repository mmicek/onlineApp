<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ attribute name="value" required="true" type="java.lang.String" %>
<%@ attribute name="name" required="true" type="java.lang.String" %>

<tr>
    <td style="padding-left:10%;"><c:out value="${name}" /></td>
    <td style="padding-left:10%;"><s:eval expression="item.${value}" /></td>
</tr>
