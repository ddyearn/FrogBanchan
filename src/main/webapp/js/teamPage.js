function checkDelete(url){
    var answer;
    answer = confirm("팀을 삭제하시겠습니까?");
    if (answer == true) {
        location = url;
    }
}