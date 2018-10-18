
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
	<div class="container">
		<div class="content" style="padding: 4em 0 0 0;">
			<div class="content-middle">
				<h3 class="future">Logo Đội</h3>
				<div class="content-middle-in">
					<ul id="flexiselDemo1">
						
					</ul>
					<script type="text/javascript">
						$(window).load(function() {
							$("#flexiselDemo1").flexisel({
								visibleItems : 4,
								animationSpeed : 1000,
								autoPlay : true,
								autoPlaySpeed : 3000,
								pauseOnHover : true,
								enableResponsiveBreakpoints : true,
								responsiveBreakpoints : {
									portrait : {
										changePoint : 480,
										visibleItems : 1
									},
									landscape : {
										changePoint : 640,
										visibleItems : 2
									},
									tablet : {
										changePoint : 768,
										visibleItems : 3
									}
								}
							});

						});
					</script>
					<script type="text/javascript" src="../../js/jquery.flexisel.js"></script>
				</div>
			</div>
		</div>

		<div class="products">
		<h2 class=" products-in">Sản Phẩm</h2>
		<div class="top-products">
			<c:forEach items="${listProduct}" var="e">
			<div class="col-md-3 md-col">
				<div class="col-md">
					<a href="index.jsp?productId=${e.productId}" class="compare-in"> 
						<img src="">
						<div class="compare">
							<span>Chi Tiết</span>
						</div>
					</a>
					<div class="top-content">
						<h5 style="text-align: center;">
							
							<a href="#">${e.categoryName} sân khách</a>
							
						</h5>
						<div class="white">
							<a href="CartServlet?command=plus&ID=<%=p.getProductId()%>"
								class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">Thêm Giỏ Hàng</a>
							<p class="dollar">
								<span>2</span><span>0</span><span class="in-dollar">vnđ</span>
							</p>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
			</div>
			</c:forEach>
			<div class="clearfix"></div>
		</div>
		<div class="top-products">
		
			<div class="clearfix"></div>

		</div>
		<ul class="start">
			<li><a href="#"><i></i></a></li>
			
			<li><a href="#"><i class="next"> </i></a></li>
		</ul>
	</div>
	</div>
	