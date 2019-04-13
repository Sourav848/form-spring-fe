<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>TESTING</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link
	href="//fonts.googleapis.com/css?family=Noto+Sans%7cOpen%20Sans%7cMerienda+One"
	rel='stylesheet' type='text/css'>
<link
	href="https://static.hometutorsite.com/content/css/main-26may17.css"
	rel='stylesheet' type='text/css'>


<!-- Google Tag Manager -->

	<script>
		(function(w, d, s, l, i) {
			w[l] = w[l] || [];
			w[l].push({
				'gtm.start' :
				new Date().getTime(),
				event : 'gtm.js'
			});
			var f = d.getElementsByTagName(s)[0],
			j = d.createElement(s), dl = l != 'dataLayer' ? '&l=' + l : '';
			j.async = true;
			j.src =
			'https://www.googletagmanager.com/gtm.js?id=' + i + dl;
			f.parentNode.insertBefore(j, f);
	
		})(window, document, 'script', 'dataLayer', 'GTM-KTDR77M');
	</script>

  <!-- End Google Tag Manager -->

<script src="//cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.2/js/bootstrap.min.js"></script>
<%-- <script src="${pageContext.request.contextPath}/resources/tution/js/jquery.validate.js"></script> --%>
<script>var contextPath = "${pageContext.request.contextPath}";</script>

	<body>
	
		<tiles:insertAttribute name="css" />
		<div id="pageContent" style="position: fixed; display: none">
			<%-- <tiles:insertAttribute name="header" /> --%>
			<div id="htmlContent" style="position: fixed; display: none">
				<tiles:insertAttribute name="content" />
			</div>
			<div id="pageFooter" style="position: fixed; display: none">
				<%-- <tiles:insertAttribute name="footer" /> --%>
			</div>
		</div>
		<!-- <script
			src="//ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script> -->
			
			
	
	<!-- Angular App Script -->
	
		<tiles:insertAttribute name="js" />
	  <script>
			(function(i, s, o, g, r, a, m) {
				i['GoogleAnalyticsObject'] = r;
				i[r] = i[r] || function() {
					(i[r].q = i[r].q || []).push(arguments)
				}, i[r].l = 1 * new Date();
				a = s.createElement(o), m = s
	
				.getElementsByTagName(o)[0];
				a.async = 1;
				a.src = g;
				m.parentNode.insertBefore(a, m)
			})(window, document, 'script',
					'https://www.google-analytics.com/analytics.js', 'ga');
	
			ga('create', 'UA-104765514-1', 'auto');
			ga('send', 'pageview');
		</script>

	<script>
           $(document).ready(function()
		 {
			setTimeout(function() {
				// $("#bodymovin").css("display", "none"); 
				$("#htmlContent").css("position", "static");
				$("#htmlContent").css("display", "block");
				$("#pageContent").css("position", "static");
				$("#pageContent").css("display", "block");
				$("#pageFooter").css("position", "static");
				$("#pageFooter").css("display", "block");

			}, 0)
		});
	</script>
</body>
</head>
