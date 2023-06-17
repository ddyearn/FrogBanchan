$(function() {
    let selectedMember = [];
    let unselectedMember = [];
    let hateTagList = [];

    Array.prototype.forEach.call(document.getElementsByClassName("unselectBtn"), (element) => {
        selectedMember.push($(element).attr("id"));
    })
    Array.prototype.forEach.call(document.getElementsByClassName("selectBtn"), (element) => {
        unselectedMember.push($(element).attr("id"));
    })
    Array.prototype.forEach.call(document.getElementsByClassName("hateTag"), (element) => {
        hateTagList.push($(element).attr("id"));
    })

    $(document).on('click', '.selectBtn', function() {
        const clicked = $(this);
        const user = clicked.attr("id");
        const nickname = clicked.attr("name");

        unselectedMember = unselectedMember.filter((element) => element !== user);
        selectedMember.push(user);

        $.ajax({
            type: "GET",
            url: "/recommend/team/list-tags/" + user,
            contentType: "application/json",
            error:  function(data) {
               alert("태그를 불러오는 데 실패했습니다. 다시 시도해주세요.");
            },
            success: function(data) {
                $.each(data, function(index, hateTag) {
                    hateTagList.push(hateTag);
                    $(".hateListBox3").append($("<span class='hateTag addedHate' id='" + hateTag + "'>" + hateTag + "</span>"));
                });
                const boxStr = "<div class='memberCircle' id='" + user + "'> "
                            + "<div class='removeBadge'> "
                            + "<button class='badge rounded-pill text-bg-danger unselectBtn' id='" + user
                            + "' name='" + nickname + "' type='button'>X</button> </div> "
                            + "<p class='memberCircleText'>"+ nickname + "</p> </div>";
                $(".memberSelectedBox2").append($(boxStr));
                clicked.parent().parent().remove();
            }
        });
    });

    $(document).on('click', '.unselectBtn', function() {
        const clicked = $(this);
        const user = clicked.attr("id");
        const nickname = clicked.attr("name");

        selectedMember = selectedMember.filter((element) => element !== user);
        unselectedMember.push(user);

        const boxStr = "<div class='memberCircle'>"
                    + "<div class='addBadge'>"
                    + "<button class='badge rounded-pill text-bg-primary selectBtn' + id='" + user
                    + "' name='" + nickname +"' type='button'>+</button> </div>"
                    + "<p class='memberCircleText'>"+ nickname + "</p> </div>";
        $(".memberSelectBox").append($(boxStr));
        clicked.parent().parent().remove();

        $.ajax({
            type: "GET",
            url: "/recommend/team/list-tags/" + user,
            contentType: "application/json",
            success: function(data) {
                $.each(data, function(index, hateTag) {
                    const idx = hateTagList.findIndex(function(item) {return item === hateTag})
                    if (idx > -1) {
                        hateTagList.splice(idx, 1);
                        document.getElementById(hateTag).remove();
                    }
                });
            }
        });
    });

    $(document).on("click",".hateTag.addedHate", function() {
        const tag = $(this).attr('id');
        hateTagList = hateTagList.filter((element) => element !== tag);
        $(this).remove();
    });

    document.getElementById("recommendForm").addEventListener("submit", saveTags);
    function saveTags() {
        hateTagList = hateTagList.filter((v, i) => hateTagList.indexOf(v) === i);
        selectedMember = selectedMember.filter((v, i) => selectedMember.indexOf(v) === i);
        $("#recommendForm").children(".list").remove();
        $("#recommendForm").append($("<input class='list' type='hidden' name='hateTags' value='" + hateTagList + "' />"));
        $("#recommendForm").append($("<input class='list' type='hidden' name='selectedMember' value='" + selectedMember + "' />"));
        return true;
    }

});