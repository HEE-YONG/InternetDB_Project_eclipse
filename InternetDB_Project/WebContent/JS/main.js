

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
        trigger.addEventListener("click", openmodal);
    });

    var closeButton = document.querySelector(".btn-close");
    closeButton.addEventListener("click", function () {
        modalWrapper.classList.remove("open");
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

/***********************************   Reset & New Post   **************************************/

function loadFile(input) {
    let file = input.files[0];
    let newImage = document.createElement("img");

    newImage.src = URL.createObjectURL(file);

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
