
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="root" value="${pageContext.request.contextPath}"/>

<div class="header">
	<div class="header-bottom">
		<div class="container">
			<div class="h_menu4">
				<a class="toggleMenu" href="#">Menu</a>
				<ul class="nav">
					<li class="active"><a href="${root}/jsp/index.jsp"><i> </i>Trang chủ</a></li>
					<li><a href="#">Đồ bóng đá</a>
						<ul class="drop">
							<c:forEach items="${listCategory}" var="e">
							<li>
								<a href="">${e.categoryName}</a>								
							</li>
						</c:forEach>
						</ul></li>
					<li><a href="#"> ĐỒ BÓNG RỔ</a></li>
					<li><a href="#">ĐỒ BƠI LỘI</a></li>
					<li><a href="#">THÔNG TIN</a></li>
					<li><a href="#">KHUYẾN MÃI</a></li>
					
					</ul>
				<script type="text/javascript" src="${root}/js/nav.js"></script>
			</div>
		</div>
	</div>
	<div class="header-bottom-in">
		<div class="container">
			<div class="header-bottom-on">
				<p class="wel">
					<a href="#"><marquee direction="left" scrollamount="4"><h4 style="color: #f95a32;">Chào mừng bạn đến với Shop Hoàng Anh Sport</h4></marquee>						
					</a>
				</p>
				<div class="header-can">
					<div class="search">
						<form>
							<input type="text" value="Search" onfocus="this.value = '';"
								onblur="if (this.value == '') {this.value = '';}"> 
							<!-- <input type="submit" value=""> -->
						</form>
					</div>
					<div class="header-in">
						<ul class="icon1 sub-icon1">
							
						</ul>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
</div>