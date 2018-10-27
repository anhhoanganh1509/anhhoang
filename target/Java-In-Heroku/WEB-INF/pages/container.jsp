<%@page import="model.Category"%>
<%@page import="dao.CategoryDao"%>
<%@page import="model.Product"%>
<%@page import="dao.ProductDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<div class="container">
	<div class="content">
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
				<script type="text/javascript" src="${root}/js/jquery.flexisel.js"></script>
			</div>
		</div>
		<!---->
		<div class="content-bottom">
			<h3 class="future">Sản phẩm bán chạy</h3>
			<div class="content-bottom-in">
				<ul id="flexiselDemo2">		
								
				</ul>
				<script type="text/javascript">
					$(window).load(function() {
						$("#flexiselDemo2").flexisel({
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
			</div>
		</div>		
	</div>
</div>