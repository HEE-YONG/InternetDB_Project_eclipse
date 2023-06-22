

document.addEventListener("DOMContentLoaded", function () {
    var pageWrapper = document.querySelector(".page-wrapper");
    var body = document.querySelector(".section");
    var nav = document.querySelector(".navigation-bar");
    var profile = document.querySelector(".profile");
    var footer = document.querySelector(".footer");



    // feed-modal
    var modalWrapper = document.querySelector(".modal-wrapper");
    var triggers = document.querySelectorAll(".trigger");

    triggers.forEach(function (trigger) {
    	trigger.addEventListener("click", viewModalContent); 
        trigger.addEventListener("click", openmodal);
    });

    var closeButton = document.querySelector(".btn-close");
    closeButton.addEventListener("click", function () {
    	$("#post_idx_hidden").remove();
        modalWrapper.classList.remove("open");
        document.querySelector(".comment").innerHTML="";
        body.classList.remove("blur-it");
        nav.classList.remove("blur-it");
        profile.classList.remove("blur-it");
        footer.classList.remove("blur-it");
    });

});

/**************************************   MODAL   ********************************************/

function viewModalContent(event) {
	  var post_idx = event.target.alt;
	  var post_title = document.querySelector(".post" + post_idx + " #post_title").value;
	  var user_idx = document.querySelector(".post" + post_idx + " #user_idx").value;
	  var user_nickname = document.querySelector(".post" + post_idx + " #user_nickname").value;
	  var post_animal = document.querySelector(".post" + post_idx + " #post_animal").value;
	  var post_location = document.querySelector(".post" + post_idx + " #post_location").value;
	  var post_picture = document.querySelector(".post" + post_idx + " #post_picture").value;
	  var post_content = document.querySelector(".post" + post_idx + " #post_content").value;
	  document.getElementById("post_idx_input").value = post_idx;
	  document.getElementById("post_idx_content").value = post_idx;
	  
	  var modalWrapper = document.querySelector(".modal-wrapper");
	  var modalImage = modalWrapper.querySelector(".modal-img img");
	  modalImage.src = "./images/" + post_picture;
	  
	  var modalTitle = modalWrapper.querySelector(".modal_post_title");
	  var modalNickname = modalWrapper.querySelector(".modal_user_nickname");
	  var modalLocation = modalWrapper.querySelector(".modal_post_location");
	  var modalAnimal = modalWrapper.querySelector(".modal_post_animal");
	  var modalContent = modalWrapper.querySelector(".modal_post_content");
	  
	  var likeCount = document.getElementById("like_count");
	  var likePost = document.querySelector(".like-section #like" + post_idx);
	  
	  if (likePost) {
		  likeCount.innerText = likePost.value;		  
	  } else {
		  var like_new = document.createElement("input");
		  like_new.type = "hidden";
		  like_new.value = "0";
		  like_new.id = "like" + post_idx;
		  document.querySelector(".like-section").appendChild(like_new);
		  likeCount.innerText = "0";
	  } 
	  
	  var post_idx_hidden = document.createElement("input");
	  post_idx_hidden.type = "hidden";
	  post_idx_hidden.value = post_idx;
	  post_idx_hidden.id = "post_idx_hidden";
	  
	  document.body.appendChild(post_idx_hidden);
	  
	  modalTitle.textContent = post_title;
	  modalNickname.textContent = user_nickname;
	  modalLocation.textContent = post_location;
	  modalAnimal.textContent = post_animal;
	  modalContent.textContent = post_content;
	 
	  var commentList = document.querySelectorAll(".comment" + post_idx);
	  var postComment = document.querySelector(".comment");
	  
	  for (comment of commentList) {
		  var newComment = document.createElement("div");
		  var newComment_userNickname = document.createElement("div");
		  var newComment_content = document.createElement("div");
		  newComment.className = "comment_item";
		  newComment_userNickname.className = "comment_item_user";
		  newComment_content.className = "comment_item_content";
		  
		  newComment_userNickname.textContent = comment.querySelector(".comment_user_nickname").value;
		  newComment_content.textContent = comment.querySelector(".comment_content").value;
		  
		  newComment.appendChild(newComment_content);
		  newComment.appendChild(newComment_userNickname);
		  
		  postComment.appendChild(newComment);
	  }
	  
	  var modalCommentInputPostIdx = modalWrapper.querySelector(".comment_post_idx");
	  modalCommentInputPostIdx.value = post_idx;
}

function openmodal(e) {
    var modalWrapper = document.querySelector(".modal-wrapper");
    var body = document.querySelector(".section");
    var nav = document.querySelector(".navigation-bar");
    var profile = document.querySelector(".profile");
    var footer = document.querySelector(".footer");
    

    modalWrapper.classList.toggle("open");
    body.classList.toggle("blur-it");
    nav.classList.toggle("blur-it");
    profile.classList.toggle("blur-it");
    footer.classList.toggle("blur-it");
    return false;
}


/****************************************   MODIFY  **********************************************/

var modifybutton = document.querySelector(".modifybutton");
var completebutton = document.querySelector(".completebutton");
var modifyForm = document.querySelector("#modifyForm");
var modal_post_content = document.querySelector(".modal_post_content");
var modified_content = document.querySelector(".modified-content");



modifybutton.addEventListener('click', () => {
	  modifybutton.style.display = "none";
	  completebutton.style.display = "inline";
	  modifyForm.style.display = "block";
	  modal_post_content.style.display = "none";
	  modified_content.value = modal_post_content.innerText;
	  modified_content.focus();
	});


/****************************************   FEED  **********************************************/

var imagePath = "./images/";
var imageElements = document.querySelectorAll(".feed_img");

for (var i = 0; i < imageElements.length; i++) {
    var imageName = imageElements[i].getAttribute("src");
    imageName = imageName.trim();
    imageElements[i].src = imagePath + imageName;
}
/****************************************   PROFILE  **********************************************/
var profileimagePath = "./images/";
var profileimageElement = document.querySelector(".profile-image");

var profileimageName = profileimageElement.getAttribute("src");
profileimageName = profileimageName.trim();
profileimageElement.src = profileimagePath + profileimageName;