<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.internetdb.wepapp.Dto.FeedRes" %>
<%@ page import="com.internetdb.wepapp.Dto.CommentRes" %>
<%@ page import="java.util.List" %>
<%@ page import="com.internetdb.wepapp.Servlet.PostServlet" %>
<%@ page import="com.internetdb.wepapp.Dao.PostDao" %>
<%@ page import="com.internetdb.wepapp.Dao.CommentDao" %>

<!DOCTYPE html>
<html data-wf-domain="newport-template.webflow.io" data-wf-page="5e4b16080b25ed0d294d526a"
      data-wf-site="5e4b16080b25ed2b324d526e" data-wf-status="1"
      class="w-mod-js wf-montserrat-i2-active wf-montserrat-i4-active wf-montserrat-i7-active wf-montserrat-i8-active wf-montserrat-i6-active wf-montserrat-i9-active wf-montserrat-i5-active wf-montserrat-i3-active wf-montserrat-i1-active wf-roboto-n4-active wf-roboto-n3-active wf-roboto-n5-active wf-montserrat-n5-active wf-montserrat-n6-active wf-montserrat-n9-active wf-montserrat-n1-active wf-montserrat-n8-active wf-montserrat-n7-active wf-montserrat-n3-active wf-montserrat-n4-active wf-montserrat-n2-active wf-active">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>PETSTAGRAM</title>
    <meta content="width=device-width, initial-scale=1" name="viewport">
    <meta content="Webflow" name="generator">
    <link href="./Example Page - Webflow Template_files/newport-template.webflow.00281f806.css" rel="stylesheet"
          type="text/css">
    <link href="https://fonts.googleapis.com/" rel="preconnect">
    <link href="https://fonts.gstatic.com/" rel="preconnect" crossorigin="anonymous">
    <script src="./Example Page - Webflow Template_files/webfont.js.다운로드" type="text/javascript"></script>
    <link rel="stylesheet" href="./Example Page - Webflow Template_files/css" media="all">
    <link rel="stylesheet" href="CSS/css.css">
    <script type="text/javascript">
        WebFont.load({google: {families: ["Montserrat:100,100italic,200,200italic,300,300italic,400,400italic,500,500italic,600,600italic,700,700italic,800,800italic,900,900italic", "Roboto:300,regular,500"]}});
    </script>
    <script type="text/javascript">
        !function (o, c) {
            var n = c.documentElement, t = " w-mod-";
            n.className += t + "js", ("ontouchstart" in o || o.DocumentTouch && c instanceof DocumentTouch) && (n.className += t + "touch")
        }(window, document);
    </script>
    <link href="https://assets.website-files.com/img/favicon.ico" rel="shortcut icon" type="image/x-icon">
    <link href="https://assets.website-files.com/img/webclip.png" rel="apple-touch-icon">
