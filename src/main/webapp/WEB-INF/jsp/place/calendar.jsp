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
  </style>
</head>
<body>
    <h1>
        <% 
          // DB에서 name 가져오기
          String placeName = "Unknown";
          try {
            // Place 테이블에서 name 필드 값 가져오기
            // ...
          } catch (Exception e) {
            e.printStackTrace();
          }
          out.println(placeName);
        %>
    </h1>
    <div class="container">
        <table>
        <tr>
            <th>Sun</th>
            <th>Mon</th>
            <th>Tue</th>
            <th>Wed</th>
            <th>Thu</th>
            <th>Fri</th>
            <th>Sat</th>
        </tr>

        <c:set var="calendar" value="${calendar}" />
        <% 
            // 현재 년도와 월 구하기
            java.util.Calendar cal = java.util.Calendar.getInstance();
            int year = cal.get(java.util.Calendar.YEAR);
            int month = cal.get(java.util.Calendar.MONTH) + 1;
            
            // 해당 월의 첫 번째 날짜의 요일 구하기 (1: 일요일, 2: 월요일, ... 7: 토요일)
            cal.set(year, month - 1, 1);
            int startDay = cal.get(java.util.Calendar.DAY_OF_WEEK);
            
            // 해당 월의 마지막 날짜 구하기
            int lastDay = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
            
            // 달력 표시
            int day = 1;
            for (int i = 1; i <= 6; i++) { // 최대 6주까지 표시
            out.println("<tr>");
            for (int j = 1; j <= 7; j++) {
                if ((i == 1 && j < startDay) || day > lastDay) {
                out.println("<td>&nbsp;</td>");
                } else {
                out.println("<td>" + day + "</td>");
                day++;
                }
            }
            out.println("</tr>");
            
            if (day > lastDay) {
                break;
            }
            }
        %>
        </table>
    </div>
    <div class="button-container">
        <button class="button">select date</button>
        <button class="button">check reservation</button>
    </div>
</body>
</html>
