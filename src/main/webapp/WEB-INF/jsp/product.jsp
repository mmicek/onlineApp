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

    <dto:item name="Product">
        <dto:property name="name" value="productData.name" />
        <dto:property name="quantity" value="productData.quantity"/>
        <dto:property name="price" value="productData.price" />
    </dto:item>

    <dto:action action="buy" value="Buy product" />

</body>

</html>