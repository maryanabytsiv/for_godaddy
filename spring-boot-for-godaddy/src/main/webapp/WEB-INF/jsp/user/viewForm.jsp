    <!DOCTYPE html>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
        <html lang="en">
        <head>
        <c:set var="path" value="${pageContext.request.contextPath}"/>
        </head>

        <body onload="myFunction()">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
        <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
        <script src="/js/save.js"></script>
        <strong>
        Add contact
        </strong>
        <form:form method="get" class="form-horizontal" action="${path}/user/close" commandName="userForm"
                   >
            <div>
            <label>Name : </label>
            <div class="col-md-4">
            <form:input class="form-control" path="name" placeholder="Enter User Name" required="true" />
            </div>

            <label class="col-md-2 control-label">Work : </label>
            <div class="col-md-4">
            <form:input id="phone" type="hidden" path="phones" placeholder="Enter Work Number" required="true"/>
            <form:input id="phone1" class="form-control" path="phones" placeholder="Enter Work Number" required="true"/>
            </div>
            <label class="col-md-2 control-label">Mobile : </label>
            <div class="col-md-4">
            <form:input id="phone2" class="form-control" path="phones" placeholder="Enter Mobile Number" required="true"/>
            </div>
            <label class="col-md-2 control-label">Home : </label>
            <div class="col-md-4">
            <form:input id="phone3" class="form-control" path="phones" placeholder="Enter Home Number" required="true"/>

            </div>
            <div class="panel-footer">
            <form:button value="Save" class="btn btn-xs btn-default">
                <span class="glyphicon glyphicon-floppy-disk"></span>
                Close
            </form:button>
            </div>
            </div>
        </form:form>
        </body>
        </html>