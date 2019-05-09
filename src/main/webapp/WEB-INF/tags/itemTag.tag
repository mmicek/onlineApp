<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ attribute name="name" required="true" type="java.lang.String" %>

<div style="margin-top: 10%">
<div style="max-width: 50%; margin-left: auto; margin-right: auto; ">
    <table class="table table-bordered table-dark">
    <thead>
        <tr>
        <th style="text-align: center; width: 50%" scope="col">Property</th>
        <th style="text-align: center; width: 50%" scope="col">Value</th>
        </tr>
    </thead>
    <tbody>
        <jsp:doBody/>
    </tbody>
    </table>
</div>
</div>