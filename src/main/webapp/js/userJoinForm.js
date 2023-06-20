$(function() {
    $(".error").click(function() {
        $(this).hide();
        $(this).siblings(".input").focus();
    });
});

var usernameChecked = false;
var nicknameChecked = false;

function checkExistUsername() {
    const userBox = document.getElementById("username");
    const user = userBox.value;

    if (user) {
        $.ajax({
            type: "GET",
            url: "/join/user/username/" + user,
            contentType: "application/json",
            error:  function(data) {
                alert("다시 시도해주세요.");
            },
            success: function(data) {
                if (data === "true") {
                    alert("사용 가능한 아이디입니다.");
                    usernameChecked = true;
                } else {
                    alert("이미 존재하는 아이디입니다.");
                    usernameChecked = false;
                    userBox.value = null;
                    userBox.focus();
                }
            }
        });
    } else {
        userBox.focus();
    }

    return usernameChecked;
}

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

function checkExists() {
    let str = "";
    if (usernameChecked && nicknameChecked) {
        return true;
    } else {
        if (!usernameChecked) {
            str += "아이디 ";
        }
        if (!nicknameChecked) {
            str += "닉네임 "
        }
        alert(str + "중복확인이 필요합니다.");
        return false;
    }
}
