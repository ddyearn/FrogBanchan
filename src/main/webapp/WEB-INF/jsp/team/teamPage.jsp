<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>팀원 관리</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        
        .circle-container {
            display: flex;
            justify-content: flex-start;
            align-items: center;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
        }
        
        .circle {
            width: 100px;
            height: 100px;
            border-radius: 50%;
            background-color: lightblue;
            position: relative;
            text-align: center;
            line-height: 100px;
            font-size: 30px;
            cursor: pointer;
            transition: all 0.3s ease;
            margin-right: 10px;
        }
        
        .add-button {
            width: 100px;
            height: 100px;
            border-radius: 50%;
            background-color: rgba(0, 0, 0, 0.5);
            position: relative;
            text-align: center;
            line-height: 100px;
            font-size: 30px;
            cursor: pointer;
            color: white;
            margin-left: 10px;
        }
        
        .popup {
            width: 200px;
            height: 100px;
            background-color: white;
            border: 1px solid gray;
            position: absolute;
            top: 0;
            left: 50%;
            transform: translateX(-50%);
            display: none;
        }
        
        .delete-button {
            margin-top: 20px;
            text-align: center;
        }

        #recommend {
            width: 200px;
            height: 50px;
            background-color: lightgreen;
            position: absolute;
            top: 50px;
            left: 50%;
            transform: translateX(-50%);
            display: flex;
            justify-content: center;
            align-items: center;
            cursor: pointer;
            font-size: 20px;
        }
    </style>
    <script>
        function showPopup() {
            var popup = document.getElementById("popup");
            popup.style.display = "block";
        }
        
        function hidePopup() {
            var popup = document.getElementById("popup");
            popup.style.display = "none";
        }
        
        function deleteCircle() {
            var circle = document.getElementById("circle");
            circle.remove();
            hidePopup();
        }
        
        function addCircle() {
            var circleContainer = document.getElementById("circle-container");
            var circleCount = circleContainer.childElementCount;
            var circle = document.createElement("div");
            circle.id = "circle";
            circle.className = "circle";
            circle.onclick = showPopup;
            circle.style.left = circleCount * 110 + "px";
            circleContainer.insertBefore(circle, circleContainer.lastElementChild);
        }
    </script>
</head>
<body>
    <div id="recommend" onclick="location.href='/recommend/team'">
        추천하러가기
    </div>

    <div id="circle-container" class="circle-container">
        <div id="circle" class="circle" onclick="showPopup()">팀원1</div>
        <div id="circle" class="circle" onclick="showPopup()">팀원2</div>
        <div id="circle" class="circle" onclick="showPopup()">팀원3</div>
        <div id="circle" class="circle" onclick="showPopup()">팀원4</div>
        <div id="add-button" class="add-button" onclick="addCircle()">+</div>
    </div>
    
    <div id="popup" class="popup">
        <div class="delete-button">
            <button onclick="deleteCircle()">삭제</button>
        </div>
    </div>
</body>
</html>
