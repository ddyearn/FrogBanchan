<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="../frogTop.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>시간 선택</title>
	<link rel="stylesheet" type="text/css" href="../../css/reservation/timeSelectStyle.css">
</head>
<body>
    <form action="/reservation/form?placeId=${placeId}" method="post">
    <div class="popup-container">
        <div class="selection-window">
            <h2 class="title">시간 선택</h2>
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
                <button class="button" type="button" onclick="location.href='/reservation/calendar?placeId=${placeId}'">닫기</button>
                <input class="button" type="submit" value="선택" >
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
