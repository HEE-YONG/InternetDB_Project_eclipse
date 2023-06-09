<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.internetdb.wepapp.Dto.FeedRes"%>
<%@ page import="java.util.List"%>
<%@ page import="com.internetdb.wepapp.Servlet.PostServlet"%>
<%@ page import="com.internetdb.wepapp.Dao.PostDao"%>
<!DOCTYPE html>
<html data-wf-domain="newport-template.webflow.io"
	data-wf-page="5e4b16080b25ed0d294d526a"
	data-wf-site="5e4b16080b25ed2b324d526e" data-wf-status="1"
	class="w-mod-js wf-montserrat-n3-active wf-montserrat-n8-active wf-montserrat-n4-active wf-montserrat-n2-active wf-montserrat-n9-active wf-montserrat-n6-active wf-montserrat-n7-active wf-montserrat-n5-active wf-montserrat-n1-active wf-montserrat-i8-active wf-montserrat-i5-active wf-montserrat-i2-active wf-montserrat-i1-active wf-montserrat-i3-active wf-montserrat-i7-active wf-montserrat-i4-active wf-montserrat-i9-active wf-montserrat-i6-active wf-roboto-n3-active wf-roboto-n4-active wf-roboto-n5-active wf-active">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Example Page</title>
<meta content="width=device-width, initial-scale=1" name="viewport" />
<meta content="Webflow" name="generator" />
<link
	href="./Example Page - Webflow Template_files/newport-template.webflow.00281f806.css"
	rel="stylesheet" type="text/css" />
<link href="https://fonts.googleapis.com/" rel="preconnect" />
<link href="https://fonts.gstatic.com/" rel="preconnect"
	crossorigin="anonymous" />
<script
	src="./Example Page - Webflow Template_files/webfont.js.ë¤ì´ë¡ë"
	type="text/javascript"></script>
<link rel="stylesheet"
	href="./Example Page - Webflow Template_files/css" media="all" />
<link rel="stylesheet" href="CSS/css.css" />
<script type="text/javascript">
	WebFont
			.load({
				google : {
					families : [
							"Montserrat:100,100italic,200,200italic,300,300italic,400,400italic,500,500italic,600,600italic,700,700italic,800,800italic,900,900italic",
							"Roboto:300,regular,500", ],
				},
			});
</script>
<script type="text/javascript">
	!(function(o, c) {
		var n = c.documentElement, t = " w-mod-";
				(n.className += t + "js"),
				("ontouchstart" in o || (o.DocumentTouch && c instanceof DocumentTouch))
						&& (n.className += t + "touch");
	})(window, document);
</script>
<link href="https://assets.website-files.com/img/favicon.ico"
	rel="shortcut icon" type="image/x-icon" />
<link href="https://assets.website-files.com/img/webclip.png"
	rel="apple-touch-icon" />
</head>
<style>
.post-title {
	font-weight: bold;
	margin-top: 10px;
}

.profile {
	text-align: center;
	margin-bottom: 20px;
}

.profile-image {
	max-width: 100px;
	height: auto;
	border-radius: 50%;
}

.profile-name {
	font-weight: bold;
	margin-top: 10px;
}

.profile-intro {
	margin-top: 5px;
}
</style>
<body>
	<div data-collapse="medium" data-animation="default"
		data-duration="400" data-easing="ease" data-easing2="ease"
		role="banner" class="navigation-bar w-nav">
		<div class="w-container">
			<a href="index.jsp" aria-current="page"
				class="brand-link w-nav-brand w--current" aria-label="home">
				<h1 class="brand-text">PetStagram</h1>
			</a>

			<nav role="navigation" class="navigation-menu w-nav-menu">
				<a href="login.html" aria-current="page"
					class="navigation-link w-nav-link w--current"
					style="max-width: 940px;">Login</a> 
				<a href="index.jsp"
					class="navigation-link w-nav-link" style="max-width: 940px;">
					Feed </a> 
				<a href="mypage.jsp" class="navigation-link w-nav-link"
					style="max-width: 940px;"> My Page </a>
			</nav>


		</div>
	</div>
	<div class="w-nav-overlay" data-wf-ignore="" id="w-nav-overlay-0"></div>
	<div class="profile">
		<img src="userPic.jpg" alt="Profile Picture" class="profile-image">
		<h2 class="profile-name">Your Name</h2>
		<p class="profile-intro">Hello, I'm John Doe! Nice to meet you.</p>
	</div>

	<div class="section wf-section">
		<div class="w-container">
			<div class="w-dyn-list">
				<div role="list" class="w-dyn-items w-row">
					<%
                        List<FeedRes> filteredPosts = (List<FeedRes>) request.getAttribute("filteredPosts");

                        if (filteredPosts == null || filteredPosts.isEmpty()) {
                            PostDao postDao = new PostDao();
                            filteredPosts = postDao.filterPost("", "");
                        }

                        for (FeedRes feedRes : filteredPosts) {

                    %>
                    <div role="listitem" class="w-dyn-item w-col w-col-4">
                        <a href="#" class="photo-link-block w-inline-block btn trigger">
                            <img
                                    class="feed_img"
                                    style="width:300px; height:300px; object-fit: cover;"
                                    src=" <%= feedRes.getPost_picture() %> "
                                    alt="">
                            <div class="title"><%= feedRes.getPost_title() %></div>
                        </a>
                    </div>
                    <%
                        }
                    %>
				</div>
			</div>
		</div>
	</div>


	<!-- Modal -->
	<div class="modal-wrapper">
		<div class="modal">
			<div class="head">
				<button class="btn-close trigger">X</button>
			</div>
			<div class="content">
				<div class="modal-img">
					<img
						src="./Example Page - Webflow Template_files/5e4b16080b25ed48de4d52a9_photo-1441906363162-903afd0d3d52-square700.jpg" />
				</div>
				<div class="modal-content">
					<div class="user_idx">User Name</div>
					<div class="user_location">User Location</div>
					<div class="post_content">Post Content</div>
					<div class="comment_user_idx">Comment User Name</div>
					<div class="comment_content">Comment Content</div>
				</div>
			</div>
		</div>
	</div>
	
	<div class="footer wf-section">
        <div class="w-container">
            <div>
                <a href="https://newport-template.webflow.io/#" class="social-icon-link w-inline-block">
                    <img src="./Example Page - Webflow Template_files/5e4b16080b25ed58884d531f_social-03.svg" width="20" alt="">
                </a>
                <a href="https://newport-template.webflow.io/#" class="social-icon-link w-inline-block">
                    <img src="./Example Page - Webflow Template_files/5e4b16080b25edc4554d52d1_social-18.svg" width="20" alt="">
                </a>
                <a href="https://newport-template.webflow.io/#" class="social-icon-link w-inline-block">
                    <img src="./Example Page - Webflow Template_files/5e4b16080b25ed438e4d5316_social-30.svg" width="20" alt="">
                </a>
            </div>
        </div>
        <div class="footer-text">Powered by Webflow</div>
    </div>

	<script src="JS/mypage.js" type="text/javascript"></script>
</body>
</html>
