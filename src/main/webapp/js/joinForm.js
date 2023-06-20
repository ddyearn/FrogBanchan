$(document).ready(function() {
    $(".error").click(function() {
        $(this).hide();
        $(this).siblings(".input").focus();
    });
});

function checkExistUsername() {
    alert('중복 체크');
}

function checkExistNickname() {
    alert('중복 체크');
}