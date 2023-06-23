<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="../frogTop.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>Calendar</title>
    <style>
        html, body {
            height: 100%;
            margin: 0;
            padding: 0;
        }

        body {
            background-color: white;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            font-family: Arial, sans-serif;
        }

        .container {
            background-color: #69c956;
            border-radius: 10px;
            padding: 20px;
            margin-top: 20px;
            width: 800px; /* 달력의 가로 크기 조정 */
        }

        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            padding: 10px;
            text-align: center;
            border: 1px solid white;
            color: white;
        }

        th {
            background-color: #49a03e;
        }

        td:hover {
            background-color: #52c34d;
            cursor: pointer;
        }

        .button-container {
            display: flex;
            justify-content: center;
            margin-top: 20px;
        }

        .button {
            background-color: #49a03e;
            color: white;
            padding: 10px 20px;
            border-radius: 5px;
            margin: 0 10px;
            cursor: pointer;
        }

        .button:hover {
            background-color: #52c34d;
        }

        .transparent {
            opacity: 0.5; /* 투명도 설정 */
        }

        .transparent-day {
            opacity: 1; /* 투명도 설정 */
        }

         /* Styles for the selection window */
         .popup-container {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.5);
            display: flex;
            justify-content: center;
            align-items: center;
        }
    
        .popup-container .selection-window {
            width: 300px;
            height: 300px;
            background-color: #eee;
            padding: 20px;
        }
    
        .popup-container table {
            width: 100%;
            border-collapse: collapse;
            background-color: white;
        }
    
        .popup-container th, .popup-container td {
            padding: 10px;
            text-align: center;
            border: 1px solid #ccc;
            cursor: pointer;
        }

        .popup-container .selected {
            background-color: green !important;
            color: white !important;
        }
    
        .popup-container .button-container {
            display: flex;
            justify-content: center;
            margin-top: 20px;
        }
    
        .popup-container .button {
            background-color: #49a03e;
            color: white;
            padding: 10px 20px;
            border-radius: 5px;
            margin: 0 10px;
            cursor: pointer;
        }    

        .reserved {
            background-color: gray;
            cursor: not-allowed;
        }
    </style>
</head>

<body>
    <form id="form" action="" method="post">
    <div class="popup-container">
        <div class="selection-window">
            <h2>Time Selection</h2>
            <table>
                <% 
                String[] availableTimes = (String[]) request.getAttribute("availableTimes"); // Get the 'days' array from the controller
                java.util.Set<String> availableTimesSet = new java.util.HashSet<>(java.util.Arrays.asList(availableTimes)); 
                String[] reservedTimes = (String[]) request.getAttribute("reservedTimes"); // Get the 'days' array from the controller
                java.util.Set<String> reservedTimesSet = new java.util.HashSet<>(java.util.Arrays.asList(reservedTimes)); 
                %>
                <tr>
                    <% 
                    for(int i = 12; i <= 14; i++){
                        if(reservedTimesSet.contains(String.valueOf(i))) {
                            out.println("<td style='background-color: lightgreen;color: red;' onclick='selectTime(this, \"r\")'>" + i + ":00" + "</td>");
                        }
                        else if (availableTimesSet.contains(String.valueOf(i))) {
                            out.println("<td style='color: red;' onclick='selectTime(this, \"a\")'>" + i  + ":00" + "</td>"); 
                        }
                        else {
                            out.println("<td style='color: black;' onclick='selectTime(this, \"n\")'>" + i + ":00" + "</td>"); 
                        }                            
                    } %>
                </tr>    
                <tr>
                    <% 
                    for(int i = 16; i <= 18; i++){
                        if(reservedTimesSet.contains(String.valueOf(i))) {
                            out.println("<td style='background-color: lightgreen;color: red;' onclick='selectTime(this, \"r\")'>" + i + ":00" + "</td>");
                        }
                        else if (availableTimesSet.contains(String.valueOf(i))) {
                            out.println("<td style='color: red;' onclick='selectTime(this, \"a\")'>" + i  + ":00" + "</td>"); 
                        }
                        else {
                            out.println("<td style='color: black;' onclick='selectTime(this, \"n\")'>" + i + ":00" + "</td>"); 
                        }                            
                    } %>
                </tr>
                <tr>
                    <% 
                    for(int i = 19; i <= 21; i++){
                        if(reservedTimesSet.contains(String.valueOf(i))) {
                            out.println("<td style='background-color: lightgreen;color: red;' onclick='selectTime(this, \"r\")'>" + i + ":00" + "</td>");
                        }
                        else if (availableTimesSet.contains(String.valueOf(i))) {
                            out.println("<td style='color: red;' onclick='selectTime(this, \"a\")'>" + i  + ":00" + "</td>"); 
                        }
                        else {
                            out.println("<td style='color: black' onclick='selectTime(this, \"n\")'>" + i + ":00" + "</td>"); 
                        }                            
                    } %>
                </tr>
            </table>          
            <div class="button-container">
                <% String selectedDay = (String) request.getAttribute("selectedDay"); %>
                <input type="hidden" id="selectedDay" name="selectedDay" value="${selectedDay}">
                <input type="hidden" id="selectedTime" name="selectedTime" value="">
                <input type="hidden" id="flag" name="flag" value="">
                <input class="button" type="submit" value="선택">
                <button class="button" type="button" onclick="goBack();">Close</button>
            </div>
        </div>
    </div>
    </form>

<script>
    // Function to open the pop-up window
    function openPopup() {
        document.querySelector('.popup-container').style.display = 'flex';
    }

    // Function to close the pop-up window
    function closePopup() {
        document.querySelector('.popup-container').style.display = 'none';
    }

    function goBack() {
        var previousPageUrl = "/reservation/calendar/forplace"; // Replace with the desired URL of the previous page
        window.location.href = previousPageUrl;
    }

    function invalidate() {
        window.location.href = window.location.href;
    }
    // Function to select a time
    function selectTime(element, flag) {
        // Reset the previously selected time
        var selectedElement = document.querySelector('.selected');
        if (selectedElement) {
            selectedElement.classList.remove('selected');
        }

        // Set the new selected time
        element.classList.add('selected');

        // Update the hidden input field value
        var selectedTime = element.innerText;
        document.getElementById('selectedTime').value = selectedTime;

        if(flag.includes("r")) {
            document.getElementById('flag').value = 'reservation';
            document.getElementById('form').action = '/reservation/result/forplace';
        }
        if(flag.includes("n")) {
            document.getElementById('flag').value = 'none';
            document.getElementById('form').action = '/reservation/calendar/forplace';
        }
    }

</script>
</body>
</html>
