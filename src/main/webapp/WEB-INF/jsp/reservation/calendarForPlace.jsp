<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            background-color: rgb(206, 246, 199);
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
            font-weight: bold;
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
            opacity: 1.0 !important;
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
    </style>
</head>

<body>

<form action="/reservation/time/forplace" method="post">
<div class="container">
    <div class="button-container">
        <button class="button" onclick="goToPreviousMonth()">&lt;&lt;</button>
        <button class="button" onclick="goToNextMonth()">&gt;&gt;</button>
    </div>    
    <h1>
        <%= request.getAttribute("placename") %>
    </h1>
    
    <table>
        <tr>
            <th>일</th>
            <th>월</th>
            <th>화</th>
            <th>수</th>
            <th>목</th>
            <th>금</th>
            <th>토</th>
        </tr>
        <%
        String[] availableDays = (String[]) request.getAttribute("availableDays"); // Get the 'days' array from the controller
        java.util.Set<String> availableDaysSet = new java.util.HashSet<>(java.util.Arrays.asList(availableDays)); 
        String[] reservedDays = (String[]) request.getAttribute("reservedDays"); // Get the 'days' array from the controller
        java.util.Set<String> reservedDaysSet = new java.util.HashSet<>(java.util.Arrays.asList(reservedDays)); 

        //달력 날짜 가져오기    
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(java.util.Calendar.DAY_OF_MONTH, 1); // Set the starting day to the 1st of the current month

        int currentMonth = cal.get(java.util.Calendar.MONTH); // Get the current month
        int totalDays = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH); // Total number of days in the current month

        int firstDayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK); // Get the first day of the week for the starting day

        while (cal.get(java.util.Calendar.MONTH) == currentMonth) {
            out.println("<tr>");

            // Print empty cells for the days before the starting day
            for (int i = 1; i < firstDayOfWeek; i++) {
                out.println("<td>&nbsp;</td>");
            }

            for (int i = firstDayOfWeek; i <= 7; i++) {
                int currentDay = cal.get(java.util.Calendar.DAY_OF_MONTH);

                //예약이 된 날짜라면 동시에 사업자가 가능하다고 선택한 날짜
                if(reservedDaysSet.contains(String.valueOf(currentDay))) {
                    out.println("<td style='opacity: 1.0;background-color: lightgreen;color: red;' onclick='selectTime(this)'>" + currentDay + "</td>");
                }
                else if (availableDaysSet.contains(String.valueOf(currentDay))) {
                    out.println("<td style='opacity: 1.0;color: red;' onclick='selectTime(this)'>" + currentDay + "</td>"); // Set transparency to 100%
                }
                else {
                    out.println("<td style='opacity: 0.4;' onclick='selectTime(this)'>" + currentDay + "</td>"); // Set transparency to 50%
                }

                cal.add(java.util.Calendar.DAY_OF_MONTH, 1); // Move to the next day

                if (currentDay == totalDays) {
                    break; // Stop if we reach the last day of the month
                }
            }

            out.println("</tr>");

            firstDayOfWeek = 1; // Reset the first day of the week for subsequent weeks
        }
        %>

    </table>
</div>


<div class="button-container">
    <input type="hidden" id="selectedDay" name="selectedDay" value=""> 
    <!-- controller에서 받을때 name과 일치해야함 -->
    <input class="button" type="submit" value="예약 가능 시간 선택(예약 확인)">
</div>

</form>


<script>
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
        var selectedDay = element.innerText;
        document.getElementById('selectedDay').value = selectedDay;
    }
</script>
</body>
</html>
