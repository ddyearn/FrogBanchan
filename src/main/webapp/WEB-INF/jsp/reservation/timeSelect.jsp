<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
        }
    
        .popup-container th, .popup-container td {
            padding: 10px;
            text-align: center;
            border: 1px solid #ccc;
            cursor: pointer;
        }
    
        .popup-container .reserved {
            background-color: gray;
            cursor: not-allowed;
        }
    
        .selected {
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
    <form action="/reservation/form?placeId=${placeId}" method="post">
    <div class="popup-container">
        <div class="selection-window">
            <h2>Time Selection</h2>
            <table>
                <% 
                String[] reservedTimes = (String[]) request.getAttribute("reservedTimes"); 
                java.util.Set<String> reservedTimesSet = new java.util.HashSet<>(java.util.Arrays.asList(reservedTimes)); 
                %>
                <tr>
                    <% 
                    for(int i = 12; i <= 14; i++){
                        if(reservedTimesSet.contains(String.valueOf(i))) {
                            out.println("<td style='opacity: 40%;background-color: gray;pointer-events: none;'>" + i + ":00" + "</td>");
                        } else {
                            out.println("<td style='color: black;' onclick='selectTime(this)'>" + i + ":00" + "</td>"); 
                        }                            
                    } %>
                </tr>    
                <tr>
                    <% 
                    for(int i = 16; i <= 18; i++){
                        if(reservedTimesSet.contains(String.valueOf(i))) {
                            out.println("<td style='opacity: 40%;background-color: gray;pointer-events: none;'>" + i + ":00" + "</td>");
                        } else {
                            out.println("<td style='color: black;' onclick='selectTime(this)'>" + i + ":00" + "</td>"); 
                        }                           
                    } %>
                </tr>
                <tr>
                    <% 
                    for(int i = 19; i <= 21; i++){
                        if(reservedTimesSet.contains(String.valueOf(i))) {
                            out.println("<td style='opacity: 40%;background-color: gray;pointer-events: none;'>" + i + ":00" + "</td>");
                        } else {
                            out.println("<td style='color: black;' onclick='selectTime(this)'>" + i + ":00" + "</td>"); 
                        }                            
                    } %>
                </tr>
            </table>          
            <div class="button-container">
                <input type="hidden" id="selectedDay" name="selectedDay" value="${selectedDay}">
                <input type="hidden" id="selectedTime" name="selectedTime" value="">
                <input class="button" type="submit">
                <button class="button" type="button" onclick="goBack()">Close</button>
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
        window.history.back();
    }

    // Function to select a time
    function selectTime(element) {
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
    }

</script>
</body>
</html>
