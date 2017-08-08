<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="en_US" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Shopping Cart</title>
</head>
<body>
	<jsp:include page="include.jsp" />

	<jsp:include page="navbar.jsp" />

	<table style="border: 1;">
		<div class="container">
			<div class="row">
				<br>
				<div class="col-md-12">
					<div
						class="col-md-4 col-sm-6 col-xs-12 col-md-push-6 col-sm-push-6">
						<!--REVIEW ORDER-->
						<div class="panel panel-default">
							<div class="panel-heading text-center">
								<h4>Review Order</h4>
							</div>
							<div class="panel-body">
								<div class="col-md-12">
									<strong>Subtotal (# item)</strong>
									<div class="pull-right">
										<span>$</span><span>200.00</span>
									</div>
								</div>
								<div class="col-md-12">
									<strong>Tax</strong>
									<div class="pull-right">
										<span>$</span><span>200.00</span>
									</div>
								</div>
								<div class="col-md-12">
									<small>Shipping</small>
									<div class="pull-right">
										<span>-</span>
									</div>
									<hr>
								</div>
								<div class="col-md-12">
									<strong>Order Total</strong>
									<div class="pull-right">
										<span>$</span><span>150.00</span>
									</div>
									<hr>
								</div>

								<button type="button" class="btn btn-primary btn-lg btn-block">Checkout</button>

							</div>

						</div>
						<!--REVIEW ORDER END-->
					</div>
					<div
						class="col-md-8 col-sm-6 col-xs-12 col-md-pull-6 col-sm-pull-6">
						<!--SHIPPING METHOD-->
						<div class="panel panel-default">
							<div class="panel-heading text-center">
								<h4>Current Cart</h4>
							</div>
							<div class="panel-body">
								<table class="table borderless">
									<thead>
										<tr>
											<td><strong>Your Cart: # item</strong></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
									</thead>
									<tbody>
										<!-- foreach ($order->lineItems as $line) or some such thing here -->
										<c:forEach var="yuseritem" items="${cartitem}">
											<tr>
												<td class="col-md-4">
													<div class="media">
														<a class="thumbnail pull-left" href="#"> <img
															class="media-object" src="${Yuseritem.product.image}"
															style="width: 72px; height: 72px;">
														</a>
														<div class="media-body">
															<h5 class="media-heading"><c:out value="${Yuseritem.product.productname}"  /></h5>
															<h5 class="media-heading"><c:out value="${Yuseritem.product.productdesc}"  /></h5>
														</div>
													</div>
												</td>
												<td class="col-md-2">
													<c:out value="${Yuseritem.price}" />
												</td>
												<td class="col-md-2">
												<c:out value="${Yuseritem.quantity}" />
												</td>
												<td class="col-md-2">
												<c:out value="${Yuseritem.price * Yuseritem.quantity}" />
												</td>
												<td class="col-md-2"><button type="button"
														class="btn btn-danger"
														onclick="location.href='DeleteServlet?id=${Yuseritem.itemid}';">Remove</button></td>
											</tr>

										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
						<!--SHIPPING METHOD END-->
					</div>
				</div>
			</div>
		</div>

	</table>
	<br />

	<a href="ConfirmationServlet" class="btn btn-success">Checkout</a>
</body>
</html>