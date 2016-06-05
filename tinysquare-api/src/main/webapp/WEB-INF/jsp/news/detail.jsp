<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.tinysquare.api.news.vo.NewsVo"%>
<%@page import="com.tinysquare.api.news.vo.NewsImgVo"%>
<%@page import="java.util.List"%>
<%
	NewsVo news = (NewsVo) request.getAttribute("news");
%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
h3 {
	text-align: center;
}
</style>
<body style="max-width: 400px">
	<header class="w3-container w3-card-4 w3-theme">
		<h3>Tiny Square</h3>
	</header>
	<div class="w3-container">
		<div class="w3-row ">
			<div class="w3-col s3">
				<%
					if (news != null) {
				%>
				<img src="<%=news.getAvator()%>" class="w3-round-large"
					style="width: 100%">
				<%
					}
				%>
			</div>
			<div class="w3-row">
				<div class="w3-col s9 w3-container">
					<%
						if (news != null) {
					%>
					<h4><%=news.getShopName()%></h4>
					<p><%=news.getContent()%></p>
					<%
						}
					%>
				</div>
				<hr>
				<%
					if (news != null && news.getImgs() != null) {
						List<NewsImgVo> imgs = news.getImgs();
						for (NewsImgVo newsImage : imgs) {
				%>
				<img src="<%=newsImage.getUrl()%>" class="w3-round-large"
					style="width: 100%">
				<%
					}
					}
				%>
			</div>
		</div>
	</div>
	<footer class="w3-container w3-theme">
		<h5>From Tiny Square</h5>
	</footer>
</body>