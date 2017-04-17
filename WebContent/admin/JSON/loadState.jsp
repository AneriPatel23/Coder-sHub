<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="function" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="list" value="${sessionScope.lsLoadState }"></c:set>
<c:set var="len" value="${function:length(list) }"></c:set>
[<c:forEach items="${sessionScope.lsLoadState }" var="i" varStatus="j">
		{"stateId":"${i.stateId }","stateName":"${i.stateName }"}<c:if test="${len ne j.count }">,</c:if>
	</c:forEach>]