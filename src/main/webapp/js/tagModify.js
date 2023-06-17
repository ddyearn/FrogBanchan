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

    document.getElementById("hateAddForm").addEventListener("submit", saveTags);
    function saveTags() {
        $("#hateAddForm").append($("<input type='hidden' name='hateTags' value='" + hateTagList + "' />"));
        return true;
    }

});