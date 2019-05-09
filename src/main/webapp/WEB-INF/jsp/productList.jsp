<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="dto" uri="/WEB-INF/custom.tld"%>
<html lang="en">
<head>
    <link rel="stylesheet"
        href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
        crossorigin="anonymous">
</head>
<body>

    <dto:searchCriteria>
        <dto:searchField name="id" field="id" />
        <dto:searchField name="name" field="name"/>
        <dto:searchField name="type" field="type" values="types" />
    </dto:searchCriteria>

    <dto:table collection="productDataList" >
        <dto:column property="id" />
        <dto:column property="name" />
        <dto:column property="quantity"/>
        <dto:column property="price" />
    </dto:table>



</body>

</html>

