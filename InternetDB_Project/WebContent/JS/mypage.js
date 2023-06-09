

document.addEventListener("DOMContentLoaded", function () {
    var pageWrapper = document.querySelector(".page-wrapper");
    var body = document.querySelector(".section");
    var nav = document.querySelector(".navigation-bar");
    var badge = document.querySelector(".plus_badge");



    // feed-modal
    var modalWrapper = document.querySelector(".modal-wrapper");
    var triggers = document.querySelectorAll(".trigger");

    triggers.forEach(function (trigger) {
        trigger.addEventListener("click", openmodal);
    });

    var closeButton = document.querySelector(".btn-close");
    closeButton.addEventListener("click", function () {
        modalWrapper.classList.remove("open");
        body.classList.remove("blur-it");
        nav.classList.remove("blur-it");
        badge.classList.remove("blur-it");
    });

});

/**************************************   MODAL   ********************************************/

function openmodal(e) {
    var modalWrapper = document.querySelector(".modal-wrapper");
    var body = document.querySelector(".section");
    var nav = document.querySelector(".navigation-bar");
    var badge = document.querySelector(".plus_badge");
    
    var postIdx = null
    postIdx = e.target.alt;
    var modalImage = modalWrapper.querySelector(".modal-img img");
    modalImage.src = "./images/potato.jpg";

    console.log(postIdx);

    modalWrapper.classList.toggle("open");
    body.classList.toggle("blur-it");
    nav.classList.toggle("blur-it");
    badge.classList.toggle("blur-it");
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