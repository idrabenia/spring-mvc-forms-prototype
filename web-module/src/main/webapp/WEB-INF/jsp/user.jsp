<%@ page import="com.yannart.validation.json.JSR303ToJSONConstraintDescriptor" %>
<%@ page import="idrabenia.webtest.domain.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head><title>Create New User</title></head>
<body>
<script>
    $(function() {
        $('#userForm').smartForm({
                    actionUrl: '<c:url value="/user/save" />',
                    successTransitionUrl: '<c:url value="/" />',
                    rules: { <%= new JSR303ToJSONConstraintDescriptor(false).render(User.class) %> }
                });
    });
</script>

<form id="userForm" action="">
    <fieldset>
        <legend>Create User</legend>

        <div class="control-group">
            <label for="firstNameField">First Name</label>
            <input id="firstNameField" name="firstName" type="text" class="required" value=""/>
            <span class="help-inline"></span>
        </div>

        <div class="control-group">
            <label for="lastNameField">Last Name</label>
            <input id="lastNameField" name="lastName" type="text" class="required" value=""/>
            <span class="help-inline"></span>
        </div>

        <div class="control-group">
            <label for="birthDateField">Date of Birth</label>
            <input id="birthDateField" name="birthDate" type="text" class="required" value=""/>
            <span class="help-inline"></span>
        </div>

        <label></label>
        <input type="submit" value="submit" class="btn"/>
    </fieldset>
</form>

</body>
</html>