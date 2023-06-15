<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" />
<!DOCTYPE html>
<html>
<head>
    <title>HistoryForm</title>
    <style>

        .star {
            position: relative;
            font-size: 32px;
            color: #ddd;
        }

        .star input {
            width: 100%;
            height: 100%;
            position: absolute;
            left: 0;
            opacity: 0;
        }

        .star span {
            width: 0;
            position: absolute;
            left: 0;
            color: red;
            overflow: hidden;
            pointer-events: none;
        }

        .rate { display: inline-block;border: 0;margin-right: 15px;}
        .rate > input {display: none;}
        .rate > label {float: right;color: #ddd}
        .rate > label:before {display: inline-block;font-size: 1rem;padding: .3rem .2rem;margin: 0;cursor: pointer;font-family: FontAwesome;content: "\f005 ";}
        .rate .half:before {content: "\f089 "; position: absolute;padding-right: 0;}
        .rate input:checked ~ label,
        .rate label:hover,.rate label:hover ~ label { color: #f73c32 !important;  }
        .rate input:checked + .rate label:hover,
        .rate input input:checked ~ label:hover,
        .rate input:checked ~ .rate label:hover ~ label,
        .rate label:hover ~ input:checked ~ label { color: #f73c32 !important;  }
    </style>
</head>
<body>
<h2>기록 수정</h2>

<form:form modelAttribute="historyForm" method="post">
    <div>${history.placeId}</div> <!--장소 아이디 -> 장소이름으로 바꾸기-->

    <div>의 음식은 어떠셨나구리? 별점을 남겨주시구리~!</div>
    <label for="score">별점</label>:
<%--    <fieldset class="rate">--%>
<%--        <input type="radio" id="rating10" name="rating" value="10"><label for="rating10" title="5점"></label>--%>
<%--        <input type="radio" id="rating9" name="rating" value="9"><label class="half" for="rating9" title="4.5점"></label>--%>
<%--        <input type="radio" id="rating8" name="rating" value="8"><label for="rating8" title="4점"></label>--%>
<%--        <input type="radio" id="rating7" name="rating" value="7"><label class="half" for="rating7" title="3.5점"></label>--%>
<%--        <input type="radio" id="rating6" name="rating" value="6"><label for="rating6" title="3점"></label>--%>
<%--        <input type="radio" id="rating5" name="rating" value="5"><label class="half" for="rating5" title="2.5점"></label>--%>
<%--        <input type="radio" id="rating4" name="rating" value="4"><label for="rating4" title="2점"></label>--%>
<%--        <input type="radio" id="rating3" name="rating" value="3"><label class="half" for="rating3" title="1.5점"></label>--%>
<%--        <input type="radio" id="rating2" name="rating" value="2"><label for="rating2" title="1점"></label>--%>
<%--        <input type="radio" id="rating1" name="rating" value="1"><label class="half" for="rating1" title="0.5점"></label>--%>
<%--    </fieldset>--%>
    <form:input path="history.score" value="${history.score}" readonly="false"/> <br/>

    <div>무슨 메뉴를 먹었는지 알려주시구리~!</div>

    <label for="placeMenuId">메뉴</label>:
    <form:input path="history.placeMenuId" value="${history.placeMenuId}" readonly="true"/> <br/>

    <input type="submit" value="수정하기" />

</form:form>
<script>
    const drawStar = (target) => {
        document.querySelector(`.star span`).style.width = `${target.value * 10}%`;
    }
</script>
</body>
</html>