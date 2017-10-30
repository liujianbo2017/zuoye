<%@ page contentType="text/html; charset=UTF-8"%>

		<c:if test="${ empty sessionScope.current_user }">
			<li><a href="${pageContext.request.contextPath}/user.servlet?method=goLoginUI">登录</a></li>
			<li><a href="${pageContext.request.contextPath}/user.servlet?method=goRegistUI">注册</a></li>
			
		</c:if>
		<c:if test="${ not empty sessionScope.current_user }">
			<li>${sessionScope.current_user.name }，您好</li>
			<li><a href="${pageContext.request.contextPath}/user.servlet?method=goRemoveUI">退出</a></li>
			<li><a href="${pageContext.request.contextPath}/order.servlet?method=showMine">我的订单</a></li>
		</c:if>
		<li><a href="${pageContext.request.contextPath }/cart.jsp">购物车</a></li>