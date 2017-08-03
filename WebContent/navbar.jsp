<!-- start navbar here -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="en_US" />
<!-- fixes date not displaying correctly in Eclipse browser -->


<link href="CSS/navbar.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Roboto"
	rel="stylesheet">
<div id="flipkart-navbar">
	<div class="container">
		<div class="row row1">
			<ul class="largenav pull-right">
				<li class="upper-links"><a class="links" href="Home">Home</a></li>

				<c:if test="${user != null }">

					<li class="upper-links"><a class="links"
						href="PurchaseHistoryServlet">Purchases</a></li>
				</c:if>

				<li class="upper-links"><a class="links"
					href="http://clashhacks.in/">Link 3</a></li>
				<li class="upper-links"><a class="links"
					href="http://clashhacks.in/">Link 4</a></li>
				<li class="upper-links"><a class="links"
					href="http://clashhacks.in/">Link 5</a></li>
				<li class="upper-links"><a class="links"
					href="http://clashhacks.in/">Link 6</a></li>


			</ul>
		</div>
		<div class="row row2">
			<div class="col-sm-2">
				<h2 style="margin: 0px;">
					<span class="smallnav menu" onclick="openNav()">Search</span>
				</h2>
				
			</div>
			<div class="flipkart-navbar-search smallsearch col-sm-8 col-xs-11">
				<div class="row">


					<form action="Home" id="searchbar" name="searchbar">
						<input type="hidden" name="search_param" value="all"
							id="search_param" /> <input type="text" class="form-control"
							name="searchtext" placeholder="Search term..." />
						<div class="input-group-btn search-panel">
							<button type="button" class="btn btn-default dropdown-toggle"
								data-toggle="dropdown">
								<span id="search_concept">Select List</span> <span class="caret"></span>
							</button>
							<ul class="dropdown-menu" role="menu">
								<li><a href="#all">All Products</a></li>

								<c:if test="${user != null }">
									<li><a href="#purchase">Purchase History</a></li>
								</c:if>

							</ul>

						</div>

						<span class="input-group-btn">
							<button class="btn btn-default" type="button"
								onclick="searchbar.submit()">
								<span class="glyphicon glyphicon-search"></span>
							</button>
						</span>
					</form>


				</div>
			</div>
			<div class="cart largenav col-sm-2">
				<a class="cart-button" onclick="location.href='CartServlet';">
					<svg class="cart-svg " width="12 " height="12 "
						viewBox="0 0 16 16 ">
                        <path
							d="M15.32 2.405H4.887C3 2.405 2.46.805 2.46.805L2.257.21C2.208.085 2.083 0 1.946 0H.336C.1 0-.064.24.024.46l.644 1.945L3.11 9.767c.047.137.175.23.32.23h8.418l-.493 1.958H3.768l.002.003c-.017 0-.033-.003-.05-.003-1.06 0-1.92.86-1.92 1.92s.86 1.92 1.92 1.92c.99 0 1.805-.75 1.91-1.712l5.55.076c.12.922.91 1.636 1.867 1.636 1.04 0 1.885-.844 1.885-1.885 0-.866-.584-1.593-1.38-1.814l2.423-8.832c.12-.433-.206-.86-.655-.86 "
							fill="#fff "></path>
                    </svg>
				</a>&nbsp;&nbsp;&nbsp;
				<c:if test="${user != null }">
					<!-- Add profile page -->
					<c:out value="${user.username}" />
				</c:if>
				<c:if test="${user == null }">
					<br />
					<a href="login.jsp" style="color: black;"> Login to Account </a>
				</c:if>

			</div>
			<c:if test="${user != null }">
				<form class="navbar-form navbar-left" role="form" action="Home"
					method="post">
					<input type="hidden" name="action" id="action" value="logout" />
					<button class="btn btn-default" id="addBookButton">Logout</button>
				</form>
			</c:if>

		</div>
	</div>
</div>

<script>
function openNav() {
    document.getElementById("mySidenav").style.width = "70%";
    // document.getElementById("flipkart-navbar").style.width = "50%";
    document.body.style.backgroundColor = "rgba(0,0,0,0.4)";
}

function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
    document.body.style.backgroundColor = "rgba(0,0,0,0)";
}

$(document).ready(function(e) {
	$('.search-panel .dropdown-menu').find('a').click(function(e) {
		e.preventDefault();
		var param = $(this).attr("href").replace("#", "");
		console.log(param);
	
		document.getElementById('search_param').value = "" + param;
		
		if(param == "purchase"){
			document.getElementById('searchbar').action = "MyCartServlet";
		}
		var concept = $(this).text();
		$('.search-panel span#search_concept').text(concept);
		
	
		
		

	});
});
</script>
