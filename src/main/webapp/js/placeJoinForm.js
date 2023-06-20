$(function() {
    $(".error").click(function() {
        $(this).hide();
        $(this).siblings(".input").focus();
    });
});

var placeIdChecked = false;

function checkExistPlaceId() {
    const placeBox = document.getElementById("placeId");
    const place = placeBox.value;

    if (place) {
        $.ajax({
            type: "GET",
            url: "/join/place/placeId/" + place,
            contentType: "application/json",
            error:  function(data) {
                alert("다시 시도해주세요.");
            },
            success: function(data) {
                if (data === "true") {
                    alert("사용 가능한 아이디입니다.");
                    placeIdChecked = true;
                } else {
                    alert("이미 존재하는 아이디입니다.");
                    placeIdChecked = false;
                    placeBox.value = null;
                    placeBox.focus();
                }
            }
        });
    } else {
        placeBox.focus();
    }

    return placeIdChecked;
}

function checkExist() {
    if (placeIdChecked) {
        return true;
    } else {
        alert("아이디 중복확인이 필요합니다.");
        return false;
    }
}
