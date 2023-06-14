$(function() {
    let hateTagList = [];
    let selectedMember = [];
    let unselectedMember = [];

    $(".selectBtn").click(function selectMember() {
        const selected = $(this);
        const user = selected.attr("id");
        const nickname = selected.attr("name");
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
                            + "' name='" + nickname + "'>X</button> </div> "
                            + "<p class='memberCircleText'>"+ nickname + "</p> </div>";
                $(".memberSelectedBox2").append($(boxStr));
                selected.parent().parent().remove();
            }
        });
    });

    $(".unselectBtn").click(function selectMember() {

    });

    $(document).on("click",".hateTag.addedHate", function() {
        let tag = $(this).attr('id');
        hateTagList = hateTagList.filter((element) => element !== tag);
        $(this).remove();
    });

    document.getElementById("recommendForm").addEventListener("submit", saveTags);
    function saveTags() {
        let hateTags = '';
        hateTagList.forEach(function(tag) {
            hateTags += tag + ",";
        });
        $("#recommendForm").append($("<input type='hidden' name='hateTags' value='" + hateTags + "' />"));
        return true;
    }

});