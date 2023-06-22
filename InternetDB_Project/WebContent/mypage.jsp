<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.internetdb.wepapp.Dto.FeedRes"%>
<%@ page import="com.internetdb.wepapp.Dto.UserRes"%>
<%@ page import="com.internetdb.wepapp.Dto.LikeRes"%>
<%@ page import="com.internetdb.wepapp.Dto.CommentRes"%>
<%@ page import="java.util.List"%>
<%@ page import="com.internetdb.wepapp.Servlet.PostServlet"%>
<%@ page import="com.internetdb.wepapp.Dao.PostDao"%>
<%@ page import="com.internetdb.wepapp.Dao.UserDao"%>
<%@ page import="com.internetdb.wepapp.Dao.LikeDao"%>
<%@ page import="com.internetdb.wepapp.Dao.CommentDao"%>
<!DOCTYPE html>
<html data-wf-domain="newport-template.webflow.io"
	data-wf-page="5e4b16080b25ed0d294d526a"
	data-wf-site="5e4b16080b25ed2b324d526e" data-wf-status="1"
	class="w-mod-js wf-montserrat-n3-active wf-montserrat-n8-active wf-montserrat-n4-active wf-montserrat-n2-active wf-montserrat-n9-active wf-montserrat-n6-active wf-montserrat-n7-active wf-montserrat-n5-active wf-montserrat-n1-active wf-montserrat-i8-active wf-montserrat-i5-active wf-montserrat-i2-active wf-montserrat-i1-active wf-montserrat-i3-active wf-montserrat-i7-active wf-montserrat-i4-active wf-montserrat-i9-active wf-montserrat-i6-active wf-roboto-n3-active wf-roboto-n4-active wf-roboto-n5-active wf-active">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>PETSTAGRAM</title>
<meta content="width=device-width, initial-scale=1" name="viewport" />
<meta content="Webflow" name="generator" />
<link href="./images/favicon.png" rel="icon" type="image/png" sizes="32x32">
<link
	href="./Example Page - Webflow Template_files/newport-template.webflow.00281f806.css"
	rel="stylesheet" type="text/css" />
<link href="https://fonts.googleapis.com/" rel="preconnect" />
<link href="https://fonts.gstatic.com/" rel="preconnect"
	crossorigin="anonymous" />
<script
	src="./Example Page - Webflow Template_files/webfont.js.ë¤ì´ë¡ë"
	type="text/javascript"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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

.modal {
	height: 580px;
}

