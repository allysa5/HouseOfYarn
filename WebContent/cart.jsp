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