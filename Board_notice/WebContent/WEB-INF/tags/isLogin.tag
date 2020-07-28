<%@tag trimDirectiveWhitespaces="true" body-content="scriptless" pageEncoding="utf-8" %>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if  test="${not empty sessionScope.authUser}">
<jsp:doBody />
</c:if>