</style>
<body>
	<div data-collapse="medium" data-animation="default"
		data-duration="400" data-easing="ease" data-easing2="ease"
		role="banner" class="navigation-bar w-nav" style="z-index: 0">
		<div class="w-container">
        	<a href="index.jsp" aria-current="page" class="brand-link w-nav-brand w--current" aria-label="home">
            	<h1 class="brand-text">PETstagram</h1>
        	</a>
        	<nav role="navigation" class="navigation-menu w-nav-menu">
	            <%
	            String user_idx = (String) session.getAttribute("user_nickname");
	            if (user_idx != null) {
	            %>
	            <a id="logout-nav" href="logout.jsp" aria-current="page" class="navigation-link w-nav-link"
	               style="max-width: 940px;">Logout</a>
	            <%
	            } else {
	            %>
	            <a id="login-nav" href="login.jsp" aria-current="page" class="navigation-link w-nav-link"
	               style="max-width: 940px;">Login</a>
	            <%
	            }
	            %>
	            <a href="index.jsp" class="navigation-link w-nav-link" style="max-width: 940px;">Feed</a>
	            <a href="mypage.jsp" class="navigation-link w-nav-link" style="max-width: 940px; color: #333">My Page</a>
	        </nav>
    	</div>
		
	</div>
	<div class="w-nav-overlay" data-wf-ignore="" id="w-nav-overlay-0"></div>
	<div class="profile">
	<%
		UserDao userDao = new UserDao();
		String idx =(String) session.getAttribute("user_idx");
		UserRes myInformation = userDao.myInformation(Integer.valueOf(idx));
		
	%>
		<img src="<%= myInformation.getProfile_image()%>" alt="Profile Picture" class="profile-image">
		<h2 class="profile-name"><%String user_nickname =(String) session.getAttribute("user_nickname"); out.println(user_nickname);%></h2>
		<p class="profile-intro"><%= myInformation.getMember_introduce()%></p>
		
		<br><br>
		<h3>My Posts</h3>
	</div>

	<div class="section wf-section">
		<div class="w-container">
			<div class="w-dyn-list">
				<div role="list" class="w-dyn-items w-row">
					<%
                        List<FeedRes> myPosts = (List<FeedRes>) request.getAttribute("myPosts");

                        if (myPosts == null || myPosts.isEmpty()) {
                            PostDao postDao = new PostDao();
                            myPosts = postDao.myPost(Integer.parseInt(idx));
                        }

                        for (FeedRes feedRes : myPosts) {

                    %>
                    <div role="listitem" class="w-dyn-item w-col w-col-4">
                        <a href="#" class="photo-link-block w-inline-block btn trigger">
                            <img
                                    class="feed_img"
                                    style="width:300px; height:300px; object-fit: cover;"
                                    src=" <%= feedRes.getPost_picture() %> "
                                    alt="<%= feedRes.getPost_idx() %>">
                            <div class="title"><%= feedRes.getPost_title() %></div>
                            <div class="post<%= feedRes.getPost_idx() %>" style="display: hidden">
                            	<input type="hidden" id="post_title" value="<%= feedRes.getPost_title() %>">
                            	<input type="hidden" id="user_idx" value="<%= feedRes.getUser_idx() %>">
                            	<input type="hidden" id="user_nickname" value="<%= feedRes.getUser_nickname() %>">
                            	<input type="hidden" id="post_animal" value="<%= feedRes.getAnimal() %>">
                            	<input type="hidden" id="post_location" value="<%= feedRes.getPost_location() %>">
                            	<input type="hidden" id="post_picture" value="<%= feedRes.getPost_picture() %>">
                            	<input type="hidden" id="post_content" value="<%= feedRes.getPost_content() %>">
                        	</div>
                        </a>
                    </div>
                    <%
                        }
                    %>
				</div>
			</div>
		</div>
	</div>
	
	<div class="comment-section">
	  	<%
	  		CommentDao commentDao = new CommentDao();
	  		List<CommentRes> commentList = commentDao.findAllComment();
	  		
	  		for (CommentRes comment : commentList) {
	  	%>
	  	<div class="comment<%= comment.getPost_idx()%>" style="display:none">
	  		<input type="hidden" value="<%= comment.getComment_idx() %>">
	  		<input type="hidden" class="comment_user_nickname" value="<%= comment.getUser_nickname()%>">
	  		<input type="hidden" class="comment_content" value="<%= comment.getComment()%>">
	  	</div>
	  	<%} %>
    </div>


	<!-- Feed Post Modal -->
    <div class="modal-wrapper">
        <div class="modal">
            <div class="head">
                <button class="btn-close trigger">X</button>
            </div>
            <div class="content">
                <div class="modal-img">
                    <img src="./Example Page - Webflow Template_files/5e4b16080b25ed48de4d52a9_photo-1441906363162-903afd0d3d52-square700.jpg" />
                </div>
                <div class="modal-content">
                	<div class="modal_post_title">Post Title</div>
                    <div class="modal_user_nickname">User Name</div>
                    <div class="modal_post_location">User Location</div>
                    <div class="modal_post_animal">animal</div>
                    <hr>
                    <div class="modal_post_content">Post Content</div>
                    <form id="modifyForm" action="post-servlet" method="post" style="display:none">
                    	<input type="hidden" name="action" value="modifyPost">
                    	<input type="hidden" id="post_idx_content" name="post_idx" />
                    	<textarea class="modified-content" name="modified-content" style="width: 290px; height: 95px; overflow-wrap: break-word;"></textarea>
                    </form>
                    <div class="comment">
                    </div>
                    <%
                    	if (user_idx != null) { 
                    %>
                    <div class="comment_reg">
                    	<form action="comment-servlet" method="post" onsubmit="return checkComment()">
                    		<input type="hidden" name="action" value="registerComment">
                    		<input type="hidden" name="page" value="mypage">
                    		<input type="hidden" name="user_idx" value="<%= idx %>">
                    		<input class="comment_post_idx" type="hidden" name="post_idx" value="">
                    		<input id="input_comment" type="text" name="comment" size="30" >
                    		<input id="submit_btn" type="submit" value="✔️">
                    	</form>
                    </div>
                    <% } else {}%>
                    
                    <div class="modal_btn_wrap">
		                <form id="deleteForm" action="post-servlet" method="post">
		                	<input type="hidden" name="action" value="deletePost">
		                	<input type="hidden" id="post_idx_input" name="post_idx" />
		                	<input class="w-btn-outline w-btn-indigo-outline" type="submit" value="Delete" style="display:inline"/>
		            	</form>
		            	<input class="modifybutton w-btn-outline w-btn-gray-outline" type="button" name="modify" value="Modify">
		            	<input class="completebutton w-btn-outline w-btn-gray-outline" type="button" name="modify" value="Complete" style="display:none" onclick="document.getElementById('modifyForm').submit();">
	            	</div>
                </div>
                <div class="like_req">
					<% 
						if (user_idx != null) {
					%>
					<label onclick="like_onclick()" onmouseover="like_hover()" onmouseout="like_out()"> <!-- 로그인 시 click 가능 + 빨간 하트되도록 함수 구현 -->
					<% } else { %>
					<label>
					<% } %>
						<i id="heart" style="font-size:32px;" class="fa like_count">&#xf08a;</i> <!-- else. 미로그인 시 클릭 불가능. 좋아요 수는 볼 수 있음 -->
						<span id="like_count" class="like_count" style="font-size: 20px; font-weight: bold; vertical-align: 3.5px; margin-left: 5px;">0</span>
					</label>
				</div>	            
            </div>
        </div>
    </div>
    
    <div class="like-section">
    	<%
    		LikeDao likeDao = new LikeDao();
    		List<LikeRes> likeList = likeDao.countLike();
    		
    		for(LikeRes like : likeList) {
    	%>
    		<input id="like<%= like.getPost_idx() %>" type="hidden" value="<%= like.getLike_count() %>">
    	<%} %>
    </div>
	
	<div class="footer wf-section">
        <div class="w-container">
            <div>
                <a href="https://github.com/HEE-YONG" class="social-icon-link w-inline-block">
                    <i style="font-size:24px; color:lightgreen" class="fa">&#xf09b;</i>
                </a>
                <a href="https://github.com/IndigoJSilver" class="social-icon-link w-inline-block">
                    <i style="font-size:24px; color:pink" class="fa">&#xf09b;</i>
                </a>
                <a href="https://github.com/dgw0620" class="social-icon-link w-inline-block">
                    <i style="font-size:24px; color:skyblue" class="fa">&#xf09b;</i>
                </a>
            </div>
        </div>
        <div class="footer-text">Powered by InternetDB 6 team</div>
    </div>
	<script>
    	function like_hover() {
    		var heart = document.getElementById("heart");
    		var like_count = document.getElementById("like_count");
    		
    		heart.style.color = "red";
    		like_count.style.color = "red";
    	}
    	
    	function like_out() {
    		var heart = document.getElementById("heart");
    		var like_count = document.getElementById("like_count");
    		
    		heart.style.color = "white";
    		like_count.style.color = "white";	
    	}
    	
    	function like_onclick() {
    		var post_idx = document.getElementById("post_idx_hidden").value;
    	    var user_idx = <%= idx %> + "";
    	    
    		var like_count = document.getElementById("like_count");
    		like_count.innerText++;
    		
    		var like = document.getElementById("like" + post_idx);
    		like.value++;
			
    		var data = {
    				user_idx: user_idx,
    				post_idx: post_idx
    		}
    		
    	    var xhr = new XMLHttpRequest();
    		xhr.open("POST", "like-servlet", true);
    		xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
		    
    		var encodedData = Object.keys(data)
    	    .map(function(key) {
    	      return encodeURIComponent(key) + '=' + encodeURIComponent(data[key]);
    	    })
    	    .join('&');
    		
    		xhr.onreadystatechange = function() {
		        if (xhr.readyState === 4 && xhr.status === 200) {
		            console.log(xhr.responseText);
		        }
		    };
		    
			xhr.send(encodedData);
    	}
    </script>
	<script src="JS/mypage.js" type="text/javascript"></script>
</body>
</html>
