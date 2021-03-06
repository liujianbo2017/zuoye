<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//for(int i=0;i<9;i++){}
		//for(Object v: Collection){}
	%>
	<%--
		计数型循环:
			var:指定循环 控制变量名
			begin:起始值
			eng:结束值(闭区间)
			step:步长(循环控制变量每次自增多少) 默认为1
			循环控制变量是自动保存到Page域的
	 --%>
	 <c:forEach var="i" begin="1" end="2" step="1">
	 	${i }<br/>
	 </c:forEach>
	 <%--
	 	增强型的for循环(遍历集合)
	 		var: 被遍历的集合中元素的变量名
	 		items: 被遍历的集合
	 		如果集合为空,则什么都不做
	  --%>
	  <%
	  	List<String> list = new ArrayList<String>();
	  	list.add("aaa");
	  	list.add("bbb");
	  	list.add("ccc");
	  	
	  	//pageContext.setAttribute("aaa",list);
	  %>
	  <c:forEach var="s" items="${aaa }">
	  		${s }<br/>
	  </c:forEach>
	  <hr/>
	  
	  <%--也可以在items属性中传入一个局部集合对象(不在域中的)(了解) --%>
	  <c:forEach var="s" items="<%= list %>">
	  		${s }<br/>
	  </c:forEach>
	  
	  <%
		Map<String,String> map = new HashMap<String,String>();
		
		map.put("user001","关羽");
		map.put("user002","张飞");
		map.put("user003","刘备");
	
		pageContext.setAttribute("map", map);
	 %>
	 <hr/>
	 <%--如果遍历的是一个Map集合,则var指定的对象是一个键值对对象
	 	所以想要得到键和值,则需要m.key/m.value,分别取得
	 	
	  --%>
	  <c:forEach var="m" items="${map }">
	  		${m.key } ->${m.value }<br/>
	  </c:forEach>
	  
	  <hr/>
	  <%--
	  		了解:
	  		 varStarus属性指定了一个自定义的对象名
	  		 此对象中封装了本次训话的一些相关信息
	  		 	index: 本次循环的索引(从0开始)
	  		 	count: 本次循环的序号(从1开始)
	  		 	first: 本次循环是否是第一次
	  		 	last: 本次循环是否是最后一次
	   --%>
	   <table>
	   		<c:forEach var="m" items="${map }" varStstus="s">
	   			<tr ${s.count%2==0?'bgcolor=red':'bgcolor=bule' }>
	   				<td>${m.key } -> ${m.value } : ${s.index } : ${s.count }: ${s.first } : ${s.last }</td>
	   			</tr>
	   		</c:forEach>
	   </table>
</body>
</html>