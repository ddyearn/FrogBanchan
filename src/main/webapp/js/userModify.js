$(function() {
    $(".error").click(function() {
        $(this).hide();
        $(this).siblings(".input").focus();
    });
});

var nicknameChecked = false;

function checkExistNickname() {
    const nickBox = document.getElementById("nickname");
    const nick = nickBox.value;

    if (nick) {
        $.ajax({
            type: "GET",
            url: "/join/user/nickname/" + nick,
            contentType: "application/json",
            error:  function(data) {
                alert("다시 시도해주세요.");
            },
            success: function(data) {
                if (data) {
                    alert("사용 가능한 닉네임입니다.");
                    nicknameChecked = true;
                } else {
                    alert("이미 존재하는 닉네임입니다.");
                    nicknameChecked = false;
                    nickBox.value = null;
                    nickBox.focus();
                }
            }
        });
    } else {
        nickBox.focus();
    }

    return nicknameChecked;
}

function checkExist() {
    if (nicknameChecked) {
        return true;
    } else {
        alert("닉네임 중복확인이 필요합니다.");
        return false;
    }
}
