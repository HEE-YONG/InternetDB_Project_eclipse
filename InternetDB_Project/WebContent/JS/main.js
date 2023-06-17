

document.addEventListener("DOMContentLoaded", function () {
    var pageWrapper = document.querySelector(".page-wrapper");
    var body = document.querySelector(".section");
    var nav = document.querySelector(".navigation-bar");
    var badge = document.querySelector(".plus_badge");


    // filter
    let storedAnimalValue = localStorage.getItem("inputAnimalFilter");
    let storedRegionValue = localStorage.getItem("inputRegionFilter");
    if (storedAnimalValue && storedRegionValue) {
        let radioAnimalElement = document.getElementById(storedAnimalValue);
        let radioRegionElement = document.getElementById(storedRegionValue);
        radioAnimalElement.checked = true;
        radioRegionElement.checked = true;
    }

    let filterRadio = document.querySelectorAll(".filter-radio");

    filterRadio.forEach(function (radio) {
        radio.addEventListener("click", applyFilter);
    });


    // feed-modal
    var modalWrapper = document.querySelector(".modal-wrapper");
    var triggers = document.querySelectorAll(".trigger");

    triggers.forEach(function (trigger) {
    	trigger.addEventListener("click", viewModalContent);   
        trigger.addEventListener("click", openmodal);
    });

    var closeButton = document.querySelector(".btn-close");
    closeButton.addEventListener("click", function () {
        modalWrapper.classList.remove("open");
        document.querySelector(".comment").innerHTML="";
        body.classList.remove("blur-it");
        nav.classList.remove("blur-it");
        badge.classList.remove("blur-it");
    });


    // new-post-modal
    var postModalWrapper = document.querySelector(".post-modal-wrapper");
    var postTriggers = document.querySelectorAll(".post-trigger");

    postTriggers.forEach(function (trigger) {
        trigger.addEventListener("click", newPostModalUp);
    });

    var postCloseButton = document.querySelector(".post-btn-close");
    postCloseButton.addEventListener("click", function () {
        postModalWrapper.classList.remove("open");
        body.classList.remove("blur-it");
        nav.classList.remove("blur-it");
        badge.classList.remove("blur-it");
        
    });


    // new-post-modal reset
    let resetBtn = document.getElementById("reset");
    resetBtn.addEventListener("click", reset);
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
	  
	  var modalWrapper = document.querySelector(".modal-wrapper");
	  var modalImage = modalWrapper.querySelector(".modal-img img");
	  modalImage.src = "./images/" + post_picture;
	  
	  var modalTitle = modalWrapper.querySelector(".modal_post_title");
	  var modalNickname = modalWrapper.querySelector(".modal_user_nickname");
	  var modalLocation = modalWrapper.querySelector(".modal_post_location");
	  var modalAnimal = modalWrapper.querySelector(".modal_post_animal");
	  var modalContent = modalWrapper.querySelector(".modal_post_content");
	  
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
    var badge = document.querySelector(".plus_badge");

    modalWrapper.classList.toggle("open");
    body.classList.toggle("blur-it");
    nav.classList.toggle("blur-it");
    badge.classList.toggle("blur-it");
    return false;
}

function newPostModalUp() {
    var postModalWrapper = document.querySelector(".post-modal-wrapper");
    var body = document.querySelector(".section");
    var nav = document.querySelector(".navigation-bar");
    var badge = document.querySelector(".plus_badge");

    postModalWrapper.classList.toggle("open");
    body.classList.toggle("blur-it");
    nav.classList.toggle("blur-it");
    badge.classList.toggle("blur-it");
    return false;
}

function checkComment(){
	var input_comment = document.getElementById("input_comment").value;
	
	if (input_comment.trim() === "") {
		alert("댓글을 입력해주세요.");
		return false;
	} else {
		return true;
	}
}

/***********************************   Reset & New Post   **************************************/

function loadFile(input) {
    let file = input.files[0];
    let newImage = document.createElement("img");

    newImage.src = URL.createObjectURL(file);
    newImage.style.width = "500px";
    newImage.style.height = "500px";
    
    
    let container = document.querySelector(".new-image");
    container.appendChild(newImage);
    container.style.display = "block";

    document.querySelector(".new-image-input").style.display = "none";
}

function reset() {
    document.querySelector(".new-image-input").style.display = "block";
    document.querySelector(".new-image img").remove();
    return false;
}

/**************************************   filter   ********************************************/

function applyFilter() {
    let selectedAnimalRadio = document.querySelector('input[name="animal"]:checked');
    let selectedRegionRadio = document.querySelector('input[name="region"]:checked');
    if (selectedAnimalRadio && selectedRegionRadio) {
        let selectedAnimalValue = selectedAnimalRadio.value;
        let selectedRegionValue = selectedRegionRadio.value;
        localStorage.setItem("inputAnimalFilter", selectedAnimalValue);
        localStorage.setItem("inputRegionFilter", selectedRegionValue);
    }

    let filterForm = document.getElementById("filter-form");
    filterForm.submit();
}

/****************************************   FEED  **********************************************/

var imagePath = "./images/";
var imageElements = document.querySelectorAll(".feed_img");

for (var i = 0; i < imageElements.length; i++) {
    var imageName = imageElements[i].getAttribute("src");
    imageName = imageName.trim();
    imageElements[i].src = imagePath + imageName;
}
