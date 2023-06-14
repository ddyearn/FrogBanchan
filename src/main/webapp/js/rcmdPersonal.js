$(function() {
    let likeTagList = [];
    $("#addLikeBtn").click(function addLikeTag() {
        let likeTag = $("input[name=likeAddTag]").val();
        if (likeTag && !likeTagList.find(function(element) {
            return element === likeTag
        })) {
            likeTagList.push(likeTag);
            $(".likeListBox3").append($("<span class='likeTag' id='" + likeTag + "'>" + likeTag + "</span>"));
        }
        $("input[name=likeAddTag]").val('');
    });

    $(document).on("click",".likeTag", function() {
        let tag = $(this).attr('id');
        likeTagList = likeTagList.filter((element) => element !== tag);
        $(this).remove();
    });


    let hateTagList = [];
    $("#addHateBtn").click(function addHateTag() {
        let hateTag = $("input[name=hateAddTag]").val();
        if (hateTag && !hateTagList.find(function(element) {
            return element === hateTag
        })) {
            hateTagList.push(hateTag);
            $(".hateListBox3").append($("<span class='hateTag addedHate' id='" + hateTag + "'>" + hateTag + "</span>"));
        }
        $("input[name=hateAddTag]").val('');
    });

    $(document).on("click",".hateTag.addedHate", function() {
        let tag = $(this).attr('id');
        hateTagList = hateTagList.filter((element) => element !== tag);
        $(this).remove();
    });


    document.getElementById("recommendForm").addEventListener("submit", saveTags);
    function saveTags() {
        let likeTags = '';
        likeTagList.forEach(function(tag) {
            likeTags += tag + ",";
        });
        $("#recommendForm").append($("<input type='hidden' name='likeTags' value='" + likeTags + "' />"));
        let hateTags = '';
        hateTagList.forEach(function(tag) {
            hateTags += tag + ",";
        });
        $("#recommendForm").append($("<input type='hidden' name='hateTags' value='" + hateTags + "' />"));
        return true;
    }

});