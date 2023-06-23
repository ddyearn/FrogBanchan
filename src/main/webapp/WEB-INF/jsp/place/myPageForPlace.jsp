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
            width: 450px;
            height: 500px;
            background-color: rgb(244, 255, 237);
            padding: 20px;
            margin-right: 20px;
            left: -20px;
            position: relative;

            font-family: 'Poor Story';
            font-style: normal;
            font-weight: 200;
            font-size: 30px;
            line-height: 30px;
            display: flex;
            align-items: center;
            
            color: #000000;

            border: 1px solid #000000;
            border-radius: 30px;
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
            background-color: rgb(196, 250, 114);
            border: none;
            margin-right: 10px;
            cursor: pointer;
            font-size: 16px;
            border: 2px solid black;
            border-radius: 20px;
            box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
            font-family: 'Poor Story';
            font-style: normal;
            font-weight: 200;
            font-size: 30px;
            line-height: 30px;
            display: flex;
            align-items: center;
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
            border-bottom: 2px solid black;
            padding-bottom: 5px;
            width: 400px; 
            position: relative;
            top: 50px;
        }        
        
    </style>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../../../css/place/placeMyPage.css">
</head>
<body>
    <div id="mainbox">
        <div id="titleWrap">
        마이페이지
        <br/>
            <h6 id="backbutton" onclick="location.href='/user/myPage'">뒤로가기</h6>
        </div>
    <div id="rectangle1">
        <div id="content">
            <div id="bulletin-board">
                <div id="info">
                    INFO
                </div>
                <div id="info-details">
                    <p>&nbsp;ID &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;  <span/>   - - - - - -    &nbsp; &nbsp; ${place.placeId}</p>
                    <p>&nbsp;상호명 &nbsp;&nbsp; <span/>  - - - - - -   &nbsp; ${place.name}</p>
                    <p>&nbsp;주소 &nbsp;&nbsp; </p><p> &nbsp; ${place.address}</p>
                </div>
            </div>

            <div>
                <div id="actions">
                    <button id="modify-btn" onclick="location.href='/place/modify'">정보 수정</button>
                    <button id="calendar-btn" onclick="location.href='/reservation/calendar/forplace'">예약 현황(캘린더)</button>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