</head>
<body>
    <div data-collapse="medium" data-animation="default" data-duration="400" data-easing="ease" data-easing2="ease" role="banner" class="navigation-bar w-nav" style="z-index: 0">
    <div class="w-container">
        <a href="index.jsp" aria-current="page" class="brand-link w-nav-brand w--current" aria-label="home">
            <h1 class="brand-text">PETstagram</h1>
        </a>
        <nav role="navigation" class="navigation-menu w-nav-menu">
            <%
            String user_idx = (String) session.getAttribute("user_idx");
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
            <a href="index.jsp" class="navigation-link w-nav-link" style="max-width: 940px; color: #333">Feed</a>
            <%
            if (user_idx != null) {
            %>
            <a href="mypage.jsp" class="navigation-link w-nav-link" style="max-width: 940px;">My Page</a>
            <%
            } else {
            %>
            <a href="login.jsp" class="navigation-link w-nav-link" style="max-width: 940px;">My Page</a>
            <%
            }
            %>
        </nav>
        <div class="hamburger-button w-nav-button" style="-webkit-user-select: text;" aria-label="menu" role="button"
             tabindex="0" aria-controls="w-nav-overlay-0" aria-haspopup="menu" aria-expanded="false">
            <div class="w-icon-nav-menu"></div>
        </div>
    </div>

        <div class="filter">
            <form id="filter-form" action="post-servlet" method="post">
                <input type="hidden" name="action" value="filter">
                <div class="accordion" style="display: flex; flex-direction: row">
                    <div style="margin-right: 30px">
                        <input type="checkbox" id="answer01" />
                        <label for="answer01">Animal <span>▽</span></label>
                        <div style="display: flex; flex-direction: row">
                            <div class="radioStyle" style="display: flex; flex-direction: row">
                                <input
                                        class="radioStyle filter-radio"
                                        type="radio"
                                        id="dog"
                                        name="animal"
                                        value="dog"/>
                                <label for="dog" style="margin-right: 10px">dog</label>
                            </div>
                            <div
                                    class="radioStyle"
                                    style="display: flex; flex-direction: row">
                                <input
                                        class="radioStyle filter-radio"
                                        type="radio"
                                        id="cat"
                                        name="animal"
                                        value="cat"/>
                                <label for="cat" style="margin-right: 10px">cat</label>
                            </div>
                            <div
                                    class="radioStyle"
                                    style="display: flex; flex-direction: row">
                                <input
                                        class="radioStyle filter-radio"
                                        type="radio"
                                        id="etc"
                                        name="animal"
                                        value="etc"/>
                                <label for="etc" style="margin-right: 10px">etc</label>
                            </div>
                            <div
                                    class="radioStyle"
                                    style="display: flex; flex-direction: row">
                                <input
                                        class="radioStyle filter-radio"
                                        type="radio"
                                        id="all"
                                        name="animal"
                                        value="all"
                                        checked/>
                                <label for="all">all</label>
                            </div>
                        </div>
                    </div>
                    
                    <%	if (user_idx != null) { %> 
                    <div>
                    <%	} else {%>
                    <div style="display:none">
                    <%} %>
                    	<input type="hidden" name="user_idx" value="<%= user_idx %>">
                        <input type="checkbox" id="answer02" />
                        <label for="answer02">Region <span>▽</span></label>
                        <div style="display: flex; flex-direction: row">
                            <div
                                    class="radioStyle"
                                    style="display: flex; flex-direction: row">
                                <input
                                        class="radioStyle filter-radio"
                                        type="radio"
                                        id="whole region"
                                        name="region"
                                        value="whole region"
                                        checked/>
                                <label for="whole region" style="margin-right: 10px">whole region</label>
                            </div>
                            <div
                                    class="radioStyle"
                                    style="display: flex; flex-direction: row">
                                <input
                                        class="radioStyle filter-radio"
                                        type="radio"
                                        id="my region"
                                        name="region"
                                        value="my region"/>
                                <label for="my region">my region</label>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="w-nav-overlay" data-wf-ignore="" id="w-nav-overlay-0"></div>
    </div>
    <div class="section wf-section">
        <div class="w-container">
            <div class="w-dyn-list">
                <div role="list" class="w-dyn-items w-row">
                    <%
                        List<FeedRes> filteredPosts = (List<FeedRes>) request.getAttribute("filteredPosts");
						String filterCheck = (String) request.getAttribute("filterCheck");
                                		
                        if (filteredPosts == null || filteredPosts.isEmpty() && filterCheck == null) {
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
                    <div class="comment">
                    </div>
                    <%
                    	if (user_idx != null) { 
                    %>
                    <div class="comment_reg">
                    	<form action="comment-servlet" method="post" onsubmit="return checkComment()">
                    		<input type="hidden" name="action" value="registerComment">
                    		<input type="hidden" name="page" value="index">
                    		<input type="hidden" name="user_idx" value="<%= user_idx %>">
                    		<input class="comment_post_idx" type="hidden" name="post_idx" value="">
                    		<input id="input_comment" type="text" name="comment" size="30">
                    		<input id="submit_btn" type="submit" value="✔️">
                    	</form>
                    </div>
                    <% } else {}%>
                </div>
            </div>
        </div>
    </div>

    <!-- Add New Post Badge -->
    <%if (user_idx != null) {%>
    <a class="plus_badge post-trigger" style="cursor: pointer;">
        <img src="images/plus_icon.png"/>
    </a>
    <%} else {}%>
   

    <!-- Add New Post Modal -->
    <div class="post-modal-wrapper">
        <div class="new-post-modal">
            <div class="new-post-head">
                <button class="post-btn-close post-trigger">X</button>
            </div>
            <form class="new-post-form" action="post-servlet" method="post">
                <input type="hidden" name="action" value="addNewPost">
                <input type="hidden" name="user_idx" value="<%= user_idx %>">
                <div class="new-post-content">
                    <div class="new-post-content-left">
                        <div class="new-image-input">
                            <label style="cursor:pointer">
                                <h3>Click Here!!</h3>
                                <input type="file" name="post_picture" accept="image/*" style="display: none" onchange="loadFile(this)">
                            </label>
                        </div>
                        <div class="new-image" style="display: none"></div>
                    </div>
                    <div class="new-post-content-right">
                        <table>
                            <tr>
                                <td style="width: 110px;"><h2>Title</h2></td>
                                <td><input name="post_title" type="text" size="30"></td>
                            </tr>
                            <tr>
                                <td><h2>Animal</h2></td>
                                <td>
                                    <select name="animal">
                                        <option value="dog">Dog</option>
                                        <option value="cat">Cat</option>
                                        <option value="etc">Etc</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td><h2>Location</h2></td>
                                <td><input name="post_location" type="text" size="30"></td>
                            </tr>
                            <tr>
                                <td colspan="2"><h2>Content</h2></td>
                            </tr>
                            <tr>
                                <td colspan="2"><textarea name="post_content" cols="60" rows="10"></textarea></td>
                            </tr>
                        </table>
                    </div>
                </div>
                <div class="new-post-submit">
                    <input class="w-btn-outline w-btn-indigo-outline" id="reset" type="reset" value="RESET" onclick="reset()">
                    <input class="w-btn-outline w-btn-gray-outline" type="submit" value="POST">
                </div>
            </form>
        </div>
    </div>
    <script src="./Example Page - Webflow Template_files/jquery-3.5.1.min.dc5e7f18c8.js.다운로드" type="text/javascript"
            integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
    <script src="./Example Page - Webflow Template_files/webflow.cff8c8c61.js.다운로드" type="text/javascript"></script>
    <script src="JS/main.js" type="text/javascript"></script>
    <script>
        $(document).ready(function() {$(".w-webflow-badge").removeClass("w-webflow-badge").empty(); });
    </script>
</body>
</html>