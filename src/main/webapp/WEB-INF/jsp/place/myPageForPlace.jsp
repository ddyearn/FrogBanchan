<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>MYPAGE</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }

        #header {
            text-align: center;
            margin-top: 20px;
            font-size: 30px;
        }

        #content {
            display: flex;
            justify-content: center;
            margin-top: 50px;
        }

        #bulletin-board {
            width: 300px;
            height: 400px;
            background-color: whitesmoke;
            padding: 20px;
            margin-right: 20px;
            font-weight: bold;
            font-size:17px;
        }

        #info {
            text-align: center;
            font-weight: bold;
            font-size: 30px;
            margin-bottom: 20px;
        }

        #info-details {
            margin-left: 10px;
        }

        #actions {
            display: flex;
            justify-content: center;
            margin-top: 20px;
        }

        #modify-btn, #calendar-btn {
            font-weight: bold;
            padding: 40px 30px;
            background-color: greenyellow;
            border: none;
            margin-right: 10px;
            cursor: pointer;
            font-size: 16px;
        }

        #actions {
            display: flex;
            justify-content: center;
            align-items: center; /* Add this line */
            margin-top: 20px;
            height: 100%; /* Add this line */
        }
        #info-details {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: flex-start;
            height: 100%;
            margin: 10px 0;
            border-bottom: 2px solid black;
            padding-bottom: 5px;
            width: 200px; 
        }        
        
    </style>
</head>
<body>
    <div id="header">
        <h1>MYPAGE</h1>
        <a href="#"><img src="back_icon.png" alt="Back" width="30" height="30"></a>
    </div>

    <div id="content">
        <div id="bulletin-board">
            <div id="info">
                INFO
            </div>
            <div id="info-details">
                <p>ID    ${place.placeId}</p><p/><p/>
                <p>상호명   <span/>  ${place.name}</p><p/><p/>
                <p>주소  <span/>   ${place.address}</p><p/><p/>
            </div>
        </div>

        <div>
            <div id="actions">
                <button id="modify-btn">정보 수정</button>
                <button id="calendar-btn" onclick="location.href='/reservation/calendar'">예약 현황(캘린더)</button>
            </div>
        </div>
    </div>
</body>
</html>
