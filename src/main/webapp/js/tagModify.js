$(function() {
    let hateTagList = [];

    Array.prototype.forEach.call(document.getElementsByClassName("hateTag"), (element) => {
        hateTagList.push($(element).attr("id"));
    })

    $("#addHateBtn").click(function addHateTag() {
        let hateTag = $("input[name=hateAddTag]").val();
        if (hateTag && !hateTagList.find(function(element) {
            return element === hateTag
        })) {
            hateTagList.push(hateTag);
            $(".hateListBox3").append($("<span class='hateTag' id='" + hateTag + "'>" + hateTag + "</span>"));
        }
        $("input[name=hateAddTag]").val('');
    });

    $(document).on("click",".hateTag", function() {
        let tag = $(this).attr('id');
        hateTagList = hateTagList.filter((element) => element !== tag);
        $(this).remove();
    });

    $("input[type='text']").keydown(function() {
        if (event.keyCode === 13) {
            event.preventDefault();
        }
    });

    document.getElementById("hateAddForm").addEventListener("submit", saveTags);
    function saveTags() {
        $("#hateAddForm").append($("<input type='hidden' name='hateTags' value='" + hateTagList + "' />"));
        return true;
    }

});

function searchTag() {
    const keyword = document.getElementById("hateAddTag").value;
    if (keyword) {
        $.ajax({
            type: "GET",
            url: "/user/tag/search?keyword=" + keyword,
            contentType: "application/json",
            success: function(data) {
                    $(".searchResult").children().remove();
                $.each(data, function(index, searched) {
                    $(".searchResult").append($("<span class='btn btn-outline-warning searchedTag'>" + searched + "&nbsp;</span>"));
                });
            }
        });
    }
}