

document.addEventListener("DOMContentLoaded", function () {
    var pageWrapper = document.querySelector(".page-wrapper");
    var body = document.querySelector(".section");
    var nav = document.querySelector(".navigation-bar");
    var profile = document.querySelector(".profile");



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
        body.classList.remove("blur-it");
        nav.classList.remove("blur-it");
        profile.classList.remove("blur-it");
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
	 
	  console.log(post_picture);
}

function openmodal(e) {
    var modalWrapper = document.querySelector(".modal-wrapper");
    var body = document.querySelector(".section");
    var nav = document.querySelector(".navigation-bar");
    var profile = document.querySelector(".profile");
    

    modalWrapper.classList.toggle("open");
    body.classList.toggle("blur-it");
    nav.classList.toggle("blur-it");
    profile.classList.toggle("blur-it");
    return false;
}

/****************************************   FEED  **********************************************/

var imagePath = "./images/";
var imageElements = document.querySelectorAll(".feed_img");

for (var i = 0; i < imageElements.length; i++) {
    var imageName = imageElements[i].getAttribute("src");
    imageName = imageName.trim();
    imageElements[i].src = imagePath + imageName;
}