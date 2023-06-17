function showPopup() {
    var popup = document.getElementById("popup");
    popup.style.display = "block";
}

function hidePopup() {
    var popup = document.getElementById("popup");
    popup.style.display = "none";
}

function deleteCircle() {
    var circle = document.getElementById("circle");
    circle.remove();
    hidePopup();
}

function addCircle() {
    var circleContainer = document.getElementById("circle-container");
    var circleCount = circleContainer.childElementCount;
    var circle = document.createElement("div");
    circle.id = "circle";
    circle.className = "circle";
    circle.onclick = showPopup;
    circle.style.left = circleCount * 110 + "px";
    circleContainer.insertBefore(circle, circleContainer.lastElementChild);
}