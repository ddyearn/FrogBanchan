var menuChecked = false;

function searchMenu() {
    const menuBox = document.getElementById("search");
    const keyword = menuBox.value;

    if (keyword) {
        $.ajax({
            type: "GET",
            url: "/placemenu/create/search?keyword=" + keyword,
            contentType: "application/json",
            error:  function(data) {
                alert("다시 시도해주세요.");
            },
            success: function(data) {
                if (data === "false") {
                    alert("죄송합니다. 해당 메뉴가 존재하지 않습니다.");
                    document.getElementById("menuId").value = null;
                    menuChecked = false;
                    menuBox.value = null;
                    menuBox.focus();
                } else {
                    menuChecked = true;
                    document.getElementById("menuId").value = data;
                }
            }
        });
    }
}

function checkExistMenu() {
    if (menuChecked) {
        return true;
    } else {
        alert('메뉴를 확인해주세요.');
        return false;
    }
}